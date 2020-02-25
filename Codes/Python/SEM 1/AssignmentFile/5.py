#Number 5
import os
def convertToSentence(filename):
 readFile = open(os.getcwd() + "\\" + filename, 'r')
 stringValue = readFile.read()
 titles = ["Mr.", "Mrs.", "Dr."]
 data = stringValue.split()
 result = ""
 n = 0
 for i in data:
    temp = i + " "
    if(i.endswith(".") or i.endswith("?") or i.endswith("!")):
        if(n != len(data) -1):
            if(i not in titles and str(data[n + 1][0]).isupper()):
                temp = temp + "\n"

    n = n + 1

    result = result + temp

 return result
print(convertToSentence("shortText.txt"))