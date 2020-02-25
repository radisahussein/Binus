
def distanceFromZero(x):
    if type(x) == int or type(x) == float:
        return abs(x)
    else:
        return "Nope"



print(distanceFromZero("what"))
