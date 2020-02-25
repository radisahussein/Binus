#another easy challenge

class Circle():

    def __init__(self,radius,color):
        self.radius = float(radius)
        self.color = str(color)
        self.area = 0.0

    def getRadius(self) -> float:
        print('The radius of the circle is : ' + 
        str(self.radius))
    
    def setRadius(self) -> float:
        userInput = float(input('Set Radius to: '))
        self.radius = userInput
    
    def getColor(self) -> str:
        print('The color of the circle is : ' + 
        str(self.color))
    
    def setColor(self) -> str:
        userInput = str(input('Set Color to: '))
        self.color = userInput
    
    def getArea(self) -> float:
        self.area = 3.14 * (self.radius * self.radius)
        print('The area of the circle is : ' + 
        str(self.area))
    
    def toString(self) -> str:
        print('The Color of the circle is ' + 
        self.color + ' ' + ', the radius of the circle is '
        + str(self.radius) + ' ' + ', and the area of the circle is '
        + str(self.area))
    


circle1 = Circle(1.0,'red')
circle1.getRadius()
circle1.setRadius()
circle1.getColor()
circle1.setColor()
circle1.getArea()
circle1.toString()

class Cylinder(Circle):

    def __init__(self,radius,color,height):
        super().__init__(radius,color)
        self.height:float = height
        self.volume:float = 0
        self.area = self.area
    
    def getHeight(self) -> float:
        print('The height of the cylinder is ' + 
        str(self.height))
    
    def setHeight(self) -> float:
        userInput = float(input('Set height to: '))
        self.height = userInput
    
    def getVolume(self) -> float:
        self.volume = 3.14 * (self.radius * self.radius) * self.height
        print('The volume of this cylinder is ' + 
        str(self.volume))
    
    def toString(self) -> str:
        print('The color of this cylinder is ' + 
        self.color + ' ' + ', the radius of this cylinder is '
        + str(self.radius) + ', the height of this cylinder is '
        + str(self.height) + ' and the volume of this cylinder is '
        + str(self.volume))
    

cylinder1 = Cylinder(1.0,'red',1.0)
cylinder1.getHeight()
cylinder1.setHeight()
cylinder1.getVolume()
cylinder1.toString()