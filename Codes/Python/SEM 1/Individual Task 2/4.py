def calcNewHeight():
    currentWidth = float(input("Enter current width: "))
    currentHeight = float(input("Enter current Height: "))
    newWidth = float(input("Enter desired width: "))

    ratio = currentHeight/currentWidth

    newHeight = ratio * newWidth
    print("The corresponding height is: ",newHeight)

calcNewHeight()

