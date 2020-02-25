def makeForms(verb):
    last_es = ["o","s","x","z"]
    last2_es = ["ch","sh"]
    if verb[-1] == "y":
        print(verb.replace(verb[-1],'ies'))

    elif (verb[-1] in last_es):
        print(verb.replace(verb[-1],'es'))

    elif (verb[-2:] in last2_es):
        print(verb.replace(verb[-2:],'es'))
    else:
        print(verb + 's')


makeForms("hey")