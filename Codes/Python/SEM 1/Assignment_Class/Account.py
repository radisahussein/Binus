#account class

class Account():

    def __init__(self,id,name):
        self.__id:str = id
        self.__name:str = name
        self.__balance:int = 0

    def getID(self) -> str:
        print(self.__id)
    
    def getName(self) -> str:
        print(self.__name)

    def getBalance(self) -> int:
        print(self.__balance)

    def credit(self,amount:int) -> int:
        self.__balance += amount
        print(self.__balance)
    
    def debit(self,amount:int) -> int:
        if amount <= self.__balance:
            self.__balance -= amount
            print(self.__balance)
        
        else:
            print('Amount exceeded balance')
            print(self.__balance)

    def transferTo(self,another,amount:int) -> int:
        if amount <= self.__balance:
            self.__balance -= amount
            another.__balance += amount
        
        else:
            print('Amount exceeded balance')
            print(self.__balance)

    def toString(self) -> str:
        print('Account[id=' + self.__id + ',name=' +
        self.__name + ',balance=' + str(self.__balance) +
        ']')

#Tests

account1 = Account('RR242','Cen')
account1.getBalance()
account1.getID()
account1.getName()
account1.credit(1000)
account1.debit(500)
account1.debit(10000)

account2 = Account('MM909','Rafa')

account1.transferTo(account2,500)
account1.getBalance()
account2.getBalance()

account1.toString()
account2.toString()

