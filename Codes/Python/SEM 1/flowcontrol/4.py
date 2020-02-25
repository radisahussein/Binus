
def vowelCheck():
    vowel = ["a","i","u","e","o"]
    character = str(input("Enter a character: "))
    if len(character) != 1:
        print("enter one character!")
    else:
        if character in vowel:
            print("This a vowel")
        else:
            print("This aint a vowel")

vowelCheck()