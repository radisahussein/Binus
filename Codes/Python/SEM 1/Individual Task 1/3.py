
class1 = 32
class2 = 45
class3 = 51

(x,y) = divmod(32,5)
print(x,y)

(a,b) = divmod(45,7)
print(a,b)

(f,g) = divmod(51,6)
print(f,g)

print("Number of students in each group: ")
print("Class 1 : ", x)
print("Class 2 : ", a)
print("Class 3 : ", f)

print("Number of students leftover : ")
print("Class 1 : ", y)
print("Class 2 : ", b)
print("Class 3 : ", g)