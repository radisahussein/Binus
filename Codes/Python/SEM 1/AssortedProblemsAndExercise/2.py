#number 2

def translate(text):
    vowel = "aiueo "
    text = list(text)
    for i in text:
        if i not in vowel:
            text[text.index(i)] = i + 'o' + i
    return ''.join(text)

print(translate("this is fun"))