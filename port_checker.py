from serial.tools.list_ports import comports
ports = comports()

print('please input desired port')
inputPort = input('[+] ')

for port, desc, hwid in sorted(ports):
    scan = "{}: {} [{}]".format(port, desc, hwid)
    if inputPort in scan:
        if inputPort in scan:
            print(f'[-] {scan}')
        if 'Arduino' in scan:
            print(f'[-] Port Valid For Arduino')
        elif 'Arduino' not in scan:
            print('[!] Port Invalid For Arduino')
        else:
            print('[!] Error')
        break