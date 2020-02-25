a = [1,2,3]
def isMember(x,a):
    for i in a:
        if i == x:
            return True
    
    return False

print(isMember(3,a))
print(isMember(4,a))
