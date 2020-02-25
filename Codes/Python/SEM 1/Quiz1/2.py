import csv
import sys

IDList = []
nameList = []
positionList = []
salaryList = []

with open('data.txt') as f:
    csvReader = csv.reader(f,delimiter='#')
    next(f)
    for row in csvReader:
        #for i in range(len(row)):
        IDList.append(row[0])
        nameList.append(row[1])
        positionList.append(row[2])
        salaryList.append(row[3])
    
def mainMenu():
    print('ID' + '\t' + 'Name' + '\t' + 'Position' + '\t' + 'Salary')
    for i in range(len(IDList)):
        print(str(IDList[i]) + '\t' + str(nameList[i]) + '\t' + str(positionList[i]) + '\t \t' + str(salaryList[i]))
    
    print('----------------------------------------')
    print('1. New Staff')
    print('2. Delete Staff')
    print('3. View Summary Data')
    print('4. Save & Exit')
    print('----------------------------------------')
    selection = str(input('Input Choice: '))
    if selection == '1':
        newStaffID()
    
    elif selection == '2':
        delStaff()
    
    elif selection == '3':
        viewSummary()
    
    elif selection == '4':
        sys.exit(1)
    
    elif selection == None:
        print("You didn't input anything!")
        mainMenu()

    else:
        print("That's not a menu!")
        mainMenu()

def newStaffID():
    print('----------------------------------------')
    print('Requirements for Staff ID: ')
    print('- Length must be 5 characters')
    print('- First Character must be "S"')
    print('- Second through Fifth must be Numeric')
    print('----------------------------------------')
    inputID = str(input('Input Staff ID (SXXXX): '))

    if len(inputID) != 5:
        print('----------------------------------------')
        print('Length must be 5 characters!')
        newStaffID()

    if inputID[0] != 'S':
        print('----------------------------------------')
        print('First Character must be "S" !')
        newStaffID()

    for i in range (1,5):
        if not inputID[i].isdigit():
            print('----------------------------------------')
            print('Second through Fifth must be Numeric!')
            newStaffID() 
    
    if inputID in IDList:
        print('----------------------------------------')
        print('This ID already exists!')
        newStaffID()
    
    IDList.append(inputID)
    newStaffName()

def newStaffName():
    inputName = str(input('Input Name (0-20 Characters) : '))
    if len(inputName) > 20:
        print('Name only 20 characters max!')
        newStaffName()
    
    if not inputName.isalpha():
        print('Enter only letters!')
        newStaffName()
    
    nameList.append(inputName)
    newStaffPosition()

def newStaffPosition():
    inputPosition = str(input('Input Position of Staff [Staff / Officer / Manager] : '))
    staffPositions = ['Staff','Officer','Manager']
    if inputPosition not in staffPositions:
        print('No available positions!')
        newStaffPosition()
    
    positionList.append(inputPosition)
    newStaffSalary()

def newStaffSalary():
    inputSalary = int(input('Input Salary of Staff : '))
    if positionList[-1] == 'Staff':
        if inputSalary < 3500000 and inputSalary > 7000000:
            print('Salary not fit requirements!')
            newStaffSalary()

        salaryList.append(inputSalary)
    
    elif positionList[-1] == 'Officer':
        if inputSalary < 7000001 and inputSalary > 10000000:
            print('Salary not fit requirements!')
            newStaffSalary()
        
        salaryList.append(inputSalary)
    
    else:
        if inputSalary < 10000000:
            print('Salary not fit requirements!')
            newStaffSalary()

        salaryList.append(inputSalary)

    mainMenu()

def delStaff():
    print('Delete Staff')
    inputDelStaff = str(input('Input ID : '))
    if len(inputDelStaff) != 5:
        print('----------------------------------------')
        print('Length must be 5 characters!')
        delStaff()

    if inputDelStaff[0] != 'S':
        print('----------------------------------------')
        print('First Character must be "S" !')
        delStaff()

    for i in range (1,5):
        if not inputDelStaff[i].isdigit():
            print('----------------------------------------')
            print('Second through Fifth must be Numeric!')
            delStaff() 
    
    positionOfStaff = IDList.index(inputDelStaff)
    IDList.pop(positionOfStaff)
    nameList.pop(positionOfStaff)
    positionList.pop(positionOfStaff)
    salaryList.pop(positionOfStaff)

    mainMenu()

def viewSummary():

    staffSalary = []
    managerSalary = []
    officerSalary = []

    #Grouping by Position
    for i in range(len(positionList)):
        if positionList[i] == 'Staff':
            staffSalary.append(int(salaryList[i]))
        
        elif positionList[i] == 'Officer':
            officerSalary.append(int(salaryList[i]))
        
        else:
            managerSalary.append(int(salaryList[i]))
    
    averageStaffSalary = int((sum(staffSalary) / len(staffSalary)))
    averageOfficerSalary = int((sum(officerSalary)) / int(len(officerSalary)))
    averageManagerSalary = int((sum(managerSalary)) / int(len(managerSalary)))
    print('----------------------------------------')
    print('Summary Data : \n')
    print('1. Staff')
    print('Minimum Salary: ' + str(min(staffSalary)))
    print('Maximum Salary: ' + str(max(staffSalary)))
    print('Average Salary: ' + str(averageStaffSalary))

    print('\n2. Officer')
    print('Minimum Salary: ' + str(min(officerSalary)))
    print('Maximum Salary: ' + str(max(officerSalary)))
    print('Average Salary: ' + str(averageOfficerSalary))

    print('\n3.Manager')
    print('Minimum Salary: ' + str(min(managerSalary)))
    print('Maximum Salary: ' + str(max(managerSalary)))
    print('Average Salary: ' + str(averageManagerSalary))
    print('----------------------------------------')
    mainMenu()

mainMenu()