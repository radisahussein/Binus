#TIME CLASS

class Time():

    def __init__(self,hour,minute,second):
        self.__hour:int = hour
        self.__minute:int = minute
        self.__second:int = second
    
    def getHour(self) -> int:
        print(self.__hour)

    def getMinute(self) -> int:
        print(self.__minute)
    
    def getSecond(self) -> int:
        print(self.__second)
    
    def setHour(self,hour:int):
        self.__hour = hour
        print(self.__hour)
    
    def setMinute(self,minute:int):
        self.__minute = minute
        print(self.__minute)
    
    def setSecond(self,second:int):
        self.__second = second
        print(self.__second)
    
    def setTime(self,hour:int,minute:int,second:int):
        self.__hour = hour
        self.__minute = minute
        self.__second = second
    
    def toString(self) -> str:
        zero = "0"
        time = [str(self.__hour),str(self.__minute),str(self.__second)]
        for i in range(len(time)):
            if len(time[i]) == 1:
                time[i] = zero + time[i]

        print(time[0] + ':' + time[1] + ':' + time[2])

    def nextSecond(self):
        self.__second += 1
        if self.__second >= 60:
            self.__second -= 60
            self.__minute += 1
            if self.__minute >= 60:
                self.__minute -= 60
                self.__hour += 1
        
    
    def previousSecond(self):
        self.__second -= 1
        if self.__second < 0:
            self.__second = 60 + self.__second
            self.__minute -= 1
            if self.__minute < 0:
                self.__minute = 60 + self.__minute
                self.__hour -= 1

#Tests
                    
time1 = Time(4,40,40)
time1.getHour()
time1.getMinute()
time1.getSecond()
time1.setHour(5)
time1.setMinute(50)
time1.setSecond(50)
time1.setTime(6,59,59)
time1.toString()
time1.nextSecond()
time1.toString()
time1.previousSecond()
time1.toString()