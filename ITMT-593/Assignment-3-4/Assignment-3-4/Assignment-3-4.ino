  /*
  Implemented By: Milad Sabouri
*/

#include <SPI.h>
#include <Ethernet.h>
#include <SD.h>
#include <Arduino.h>
#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"
#include "Config.h"

#if SOFTWARE_SERIAL_AVAILABLE
  #include <SoftwareSerial.h>
#endif

    #define FACTORYRESET_ENABLE         0
    #define MINIMUM_FIRMWARE_VERSION    "0.6.6"
    #define MODE_LED_BEHAVIOUR          "MODE"

SoftwareSerial bluefruitSS = SoftwareSerial(BLUEFRUIT_SWUART_TXD_PIN, BLUEFRUIT_SWUART_RXD_PIN);
Adafruit_BluefruitLE_UART ble(bluefruitSS, BLUEFRUIT_UART_MODE_PIN,
                      BLUEFRUIT_UART_CTS_PIN, BLUEFRUIT_UART_RTS_PIN);

void error(const __FlashStringHelper*err) {
  Serial.println(err);
  while (1);
}

byte mac[] = {
  0x90, 0xA2, 0xDA, 0x0F, 0x4C, 0xD0
};
IPAddress ip(192, 168, 1, 38);
EthernetServer server(80);

File myFile;

const float ArduinoVoltage = 5.00;
const float ArduinoResolution = ArduinoVoltage / 1024;
const float resistorValue = 10000.0;
int threshold = 3;
int inputPin = A0;
int ouputPin = A5;

void setup()
{  
  while (!Serial) {
    ;
  }
  delay(500);
  Serial.begin(9600);
  
  Serial.println(FreeRam());
  
  //Initializing the SD Card
  Serial.print(F("Initializing SD card..."));

  if (!SD.begin(4)) {
    Serial.println(F("initialization SD failed!"));
    return;
  }
  Serial.println(F("initialization SD done."));
  
  // start the Ethernet connection and the server:
  Ethernet.begin(mac, ip);
  server.begin();
  Serial.print(F("server is at "));
  Serial.println(Ethernet.localIP());
  
  pinMode(ouputPin, OUTPUT);
  pinMode(inputPin, INPUT);

  //bluetooth
  if ( !ble.begin(VERBOSE_MODE) )
  {
//    error(F("Couldn't find Bluefruit, make sure it's in CoMmanD mode & check wiring?"));
  }
  if ( FACTORYRESET_ENABLE )
  {
    /* Perform a factory reset to make sure everything is in a known state */
    Serial.println(F("Performing a factory reset: "));
    if ( ! ble.factoryReset() ){
      error(F("Couldn't factory reset"));
    }
  }

  /* Disable command echo from Bluefruit */
  ble.echo(false);
  ble.info();
  ble.verbose(false);  // debug info is a little annoying after this point!

  /* Wait for connection */
//  while (! ble.isConnected()) {
//      delay(500);
//  }

  // LED Activity command is only supported from 0.6.6
  if ( ble.isVersionAtLeast(MINIMUM_FIRMWARE_VERSION) )
  {
    // Change Mode LED Activity
    Serial.println(F("******************************"));
    Serial.println(F("Change LED activity to " MODE_LED_BEHAVIOUR));
    ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
    Serial.println(F("******************************"));
  }
}

