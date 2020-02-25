#Exercise 3-8 page 50

# Variable
places = ["Japan", "Sweden", "Maldives", "Iceland", "France", "Spain"]
print(places)

# Sorting into alphabetical order
orderedPlaces = sorted(places)
print(orderedPlaces)

# Checking to see original list still unchanged
print(places)

# Reversed Alphabetical ordered
reversedOrdered = sorted(places)
reversedOrdered.reverse()
print(reversedOrdered)

# Reversed Again, back to Alphabetical Order
reversedOrdered.reverse()

# Altering original list, alphabetical order
places = sorted(places)
print(places)

# Reversed Alphabetical order on original list
places.reverse()
print(places)
