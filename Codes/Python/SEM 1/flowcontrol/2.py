def max_of_three(x,y,z):
    if x > y and x > z:
        print(x)

    elif y > x and y > z:
        print(y)

    elif z > x and z > y:
        print(z)

    else:
        print("WHat")

max_of_three(3,4,5)
