
def convertPigLatin():
    originalWord = str(input("Enter Word: "))
    if len(originalWord) > 0:
        if originalWord.isalpha() is True:
            pig = originalWord[1:] + originalWord[0] + "ay"
            print(originalWord, "in Pig Latin is:",pig.lower())


        else:
            print("Please enter only letters and no spaces!")
            convertPigLatin()
    else:
        print("Empty, please enter a word")
        convertPigLatin()

convertPigLatin()