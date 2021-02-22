t = int(input())

for _ in range(0, t):
    p = input()
    n = int(input())
    
    ptime = ''
    ptime = p[0:2] + p[3:5] 
    if p[0:2] == '12' and p[6:8] == 'AM':
        ptime = ''
        ptime += '00'
        ptime += p[3:5]
    
    if p[0:2] != '12' and p[6:8] == 'PM':
        ptime = ''
        ptime += str(int(p[0:2]) + 12)
        ptime += p[3:5]

    output = ''

    for i in range(0, n):
        ai = input()
        starttime = ai[0:2] + ai[3:5]
        endtime = ai[9:11] + ai[12:14]

        if ai[0:2] == '12' and ai[6:8] == 'AM':
            starttime = ''
            starttime += '00'
            starttime += ai[3:5]
        
        if ai[0:2] != '12' and ai[6:8] == 'PM':
            starttime = ''
            starttime += str(int(ai[0:2])+12)
            starttime += ai[3:5]

        if ai[9:12] == '12' and ai[15:17] == 'AM':
            endtime = ''
            endtime += '00'
            endtime += ai[12:14]

        if ai[9:12] != '12' amd ai[15:17] == 'PM':
            endtime = ''
            endtime += str(int(ai[9:12]) + 12)
            endtime += ai[12:14]

        if(endtime > starttime):
            output += '0'
            continue
        
        if endtime >= ptime and starttime <= ptime:
            output += '1'
            continue
        else
            output += '0'

    print(output)


