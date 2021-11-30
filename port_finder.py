import serial.tools.list_ports
ports = serial.tools.list_ports.comports()

finalMessage = ''

for port, desc, hwid in sorted(ports):
    message = "{}: {} [{}]".format(port, desc, hwid)
    if 'Arduino' in message:
        finalMessage = f'You will want to use "{port}" as your port.'
    if 'arduino' in message:
            finalMessage = f'You will want to use "{port}" as your port.'
    print(message)
print(finalMessage)