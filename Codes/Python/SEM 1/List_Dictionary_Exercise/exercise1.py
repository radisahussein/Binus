#exercise 1

inventory = {
    'gold':500,
    'pouch':['flint','twine','gemstone'],
    'backpack':['xylophone','dagger','bedroll','bread loaf']
}

#add key pocket, with a list as value
inventory.update({'pocket':['seashell','strange berry','lint']})
print(inventory)

#sorting values of key backpack, alphabetically
inventory['backpack'].sort()
print(inventory)

#removing value dagger
inventory['backpack'].remove('dagger')
print(inventory)

#adding 50 to key gold
inventory['gold'] += 50
print(inventory)