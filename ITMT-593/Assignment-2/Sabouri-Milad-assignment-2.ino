// Simon Game
// Developed By Milad Sabouri
// Embedded Systems Course
// Illinois Tech - Spring 2018

#include <LiquidCrystal.h>

LiquidCrystal lcd(7, 8, 9, 10, 11, 12);

const int redLEDPin = 2;
const int greenLEDPin = 3;
const int yellowLEDPin = 4;
const int blueLEDPin = 5;
const int soundPin = 6;
const int pushBtn = A4;

const int FAIL = 0;
const int PASS = 1;
const int VICTORY = 2;
const int WELCOME = 3;
const int INTRO = 4;
const int START = 5;
const int STARTED = 6;
const int RESTART = 7;
const int GAMEOVER = 8;
const int ONTIME = 10;
const int OVERTIME = 11;

unsigned long time;

const int level1[] = {1, 1, 1, 1};
const int level2[] = {1, 2, 1, 1};
const int level3[] = {2, 1, 1, 2};
const int level4[] = {3, 1, 2, 1};
const int level5[] = {3, 1, 2, 2};

int btnRed = A0;
int btnGreen = A1;
int btnYellow = A2;
int btnBlue = A3;

int redValue = 0;
int greenValue = 0;
int yellowValue = 0;
int blueValue = 0;

int level = 1;
int userInputCount = 0;
int sounds[] = {262, 294, 330, 349};
int gamePattern[4];
int userPattern[4] = {0, 0, 0, 0};

void setup() {
  Serial.begin(9600);
  lcd.begin(16, 2);
  showLCD(WELCOME);
  delay(2000);
  showLCD(INTRO);
  delay(4000);
  showLCD(START);

  //Set LED pins as OUTPUT
  pinMode(redLEDPin, OUTPUT);
  pinMode(greenLEDPin, OUTPUT);
  pinMode(yellowLEDPin, OUTPUT);
  pinMode(blueLEDPin, OUTPUT);
  pinMode(soundPin, OUTPUT);

  digitalWrite(redLEDPin, LOW);
  digitalWrite(greenLEDPin, LOW);
  digitalWrite(yellowLEDPin, LOW);
  digitalWrite(blueLEDPin, LOW);

  int pinBtn;
  while (true) {
    pinBtn = analogRead(pushBtn);
    if (pinBtn > 1000) {
      break;
    }
  }//while
}

void loop() {
  userPattern[0] = 0;
  userPattern[1] = 0;
  userPattern[2] = 0;
  userPattern[3] = 0;

  showLCD(STARTED);

  generatePattern();
  showPattern();
//  getPattern();
  if ( getPattern() == ONTIME) {
    Serial.println("getPattern == 1");
    if ( comparePatterns() == PASS ) {
      level++;
      Serial.print("LEVEL:");
      Serial.print(level);
      if (level > 5) {
        victory();
        restartGame();
        level = 1;
      } else {
        showResult(PASS);
      } //else - level > 10
    } else {
      Serial.println("Compare Fail");
      showResult(FAIL);
    } // else compare
  } else{
      Serial.println("getPattern == 0");
      showLCD(GAMEOVER);
      tone(soundPin, 700);
      delay(1000);
      noTone(soundPin);
      restartGame();
      level = 1;
  }

} //loop

void generatePattern() {
  switch (level) {
    case 1:
      memcpy(gamePattern, level1, sizeof gamePattern);
      userInputCount = 4;
      break;
    case 2:
      memcpy(gamePattern, level2, sizeof gamePattern);
      userInputCount = 5;
      break;
    case 3:
      memcpy(gamePattern, level3, sizeof gamePattern);
      userInputCount = 6;
      break;
    case 4:
      memcpy(gamePattern, level4, sizeof gamePattern);
      userInputCount = 7;
      break;
    case 5:
      memcpy(gamePattern, level5, sizeof gamePattern);
      userInputCount = 8;
      break;
  }//switch
}

void showPattern() {
  for (int i = 0; i < 4; i++) {
    int repeat = 0;
    while ( repeat < gamePattern[i]) {
      switch (i) {
        case 0:
          digitalWrite(redLEDPin, HIGH);
          tone(soundPin, sounds[0]);
          delay(500);
          digitalWrite(redLEDPin, LOW);
          noTone(soundPin);
          break;
        case 1:
          digitalWrite(greenLEDPin, HIGH);
          tone(soundPin, sounds[1]);
          delay(500);
          digitalWrite(greenLEDPin, LOW);
          noTone(soundPin);
          break;
        case 2:
          digitalWrite(yellowLEDPin, HIGH);
          tone(soundPin, sounds[2]);
          delay(500);
          digitalWrite(yellowLEDPin, LOW);
          noTone(soundPin);
          break;
        case 3:
          digitalWrite(blueLEDPin, HIGH);
          tone(soundPin, sounds[3]);
          delay(500);
          digitalWrite(blueLEDPin, LOW);
          noTone(soundPin);
          break;
      } // switch
      repeat++;
      delay(500);
    } //while
  } //for
} //showPattern

