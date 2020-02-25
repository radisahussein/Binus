#Playing around with dictionaries
# var = 10
# csClass = {'name': 'cen', 'points': var}

# print(csClass['points'])

# addPoints = int(input("Add Points: "))

# csClass['points'] = addPoints

# print(csClass)

# del csClass['name']
# print(csClass)

aDict = { 
    'item' : {
    'name': "botol",
    'stock': 10,
    'price': 10000
    }
    }

print(aDict['item']['name'])

aDict.update({'item1': {'name': "piring",'stock': 100,'price': 100000
}
})

print(aDict['item1'])

addItem = str(input("Add Item: "))
addStock = int(input("Add Stock: "))
addPrice = int(input("Add Price: "))

aDict.update({'item2': {
    'name': addItem,
    'stock': addStock,
    'price': addPrice
}})

print(aDict['item2'])