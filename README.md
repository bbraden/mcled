# mcled
A simple **minecraft** plugin that allows you to control
**LED** **lights** with **arduino**.

[![Everything Is AWESOME](https://github.com/bbraden/mcled/blob/master/src/main/resources/screenshots/demo.gif?raw=true)](https://www.youtube.com/watch?v=5oqp-Ey1aQA "Demo Video")  
**_(hint: click for full demo)_**
# features

- a custom GUI within minecraft that serves a LED lights remote control   
usage: `/led gui`
  ![alt text](https://raw.githubusercontent.com/bbraden/mcled/master/src/main/resources/screenshots/gui1.png)

# **multiple toggleable options**

`walk`
- using `/led walk` will toggle the walk feature on or off. This feature  
  is able to detect when the players is standing on a certain color of wool and  
  is able to use that information to change the color of the LED lights.

`sight`
- using `/led sight` will toggle the sight feature on or off. This feature  
  is able to detect when the players is looking at a certain color of wool and  
  is able to use that information to change the color of the LED lights.

`click`
- using `/led click` will toggle the click feature on or off. This feature  
  is able to detect when the players right-clicks on a certain color of wool and  
  is able to use that information to change the color of the LED lights.

`damage`
- using `/led damage` will toggle the damage feature on or off. This feature  
  is able to detect when the player gets damaged and uses that information to  
  change the color of the LED lights to red (indicating loss of health) before  
  shortly switching back to green (indicating health).  

`death`
- using `/led death` will toggle the death feature on or off. This feature  
  is able to detect when the player dies and switches the LED lights to red  
  (indicating death), and the LED lights only turn green again once the player  
  clicks the respawn button.

`respawn`
- using `/led respawn` will toggle the respawn feature on or off. This feature  
  is able to detect when the players respawns and uses that information to change  
  the color of the LED lights back to green after death.

## Authors

- [@braden](https://www.github.com/bbraden)


message me on **discord** `braden#9999` for help
