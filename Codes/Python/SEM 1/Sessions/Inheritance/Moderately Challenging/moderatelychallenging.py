#Moderately Challenging

class Person():

    def __init__(self,name,address):
        self.name = str(name)
        self.address = str(address)

    def getName(self) -> str:
        print('The name of the person is ' + 
        self.name)
    
    def getAddress(self) -> str:
        print('The address of ' + self.name + 
        ' is ' + self.address)

    def setAddress(self) -> str:
        userInput = str(input('Set address to: '))
        self.address = userInput

    def toString(self) -> str:
        print('Person : ' + self.name + ' ( ' + 
        self.address + ' )')
class Student(Person):

    def __init__(self,name,address,numCourses,courses):
        super().__init__(name,address)
        self.numCourses:int = numCourses
        self.courses:list = courses
        self.grades:list = [0] * self.numCourses
        self.average:float = 0
    
    def addCourseGrade(self,course:str,grade:int):
        position = self.courses.index(course)
        self.grades[position] = int(grade)
    
    def printGrades(self):
        for i in range(len(self.courses)):
            print('Course : ' + str(self.courses[i]))
            print('Grade : ' + str(self.grades[i]))
            print('\n')
    
    def getAverageGrade(self) -> float:
        total = sum(self.grades)
        self.average = total/self.numCourses
        print('The average Grade is ' + str(self.average))
            
    def toString(self) -> str:
        print('Student : ' + self.name + ' ( ' + 
        self.address + ' )')
class Teacher(Person):
    
    def __init__(self,name,address,numCourses,courses):
        super().__init__(name,address)
        self.numCourses:int = numCourses
        self.courses:list = courses
        
    def addCourse(self,course):
        if course in self.courses:
            print('Course already present')
            return False
            
        else:
            self.courses.append(course)
            print('Course ' + course + ' added')
            print(self.courses)
            self.numCourses += 1
    
    def removeCourse(self,course):
        if course in self.courses:
            self.courses.remove(course)
            print('Course ' + course + ' removed')
            print(self.courses)
        else:
            print('No courses found')
            return False

    def toString(self) -> str:
        print("Teacher : " + self.name + ' ( ' + 
        self.address + ' )')

person1 = Person('Cen','Kemang')
person1.getName()
person1.getAddress()
person1.setAddress()
person1.toString()

student1 = Student('Cen','Kemang',3,['math','science','english'])
student1.addCourseGrade('math',90)
student1.addCourseGrade('science',80)
student1.addCourseGrade('english',100)
student1.printGrades()
student1.getAverageGrade()
student1.toString()

teacher1 = Teacher('Bagus','Sudirman',3,['math','science','english'])
teacher1.getName()
teacher1.getAddress()
teacher1.addCourse('math')
teacher1.addCourse('bahasa')
teacher1.removeCourse('pe')
teacher1.removeCourse('english')
teacher1.toString()
        


            
    

