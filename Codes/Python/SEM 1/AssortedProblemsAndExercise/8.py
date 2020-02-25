#number 8
def find_longest_word(words):
    longest = max(words, key=lambda s: (len(s), s))
    words.sort(key=lambda s: (len(s), s))
    print(len(words))
    print(len(longest))


find_longest_word(["Hello","Yes","Laptop","Elephant"])

