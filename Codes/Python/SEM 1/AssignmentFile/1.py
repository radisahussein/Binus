#Programming Exercise for Files No.1
import string

f = open('file1.txt',encoding='utf8')
rd = f.read().lower().replace('\n',"")
new = ''
for i in rd:
    if i not in string.punctuation:
        new += i
    
rd = new
lst = rd.split(' ')
dictionary = {}
for i in lst:
    if i not in dictionary:
        dictionary[i] = 1
    
    else:
        dictionary[i] += 1

hapax = []

for i in dictionary:
    if dictionary[i] == 1:
        hapax.append(i)

print('Hapax:')
for word in hapax:
    print(word)