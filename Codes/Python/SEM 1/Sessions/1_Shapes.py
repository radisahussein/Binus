x = print("Hello")

amount = 5
val = "*"
i = 0
"""
while i < 5:
    print(val)
    i += 1

"""
print("A")
for i in range(0, 5, 1):
    print(val * i)

print("B")
for i in range(5,0, -1):
    print(val * i)

print("C")
for i in range(5,-1,-1):
    print(" "*i + "*"*(5 - i))

print("D")
for i in range(0,5,+1):
    print(" "*i + "*"*(5 - i))

print("E")
h = 5
i = 0
while i <= h:
    print("*"*i)
    i += 1

while i >= 0:
    print("*"*i)
    i -= 1

print('F')
h = 5
i = 0

while i < h:
    print(" "*(h-i) + "*"*i)
    i += 1

while i >= 0:
    print(" "*(h-i) + "*"*i)
    i -= 1

print("G")

h = 11
i = 1

while i <= 7:
    print(" "*(int((h-i)/2)) + "*"*i + " "*(int((h-i)/2)))
    i += 2

while i >= 1:
    print(" "*(int((h-i)/2)) + "*"*i + " "*(int((h-i)/2)))
    i -= 2


print("H")

n = int(input("Enter an integer: "))

def shape(n):
    for i in range(n):
        print((" ")*i + ("*"*(n-i)))


shape(n)