def makeForming(verb):
    exceptions = ['be','see','flee','knee']
    if verb[-2:] == 'ie':
        return verb[:-2] + 'ying'
    elif verb[-1] == 'e' and verb not in exceptions:
        return verb[:-1] + 'ing'
    else:
        return verb + 'ing'

print(makeForming('see'))