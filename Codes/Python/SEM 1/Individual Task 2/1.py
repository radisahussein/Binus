def convertToDays():
    hours = int(input("Enter number of hours: "))
    minutes = int(input("Enter number of minutes; "))
    seconds = int(input("Enter number of seconds: "))
    print(getDays(hours,minutes,seconds))

def getDays(x,y,z):
    return (x / 24 + y / 1440 + z / 86400)

convertToDays()