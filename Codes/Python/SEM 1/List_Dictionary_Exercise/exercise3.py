#exercise 3

groceries = ['banana','orange','apple']

stock = {
    'banana':6,
    'apple':0,
    'orange':32,
    'pear':15
}

prices = {
    'banana':4,
    'apple':2,
    'orange':1.5,
    'pear':3
}

def compute_bill(food):
    total = 0
    for ele in food:
        if ele in stock:
            if stock[ele] > 0:
                total += (stock[ele] * prices[ele])
                stock[ele] -= 1
                print(ele,"added to bill!")
                print('Total Bill:',total)
            else:
                print(ele,'no stock')
        else:
            print('noe')

    print('Total Bill:',total)

compute_bill(groceries)

