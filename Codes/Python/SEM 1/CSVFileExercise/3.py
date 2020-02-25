#3
import csv
from statistics import mean
import numpy as np
import matplotlib.pyplot as plt

with open('activity.csv','r')as file:
    data = csv.reader(file)
    missingvalue = 0
    rowmissingvalue = []
    for row in data:
        if row[0] == 'NA':
            missingvalue += 1
            rowmissingvalue.append(row)


        

print(missingvalue)
print(rowmissingvalue)

