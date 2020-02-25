def convertTemp():
    tempF = float(input("Enter a temperature in Fahrenheit: "))
    tempC = convertToCelcius(tempF)
    tempK = convertToKelvin(tempC)
    print("The temperature in Fahrenheit is: ", tempF)
    print("The temperature in Celsius is: ", tempC)
    print("The temperature in Kelvin is: ", tempK)

def convertToCelcius(tempF):
    tempC = (5/9) * (tempF - 32)
    return tempC

def convertToKelvin(tempC):
    tempK = (tempC) + 273.15
    return tempK
convertTemp()

