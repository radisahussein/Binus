#invoice item class

class InvoiceItem():

    def __init__(self,id,desc,qty,unitPrice):
        self.__id:str = id
        self.__desc:str = desc
        self.__qty:int = qty
        self.__unitPrice:float = unitPrice

    def getID(self) -> str:
        print(self.__id)
    
    def getDesc(self) -> str:
        print(self.__desc)
    
    def getQty(self) -> int:
        print(self.__qty)
    
    def setQty(self,qty:int):
        self.__qty = qty
        print(self.__qty)
    
    def getUnitPrice(self) -> float:
        print(self.__unitPrice)
    
    def setUnitPrice(self,price:float):
        self.__unitPrice = price
        print(self.__unitPrice)
    
    def getTotal(self) -> float:
        total = self.__unitPrice * self.__qty
        print(total)
    
    def toString(self) -> str:
        print('InvoiceItem[id=' + self.__id + ',desc=' + self.__desc
        + ',qty=' + str(self.__qty) + ',unitPrice=' + str(self.__unitPrice)
        + ']')

#Tests

invoice1 = InvoiceItem('MM012','Deluxe Cheese Slice',15,5000)
invoice1.getID()
invoice1.getDesc()
invoice1.getQty()
invoice1.setQty(20)
invoice1.getUnitPrice()
invoice1.setUnitPrice(10000)
invoice1.getTotal()
invoice1.toString()
