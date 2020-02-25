""" f = open('newfile.txt','w')
for i in range(10):
    f.write('This is line %d\n\n' % (i+1))
f.close()

while True:
    if f.mode == 'r':
        print('File already in mode r, reading..')
        f1 = f.readlines()
        for i in f1:
            print(i)
        break
    else:
        print('Converting to read...')
        f = open('newfile.txt','r')
        continue
 """

file = open('newfile.txt','r')


s = file.read()
print(s[8])
