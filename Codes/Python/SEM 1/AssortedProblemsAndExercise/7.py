#number 7

def ok(words):
    length:list = []
    for i in range(len(words)):
        length.append(len(words[i]))
    print(length)




ok(["Yes","No","Elephant","Laptop"])