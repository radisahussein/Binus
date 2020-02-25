#Split No.3
import functools

with open ('file1.txt',mode='r',encoding='utf8') as f:
    badchars = [',','.',':','!','?',"'",'"',';']
    read = f.read().split()
    read = list(map(len,read))
    s = functools.reduce(lambda x,y:x+y,read)
    print(s/len(read))
    