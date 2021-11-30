from serial.tools.list_ports import comports
ports = comports()

finalMessage = ''

for port, desc, hwid in sorted(ports):
    scan = "{}: {} [{}]".format(port, desc, hwid)
    if 'Arduino' in scan:
        finalMessage = f'[-] You will want to use "{port}" as your port.'
    print(f'[+] {scan}')
print(finalMessage)