from dbtools import *
list = []

def on():
    print('on')
def off():
    print('off')

def red():
    print('red')
def green():
    print('green')
def blue():
    print('blue')
def yellow():
    print('yellow')
def purple():
    print('purple')
def orange():
    print('orange')
def white():
    print('white')

def onMessage(message):
    if message == 'on':
        on()
    elif message == 'off':
        off()

    elif message == 'red':
        red()
    elif message == 'green':
        green()
    elif message == 'red':
        green()
    elif message == 'blue':
        blue()
    elif message == 'orange':
        orange()
    elif message == 'yellow':
        yellow()
    elif message == 'purple':
        purple()
    elif message == 'white':
        white()
    else:
        print('invalid')


while True:
    things = db.find({})
    for thing in things:
        message = thing['message']
        if thing not in list:
            list.append(thing)
            onMessage(message)