def filter_long_words(words,n):
    longer = []
    for i in range(len(words)):
        if len(words[i]) > n:
            longer.append(words[i])
    return longer


print(filter_long_words(["cen","raina","azel","ali","elang","aidan"],4))