void loop()
{
  int analogValue=0;
  int oldAnalogValue=1000;
  float returnVoltage=0.0;
  float resistance=0.0;
  double Siemens;
  float TDS=0.0;
  
  while(((oldAnalogValue-analogValue)>threshold) || (oldAnalogValue<50))
  {
   oldAnalogValue = analogValue;
   digitalWrite( ouputPin, HIGH );
   delay(10); // allow ringing to stop
   analogValue = analogRead( inputPin );
   digitalWrite( ouputPin, LOW );
  }
  
  Serial.print(F("Return voltage: "));
  returnVoltage = analogValue *ArduinoResolution;  
  Serial.print(returnVoltage);
  Serial.println(F(" Volts"));
  
  Serial.print(F("Resistance: "));
  resistance = ((5.00 * resistorValue) / returnVoltage) - resistorValue;
  Serial.print(resistance);
  Serial.println(F(" Ohms"));
  
  Serial.print(F("Conductivity: "));
  Siemens = 1.0/(resistance/1000000);
  Serial.print(Siemens);
  Serial.println(F(" MicroSiemens"));
  Serial.print(F("Total Dissolved Solids: "));
  TDS = 500 * (Siemens/1000);
  Serial.print(TDS);
  Serial.println(F(" PPM"));
  if(returnVoltage>4.9) Serial.println(F("Are you sure this isn't metal?"));
  
  //Send DATA to the Web Server
  EthernetClient client = server.available();
  if (client) {
    Serial.println(F("----------------------"));
    Serial.println(F("New Client"));
    // an http request ends with a blank line
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        Serial.write(c);
        // if you've gotten to the end of the line (received a newline
        // character) and the line is blank, the http request has ended,
        // so you can send a reply
        if (c == '\n' && currentLineIsBlank) {
          // send a standard http response header
          client.println(F("HTTP/1.1 200 OK"));
          client.println(F("Content-Type: text/html"));
          client.println(F("Connection: close"));  // the connection will be closed after completion of the response
          client.println(F("Refresh: 5"));  // refresh the page automatically every 5 sec
          client.println();
          client.println(F("<!DOCTYPE HTML>"));
          client.println(F("<html><head><link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet'><title>Embedded Systems</title></head>"));
          // output the value of each analog input pin
//          client.println(F("<h2>"));
          client.print(F("<body style='text-align:center; border: solid black 2px; line-height: 200%;'><h1>Embedded Systems - Assignmet 3 & 4</h1><h2 style='font-family: Pacifico, sans-serif;'>Developed By: Milad Sabouri</h2>"));
          client.print(F("<h3 style='color:blue'>Timestamp: "));
          client.print(millis());
          client.println(F("</h3>"));
//          client.println(F("<br/>"));
          client.print(F("<table style='background-color:powderblue; border: dotted black 3px; text-align:left; width:400px; margin: 30px auto; padding: 10px 20px;'><tr style='border-bottom:solid black 2px;'><th>Name</th><th>Value</th></tr><tr><td><b style='color:orange'>Return voltage: </b></td><td>")); 
          client.print(returnVoltage);
          client.println(F(" Volts </td></tr>"));

//          client.println(F("<br/>"));
          client.print(F("<tr><td><b style='color:red'>Resistance: </b></td><td>"));
          client.print(resistance);
          client.println(F(" Ohms </td></tr>"));
            
//          client.println(F("<br/>"));
          client.print(F("<tr><td><b style='color:green'>Conductivity: </b></td><td>"));
          client.print(Siemens);
          client.println(F(" MicroSiemens</tr></td>"));

//          client.println(F("<br/>"));
          client.print(F("<tr><td><b style='color:purple'>Total Dissolved Solids:</b></td><td>"));
          client.print(TDS);
          client.println(F(" PPM</td><tr></table>"));
          if(returnVoltage<1) client.println(F("<b>Pure Water</b>"));
          if(returnVoltage>1) client.println(F("<b>Ionized Water</b>"));
          if(returnVoltage>4.9) client.println(F("Are you sure this isn't metal?"));
          client.println();
          client.println(F("</body></html>"));
          break;
        }
        if (c == '\n') {
          // you're starting a new line
          currentLineIsBlank = true;
        } else if (c != '\r') {
          // you've gotten a character on the current line
          currentLineIsBlank = false;
        }
      }
    }
    // give the web browser time to receive the data
    delay(1);
    // close the connection:
    client.stop();
    Serial.println("client disconnected");
  }

  //Write info in Data.txt on the SD Card
  myFile = SD.open("data.txt", FILE_WRITE); 
  if (myFile) {
    Serial.println(F("----------------------"));
    Serial.print(F("Writing to data.txt..."));
    myFile.print(F("***** Timestamp: "));
    myFile.print(millis());
    myFile.println(F(" *****"));
    myFile.print(F("Voltage: ")); 
    myFile.print(returnVoltage);
    myFile.println(F(" Volts"));
    
    myFile.print(F("Resistance: "));
    myFile.print(resistance);
    myFile.println(F(" Ohms"));
      
    myFile.print(F("Conductivity: "));
    myFile.print(Siemens);
    myFile.println(F(" MicroSiemens"));
    myFile.print(F("Total Dissolved Solids: "));
    myFile.print(TDS);
    myFile.println(F(" PPM"));
    if(returnVoltage>4.9) myFile.println(F("Are you sure this isn't metal?"));
    myFile.println();
    // close the file:
    myFile.close();
    Serial.println(F("Data Saved on SD Card."));
    Serial.println(F("----------------------"));
  } else {
    // if the file didn't open, print an error:
    Serial.println(F("error opening data.txt"));
  }

  // Bluetooth
  char inputs[BUFSIZE+1];
  // Send characters to Bluefruit
  Serial.println(F("Transmit with Bluethooth... "));
  ble.print(F("AT+BLEUARTTX="));
  ble.print(F(" V: ")); 
  ble.print(returnVoltage);
  ble.print(F(" R: "));
  ble.print(resistance);
  ble.print(F(" C: "));
  ble.print(Siemens);
  ble.print(F(" TDS: "));
  ble.print(TDS);
  ble.println();
  Serial.println(F("======================"));
  // check response stastus
  if (! ble.waitForOK() ) {
//    Serial.println(F("Failed to send?"));
  }
  delay(5000);
}
