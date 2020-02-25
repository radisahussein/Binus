#Numbering Lines No. 2
lines = []
with open ('file1.txt',mode='r',encoding='utf8') as f:
    read = f.read().split('\n')
    n = 0
    while n < len(read):
        read[n] = str(n) + '. ' + read[n] + '\n'
        print(read[n])
        n += 1
        

