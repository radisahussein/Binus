#Testing Classes

class Cat():

    def __init__(self,name,age):
        #Initialize Name and Age Attributes
        self.name = name
        self.age = age
    
    def sit(self):
        #Simulate a cat sitting
        print(self.name.title() + ' is now sitting.')
    
    def licking(self):
        #Simulate a licking cat
        print(self.name.title(),"is licking himself!")


my_cat = Cat('Momo',3)
your_cat = Cat('Prada',4)

print("My cat's name is",my_cat.name.title()+'.')
print("My cat is",str(my_cat.age),'years old.')

my_cat.sit()

print("Your cat's name is",your_cat.name.title()+'.')
print("Your cat is",str(your_cat.age),'years old.')

your_cat.sit()

class Human():

    def __init__(self,name,age,height,weight):
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight
        self.wealth = 0 

    def getInfo(self):
        PersonInfo = 'Name: ' + self.name + '\nAge: ' + str(self.age) + '\nHeight: ' + str(self.height) + ' cm' + '\nWeight: ' + str(self.weight) + ' kg'
        return PersonInfo.title()

    def financial_status(self):
        print('This person has Rp.',self.wealth,'in his bank account')

    #Modifying Attribute through method(function inside class)
    def updateWealth(self,money):
        self.wealth = money
    
    #Adding value to attribute through method
    def addWealth(self,money):
        self.wealth += money

#Calling Get Info Function   
first_human = Human('Adam',25,180,70)
print('\nHuman Class \n')
print(first_human.getInfo())
print("\n")
#Calling Financial Status
first_human.financial_status()

#Modifying Attribute
first_human.wealth = 1000
first_human.financial_status()

#Using Method to Modify Attribute
print('\n')
first_human.updateWealth(10000)
first_human.financial_status()

#Using Method to Add Value of Attribute
print('\n')
first_human.addWealth(10000)
first_human.financial_status()

#Exercise 9-1

class Restaurant():

    def __init__(self,restaurant_name,cuisine_type):
        self.restaurant_name = restaurant_name
        self.cuisine_type = cuisine_type
        self.number_served = 0 
        self.newNumber_served = 0
    
    def describe_restaurant(self):
        print('Restaurant Name:',self.restaurant_name)
        print('Cuisine Type:',self.cuisine_type)

    def open_restaurant(self):
        print(self.restaurant_name,'is open!')

    def set_number_served(self,served):
        self.number_served = served
        print('Number of Customers Served by',self.restaurant_name,'is',str(self.number_served))
    
    def increment_number_served(self,add:int):
        self.number_served += add
        print('Number of Customers Served by',self.restaurant_name,'is now updated to',str(self.number_served))

newRestaurant = Restaurant('Mos Burger','Western Food')
anotherRestaurant = Restaurant('Tori No Ana','Japanese Food')
thirdRestaurant = Restaurant('Pagi Sore','Indonesian Food')

restoList = [newRestaurant,anotherRestaurant,thirdRestaurant]
for i in restoList:
    i.describe_restaurant()
    print('\n')


newRestaurant.set_number_served(10)
anotherRestaurant.set_number_served(100)
thirdRestaurant.set_number_served(23)

newRestaurant.increment_number_served(10)

#Exercise 9-5 , login attempts
print("\n \n \n")
class User():
    
    def __init__(self,first_name,last_name):
        self.first_name = first_name
        self.last_name = last_name
        self.login_attempts = 0

    def describeUser(self):
        print('\nFirst name:',self.first_name)
        print('Last name:',self.last_name)

    def greetUser(self):
        print('\nHello',self.first_name)

    def increment_login_attempts(self):
        self.login_attempts += 1
        print('Login Attempts:',self.login_attempts)

    def reset_login_attempts(self):
        self.login_attempts = 0
        print('Login Attempts Reset to',self.login_attempts)


user1 = User('Radisa','Hussein')
user1.describeUser()
user1.greetUser()

user1.increment_login_attempts()
user1.increment_login_attempts()
user1.increment_login_attempts()

user1.reset_login_attempts()

class Car():

    def __init__(self,make,model,year):
        self.make = make
        self.model = model
        self.year = year
        self.odometer_reading = 0

    def get_descriptive_name(self):
        print(str(self.year),self.make,self.model)

    def read_odometer(self):
        print('This car has',str(self.odometer_reading),'km on it')

    def update_odometer(self,mileage):
        if mileage >= self.odometer_reading:
            self.odometer_reading = mileage
        else:
            print("You can't roll back an odometer!")

    def increment_odometer(self,miles):
        self.odometer_reading += miles
        print(str(miles),'km added to odometer')

class ElectricCar(Car):
    
    def __init__(self,make,model,year):
        #Initializing attributes of the parent class (car)
        super().__init__(make,model,year)
        self.battery = Battery()

    def fill_gas_tank(self):
        print("This car doesn't need a gas tank!")

#Making Battery into its own class to avoid lengthy classes
class Battery():
    def __init__(self,battery_size=70):
        self.battery_size = battery_size

    def describe_battery(self):
        print('This car has a',str(self.battery_size)+'-kWh battery.')

    def get_range(self):
        if self.battery_size == 70:
            range = 240
        
        if self.battery_size == 85:
            range = 270
        
        message = "This car can go approximately " + str(range)
        message += ' miles on a full charge.'
        print(message)


my_tesla = ElectricCar('tesla','model s',2016)
my_tesla.get_descriptive_name()

my_tesla.battery.describe_battery()
my_tesla.fill_gas_tank()
my_tesla.battery.get_range()

#exercise 9-6 Ice Cream Stand

class IceCreamStand(Restaurant):

    def __init__(self,restaurant_name,cuisine_type):
        super().__init__(restaurant_name,cuisine_type)
        self.flavors = ['vanilla','chocolate','strawberry']

    def menu(self):
        print("\n"+ self.restaurant_name + ' Ice Cream Menu.')
        for i in self.flavors:
            print("- " + i)

BaskinRobbins = IceCreamStand('Baskin Robbins','Dessert')
BaskinRobbins.describe_restaurant()
BaskinRobbins.menu()

#exercise 9-7 admin

class Admin(User):

    def __init__(self,first_name,last_name):
        super().__init__(first_name,last_name)
        self.privileges = ['can add post','can delete post','can ban user']

    def show_privileges(self):
        print(self.first_name + ' ' + self.last_name + "'s Privileges:\n")
        for i in self.privileges:
            print("- " + i)

admin1 = Admin('Mr','Admin')
admin1.describeUser()
admin1.greetUser()
admin1.show_privileges()

