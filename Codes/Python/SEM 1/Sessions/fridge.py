#Fridge Program for TA Brenda
#By Radisa Hussein Rachmadi / cen
# 2301891752

import sys



def fridgeInventory(inside):
    #Draws game board
    print('   |   |')
    print(' ' + inside[1] + ' | ' + inside[2] + ' | ' + inside[3])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' ' + inside[4] + ' | ' + inside[5] + ' | ' + inside[6])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' ' + inside[7] + ' | ' + inside[8] + ' | ' + inside[9])
    print('   |   |')

def inventory():
    print('-----------------------------')
    fridgeInventory(insideFridge)
    print('-----------------------------')
    print('(x = filled)')
    print('-----------------------------')
    selection = str(input(('Access which slot? (1-9): ')))
    
    if selection == '1':
        slot(1)
    
    elif selection == '2':
        slot(2)
    
    elif selection == '3':
        slot(3)

    elif selection == '4':
        slot(4)

    elif selection == '5':
        slot(5)
    
    elif selection == '6':
        slot(6)
    
    elif selection == '7':
        slot(7)
    
    elif selection == '8':
        slot(8)
    
    elif selection == '9':
        slot(9)

    elif selection == 'back':
        start()
    
    else:
        print('-----------------------------')
        print("That's not a selection!")
        print('-----------------------------')
        inventory()

def slot(slotnumber):
    if slotList[slotnumber] != "":
        print('-----------------------------')
        print(str(stock[slotnumber]) , str(slotList[slotnumber]))
        start()
    
    else:
        print('-----------------------------')
        print('No Items in Slot Number ' + str(slotnumber))
        start()
    
def checkSlot(slotnumber):
    return insideFridge[slotnumber] == ' '

def store():
    print('-----------------------------')
    if slotList[1] != '' and slotList[2] != '' and slotList[3] != '' and slotList[4] != '' and slotList[5] != '' and slotList[6] != '' and slotList[7] != '' and slotList[8] != '' and slotList[9] != '':
        print('The Fridge is full! Retrieve an item before storing another!')
        start()
    else:
        selection = str(input('Item to store: '))
        if selection in slotList:
            print('-----------------------------')
            print('You already have this item in the Fridge!')
            start()
        else:
            print('-----------------------------')
            fridgeInventory(insideFridge)
            print('-----------------------------')
            selectionSlot = int(input('Select an empty slot (1-9): '))
            if slotList[selectionSlot] == '':
                selectionStock = int(input('How much?: '))
                stock.insert(selectionSlot,selectionStock)
                slotList[selectionSlot] = selection
                insideFridge[selectionSlot] = 'x'
                print('-----------------------------')
                print( selectionStock,selection+' added to slot '+str(selectionSlot))
                start()

            else:
                print('-----------------------------')
                print('That Slot is taken! Pick another')
                start()

def retrieve():
    print('-----------------------------')
    if slotList[1] == '' and slotList[2] == '' and slotList[3] == '' and slotList[4] == '' and slotList[5] == '' and slotList[6] == '' and slotList[7] == '' and slotList[8] == '' and slotList[9] == '':
        print('The Fridge is empty! Store an item before retrieving one!')
        start()

    else:
        fridgeInventory(insideFridge)
        selection = int(input('Retrieve Slot: '))

        if insideFridge[selection] == ' ':
            print('-----------------------------')
            print('Slot is empty!')
            start()
        
        else:
            print(str(stock[selection]) , str(slotList[selection]))
            selectStock = int(input('How much: '))
            if selectStock <= stock[selection]:
                print('-----------------------------')
                confirmSelection = str(input('Confirm (y/n): '))
                if confirmSelection == 'y':
                    print('-----------------------------')
                    stock[selection] -= selectStock
                    print(selectStock,'of',slotList[selection],'retrieved from fridge!')
                    if stock[selection] == 0:
                        print('-----------------------------')
                        print('No more',slotList[selection],'in fridge, slot is open')
                        insideFridge[selection] = ' '
                        slotList[selection] = ''
                        
                        start()
                    else:
                        print('-----------------------------')
                        print(stock[selection],'of',slotList[selection],'left in fridge!')
                        start()
                else:
                    print('-----------------------------')
                    print('Oh ok cancel')
                    start()
            
            else:
                print('-----------------------------')
                print('Stock not enough!')
                start()


def update():
    print('-----------------------------')
    fridgeInventory(insideFridge)
    print('-----------------------------')
    selection = int(input('Select Slot: '))
    if insideFridge[selection] == ' ':
        print('-----------------------------')
        print('No items available!')
        start()
    
    else:
        print('-----------------------------')
        print(str(stock[selection]) , str(slotList[selection]))
        addStock = int(input(('How much ' + slotList[selection] + ' do you want to add: ')))
        stock[selection] += addStock
        print(addStock,slotList[selection],'added to fridge slot',selection)
        start()
    

def start():
    print('-----------------------------')
    print('Smart Fridge\n')
    print('1. Inventory')
    print('2. Store')
    print('3. Retrieve')
    print('4. Update')
    print('5. Exit')
    print('-----------------------------')

    selection = str(input("Select: "))

    if selection == '1':
        inventory()

    elif selection == '2':
        store()

    elif selection == '3':
        retrieve()

    elif selection == '4':
        update()

    elif selection == '5':
        print("Bye!")
        sys.exit(1)

    else:
        print('-----------------------------')
        print("That's not a selection!")




slotList = [''] * 10
slotList[0] == None

stock = [0] * 10

insideFridge = [' '] * 10
insideFridge[0] == None

start()