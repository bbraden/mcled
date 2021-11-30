# mcled
A simple **minecraft** plugin that allows you to control
**LED** **lights** with **arduino**.

[`Demo Video`](https://www.youtube.com/watch?v=5oqp-Ey1aQA)

# features

- a custom GUI within minecraft  
usage: `/led gui`
![alt text](https://raw.githubusercontent.com/bbraden/mcled/master/src/main/resources/screenshots/gui1.png)


- multiple toggleable options  
usage:  
  `/led walk` - enables or disables walk feature  
  `/led sight` - enables or disables sight feature  
  `/led click` - enables or disables click feature  
  `/led damage` - enables or disables damage feature  
  `/led death` - enables or disables death feature  
  `/led respawn` - enables or disables respawn feature  
# instructions
necessary tools:

[`Arduino`](https://www.amazon.com/Arduino-A000066-ARDUINO-UNO-R3/dp/B008GRTSV6/)

[`IR transmitter`](https://www.amazon.com/Gikfun-Digital-Receiver-Transmitter-Arduino/dp/B0816P2545/)

[`LED lights`](https://www.amazon.com/Livingpai-Changing-Bluetooth-Control-Bedroom/dp/B08M9GYQDM/)

First you will need to plug your **arduino** into your computer that the 
minecraft server will be hosted on. Then you can use the **Arduino** **IDE** 
to determine the _port_ that the arduino is on. Copy down that _port_, for 
example `COM5`. Then you want to go to the variables file in 
`me.braden.variables` and alter the _port_ to whatever the _port_ 
that you had gathered from the **Arduino IDE** earlier. In the case that you are using the plugin directly 
without source files, simply enter in your _port_ when the plugin prompts 
you to on initialization.
## Authors

- [@braden](https://www.github.com/bbraden)


message me on **discord** `braden#9999` for help
