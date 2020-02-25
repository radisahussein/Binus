#number 5

def overlapping(lst1,lst2):
    value:list = []
    for i in range(len(lst1)):
        if lst1[i] in lst2:
            value.append("True")
        else:
            value.append("False")

    if "True" in value:
        print("True")

    else:
        print("False")

overlapping([1,3,4,5],[2,10,9,1])