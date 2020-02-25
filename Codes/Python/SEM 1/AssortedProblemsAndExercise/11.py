import sys
def char_freq(words:str):
    words.replace(" ","")
    words.replace(".","")
    words.replace(",","")
    words.replace("'","")
    
    data = 0
    trans = words.lower()
    print("Frequency: ")
    while (len(trans) > 0) == True:
        data = trans.count(trans[0])
        print(trans[0],data)
        trans = trans.replace(trans[0],"",data)


char_freq("Anjayyy")