int getPattern() {
  int output = ONTIME;
  time = millis();
  int counter = 0;
  while (counter < userInputCount) {
    if (millis() < time + 5000) {
      redValue = analogRead(btnRed);
      greenValue = analogRead(btnGreen);
      yellowValue = analogRead(btnYellow);
      blueValue = analogRead(btnBlue);

      //    Serial.print("Red: ");
      //    Serial.print(redValue);
      //    Serial.print(" * Green: ");
      //    Serial.print(greenValue);
      //    Serial.print(" * Yellow: ");
      //    Serial.print(yellowValue);
      //    Serial.print(" * Blue: ");
      //    Serial.println(blueValue);

      if (redValue > 200) {
        digitalWrite(redLEDPin, HIGH);
        tone(soundPin, sounds[0]);
        userPattern[0]++;
        counter++;
        Serial.print("RED Pushed - ");
        Serial.print("Counter: ");
        Serial.println(counter);
      } else {
        digitalWrite(redLEDPin, LOW);
      }

      if (greenValue > 200) {
        digitalWrite(greenLEDPin, HIGH);
        tone(soundPin, sounds[1]);
        userPattern[1]++;
        counter++;
        Serial.print("GREEN Pushed - ");
        Serial.print("Counter: ");
        Serial.println(counter);
      } else {
        digitalWrite(greenLEDPin, LOW);
      }

      if (yellowValue > 200) {
        digitalWrite(yellowLEDPin, HIGH);
        tone(soundPin, sounds[2]);
        userPattern[2]++;
        counter++;
        Serial.print("YELLOW Pushed - ");
        Serial.print("Counter: ");
        Serial.println(counter);
      } else {
        digitalWrite(yellowLEDPin, LOW);
      }

      if (blueValue > 200) {
        digitalWrite(blueLEDPin, HIGH);
        tone(soundPin, sounds[3]);
        userPattern[3]++;
        counter++;
        Serial.print("BLUE Pushed - ");
        Serial.print("Counter: ");
        Serial.println(counter);
      } else {
        digitalWrite(blueLEDPin, LOW);
      }
      delay(100);
      noTone(soundPin);
//      Serial.print("Counter: ");
//      Serial.println(counter);
    } else {//if(millis)
      Serial.println("Time goes larger that 10 seconds");
      output = OVERTIME;
      break;
    }
  } // while
  digitalWrite(redLEDPin, LOW);
  digitalWrite(greenLEDPin, LOW);
  digitalWrite(yellowLEDPin, LOW);
  digitalWrite(blueLEDPin, LOW);
  Serial.print("Output: ");
  Serial.println(output);
  return output;
} //getPattern

int comparePatterns() {
  for (int i = 0; i < 4; i++) {
    Serial.println(" *** *** ");
    Serial.print("gamePattern: ");
    Serial.print(gamePattern[0]);
    Serial.print(gamePattern[1]);
    Serial.print(gamePattern[2]);
    Serial.println(gamePattern[3]);
    Serial.print("userPattern: ");
    Serial.print(userPattern[0]);
    Serial.print(userPattern[1]);
    Serial.print(userPattern[2]);
    Serial.println(userPattern[3]);
    if (gamePattern[i] != userPattern[i]) {
      Serial.println(" **Compare Fail** ");
      return FAIL;
    }//if
  }//for
  Serial.print(" **Compare PASS** ");
  return PASS;
}//comparePatterns

void showResult(int state) {
  if (state == PASS) {
    showLCD(PASS);
    for (int i = 0; i < 3; i++) {
      tone(soundPin, 300);
      delay(500);
      noTone(soundPin);
    }
  }
  if (state == FAIL) {
    showLCD(FAIL);
    tone(soundPin, 600);
    delay(1000);
    noTone(soundPin);
  }
}//showResult

void victory() {
  showLCD(VICTORY);
  tone(soundPin, 800);
  delay(2000);
  noTone(soundPin);
}

void showLCD(int state) {
  lcd.clear();
  lcd.setCursor(0, 0);

  switch (state) {
    case 0: //FAIL
      lcd.print("Level ");
      lcd.print(level);
      lcd.setCursor(0, 1);
      lcd.print("FAIL :-(");
      break;
    case 1: //PASS
      lcd.print("Level ");
      lcd.print(level);
      lcd.setCursor(0, 1);
      lcd.print("PASS :-)");
      break;
    case 2: //VICTORY
      lcd.print("*Congratulation*");
      lcd.setCursor(0, 1);
      lcd.print("You Win  :-D");
      break;
    case 3: //WELCOME
      lcd.print("Welcome");
      lcd.setCursor(0, 1);
      lcd.print("Loading ...");
      break;
    case 4: //INTRO
      lcd.print("Simon Game");
      lcd.setCursor(0, 1);
      lcd.print("Dev. By Milad");
      break;
    case 5: //START
      lcd.print("Press START");
      lcd.setCursor(0, 1);
      lcd.print("Begin the game");
      break;
    case 6: //STARTED
      lcd.print("Level ");
      lcd.print(level);
      break;
    case 7: //RESTART
      lcd.print("Restart?");
      lcd.setCursor(0, 1);
      lcd.print("Press START");
      break;
    case 8: //GAMEOVER
      lcd.print("Game Over");
      lcd.setCursor(0, 1);
      lcd.print("Press START");
      break;
  }//switch
}//showLCD

void restartGame() {
  showLCD(RESTART);
  int pinBtn;
  while (true) {
    pinBtn = analogRead(pushBtn);
    if (pinBtn > 1000) {
      break;
    }
  }//while
}//restartGame


