#include <IRremote.h>
IRsend irsend;
char userInput;
const int wait = 1000;
void setup()
{
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
  for (int i=0; i<15; ++i) {
    irsend.sendNEC(0x47DF5AA5, 32);
    delay(50);
  }
}

void loop() {
  if(Serial.available()> 0){

    userInput = Serial.read();               // read user input

      if(userInput == 'o'){
        digitalWrite(LED_BUILTIN, HIGH);
        irsend.sendNEC(0x47DF649B, 32);
      }
      else if(userInput == 'x'){
        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DFA45B, 32);
      }
      else if(userInput == 'r'){
        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DF38C7, 32);
      }
      else if(userInput == 'g'){
        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DF4AB5, 32);
      }
      else if(userInput == 'b'){

        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DFCA35, 32);
      }
      else if(userInput == 'w'){

        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DF40BF, 32);
      }
      else if(userInput == 'y'){

        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DF30CF, 32);
      }
      else if(userInput == 'u'){

        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DF807F, 32);
      }
      else if(userInput == 'p'){

        digitalWrite(LED_BUILTIN, LOW);
        irsend.sendNEC(0x47DF00FF, 32);
      }
      else {
        Serial.println("error");
      }


  }

}