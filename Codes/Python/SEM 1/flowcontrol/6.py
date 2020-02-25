def is_palindrome():
    word = str(input("Enter: "))
    x = word[::-1]
    if x == word:
        print("This is palindrome")

    else:
        print("this not a palindrome")

is_palindrome()