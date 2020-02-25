#Number 10

def isPangram(word):
    letters = "abcdefghijklmnopqrstuvwxyz"
    for char in letters:
        if char not in word.lower():
            return False

    return True


word = "the quick brown fox jumps over the lazy dog"
if isPangram(word) == True:
    print("This is a pangram")

else:
    print("Not a pangram")
