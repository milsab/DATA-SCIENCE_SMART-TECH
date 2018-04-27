  /*
  Implemented By: Milad Sabouri
  Final Project
  Embedded Systems
  ITMT-593
  Spring 2018
  Illinois Institute of Technology
*/

#include <SPI.h>
#include <Ethernet.h>
#include <SD.h>
#include <Arduino.h>
#include <DHT.h>
#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"
#include "Code.h"

#include <Wire.h>
#include <Adafruit_GFX.h>
#include "Adafruit_LEDBackpack.h"

Adafruit_AlphaNum4 alpha4 = Adafruit_AlphaNum4();

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


//**** DHT-22 Sensor ****
//Constants
#define DHTPIN 6     // what pin we're connected to
#define DHTTYPE DHT22   // DHT 22  (AM2302)
DHT dht(DHTPIN, DHTTYPE); //// Initialize DHT sensor for normal 16mhz Arduino

//Variables
int chk;
float hum;  //Stores humidity value
float temp; //Stores temperature value

//**** LED ****
char displaybuffer[4] = {' ', ' ', ' ', ' '};

void setup()
{  
  while (!Serial) {
    ;
  }

  delay(500);
  Serial.begin(9600);
  
  alpha4.begin(0x70); 
  
  dht.begin();
  Serial.println(FreeRam());
  
  //Initializing the SD Card
//  Serial.print(F("Initializing SD card..."));
//
//  if (!SD.begin(4)) {
//    Serial.println(F("initialization SD failed!"));
//    return;
//  }
//  Serial.println(F("initialization SD done."));
  
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
    
    delay(2000);
    //Read data and store it to variables hum and temp
    hum = dht.readHumidity();
    temp= dht.readTemperature();
    //Print temp and humidity values to serial monitor
    Serial.print(F("Humidity: "));
    Serial.print(hum);
    Serial.print(" %, Temp: ");
    Serial.print(temp);
    Serial.println(F(" Celsius"));
    delay(2000); //Delay 2 sec.

  Serial.println(F("Send data to Web Server"));
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
          client.print(F("<body style='text-align:center; border: solid black 2px; line-height: 200%;'><h1>Embedded Systems - Final Project</h1><h2 style='font-family: Pacifico, sans-serif;'>Developed By: Milad Sabouri</h2>"));
          client.print(F("<h3 style='color:blue'>Timestamp: "));
          client.print(millis());
          client.println(F("</h3>"));
          client.print(F("<table style='background-color:powderblue; border: dotted black 3px; text-align:left; width:400px; margin: 30px auto; padding: 10px 20px;'><tr style='border-bottom:solid black 2px;'><th>Name</th><th>Value</th></tr><tr><td><b style='color:red'>Temperature: </b></td><td>")); 
          client.print(temp);
          client.println(F(" Celsius </td></tr>"));

          client.print(F("<tr><td><b style='color:green'>Humidity: </b></td><td>"));
          client.print(hum);
          client.println(F(" % </td></tr>"));
            
          client.println(F("</table>"));
          if(temp < 10) client.println(F("<b>Cold</b>"));
          if(temp > 10 && temp < 20) client.println(F("<b>Mild</b>"));
          if(temp > 20) client.println(F("<b>Hot</b>"));
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

    // Show Data on LED
  char sign = '+';
  char degree = 'C';
  Serial.print(F("sign: "));
  Serial.println(sign);
  if(temp < 0){
    sign = '-';
  }
  else{
    sign = '+';
  }

  
//  int analog = analogRead(A0);
//  Serial.print(F("analog: "));
//  Serial.println(analog);
  if(analogRead(A0) == 0) {
    temp = temp * 1.8 + 32;
    degree = 'F';
  }
  int i = temp * 100;
  // or i = x*100.0f + 0.5f is round to nearest desired.
  if ((i < 0)) { i = -1 * i;}
  char buf[5];
  sprintf(buf, "%04d", i);


  // scroll down display
  displaybuffer[0] = sign;
  displaybuffer[1] = buf[0];
  displaybuffer[2] = buf[1];
  displaybuffer[3] = degree;
 
  // set every digit to the buffer
  alpha4.writeDigitAscii(0, displaybuffer[0]);
  alpha4.writeDigitAscii(1, displaybuffer[1]);
  alpha4.writeDigitAscii(2, displaybuffer[2]);
  alpha4.writeDigitAscii(3, displaybuffer[3]);
 
  // write it out!
  alpha4.writeDisplay();
  delay(200);

//  Serial.println(F("Send Data to SD..."));
//  //Write info in dataTemperature.txt on the SD Card
//  myFile = SD.open("dataTemperature.txt", FILE_WRITE); 
//  if (myFile) {
//    Serial.println(F("----------------------"));
//    Serial.print(F("Writing to data.txt..."));
//    myFile.print(F("***** Timestamp: "));
//    myFile.print(millis());
//    myFile.println(F(" *****"));
//    myFile.print(F("Temperature: ")); 
//    myFile.print(temp);
//    myFile.println(F(" Celsius"));
//    
//    myFile.print(F("Humidity: "));
//    myFile.print(hum);
//    myFile.println(F(" %"));
//      
//    myFile.println();
//    // close the file:
//    myFile.close();
//    Serial.println(F("Data Saved on SD Card."));
//    Serial.println(F("----------------------"));
//  } else {
//    // if the file didn't open, print an error:
//    Serial.println(F("error opening dataTemperature.txt"));
//  }

  // Bluetooth
  char inputs[BUFSIZE+1];
  // Send characters to Bluefruit
  Serial.println(F("Transmit with Bluethooth... "));
  ble.print(F("AT+BLEUARTTX="));
  ble.print(F(" Temperature: ")); 
  ble.print(temp);
  ble.print(F(" Humidity: "));
  ble.print(hum);
  ble.print(F(" % "));
  ble.println();
  Serial.println(F("======================"));
  // check response stastus
  if (! ble.waitForOK() ) {
//    Serial.println(F("Failed to send?"));
  }
  delay(5000);
}
