#date class

class Date():

    def __init__(self,day,month,year):
        self.__day:int = day
        self.__month:int = month
        self.__year:int = year

    def getDay(self) -> int:
        print(str(self.__day))
    
    def getMonth(self) -> int:
        print(str(self.__month))

    def getYear(self) -> int:
        print(str(self.__year))
    
    def setDay(self,day:int):
        self.__day = day
        print(self.__day)
    
    def setMonth(self,month:int):
        self.__month = month
        print(self.__month)
    
    def setYear(self,year:int):
        self.__year = year
        print(self.__year)
    
    def setDate(self,day:int,month:int,year:int):
        self.__day = day
        self.__month = month
        self.__year = year
    
    def toString(self) -> str:
        zero = "0"
        dateo = [str(self.__day),str(self.__month),str(self.__year)]
        for i in range(len(dateo)):
            if len(dateo[i]) == 1:
                dateo[i] = zero + dateo[i]
                
        print(dateo[0] + '/' + dateo[1] + '/' + dateo[2])

#Tests

date1 = Date(2,4,2002)
date1.getDay()
date1.getMonth()
date1.getYear()
date1.setDay(4)
date1.setMonth(10)
date1.setYear(2010)
date1.setDate(6,6,2006)
date1.toString()