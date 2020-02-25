#Employee Class

class Employee():

    def __init__(self,id,firstName,lastName,salary):
        self.__id:int = id
        self.__firstName:str = firstName
        self.__lastName:str = lastName
        self.__salary:int = salary
    
    def getID(self) -> int:
        print(self.__id)

    def getFirstName(self) -> str:
        print(self.__firstName)
    
    def getLastName(self) -> str:
        print(self.__lastName)
    
    def getName(self) -> str:
        print(self.__firstName + ' ' + self.__lastName)
    
    def getSalary(self) -> int:
        print(int(self.__salary))
    
    def setSalary(self,salary:int):
        self.__salary = salary
        print('Salary set to ' + str(self.__salary))
    
    def getAnnualSalary(self) -> int:
        annual = self.__salary * 12
        print(annual)
    
    def raiseSalary(self,percent:int) -> int:
        self.__salary += self.__salary * (percent/100)
        print('Salary raised by ' + str(percent) + ' percent.' + ' Current Salary is ' +
        str(int(self.__salary)))
    
    def toString(self) -> str:
        print('Employee[id = ' + str(self.__id) + ',name = ' 
        + self.__firstName + ' ' + self.__lastName + ',salary = ' 
        + str(int(self.__salary)) + ']')


#Tests
    
employee1 = Employee(2301891752,'Radisa','Rachmadi',1000000)
employee1.getID()
employee1.getFirstName()
employee1.getLastName()
employee1.getSalary()
employee1.setSalary(3000000)
employee1.getSalary()
employee1.getAnnualSalary()
employee1.raiseSalary(50)
employee1.getSalary()
employee1.toString()



