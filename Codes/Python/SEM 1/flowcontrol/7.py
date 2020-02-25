def palindrome_recognizer():
    phrases = ["u are gay yes","Go hang a salami I'm a lasagna hog.", "Was it a rat I saw?", "Step on no pets", "Sit on a potato pan, Otis", "Lisa Bonet ate no basil", "Satan, oscillate my metallic sonatas", "I roamed under it as a tired nude Maori", "Rise to vote sir", "Dammit, I'm mad!"]

    for phrase in phrases:
        phrase = phrase.replace(" ", "")
        phrase = phrase.replace("'", "")
        phrase = phrase.replace(".", "")
        phrase = phrase.replace("?", "")
        phrase = phrase.replace(",", "")
        phrase = phrase.replace("!", "")
        print(list(phrase.lower()) == list(reversed(phrase.lower())))

palindrome_recognizer()