#exercise 2

prices = {
    'banana': 4,
    'apple':2,
    'orange':1.5,
    'pear':3
}

#define stock of each item
stock = [10,5,2,4]

for key,value in prices.items():
    print(key)
    print('price:',value)
    print('stock:',stock[0])
    stock.insert(len(stock),stock.pop(0))
    print("\n")

total = 0

for key,value in prices.items():
    i = list(prices).index(key)
    total += (stock[i] * value)

print(total)