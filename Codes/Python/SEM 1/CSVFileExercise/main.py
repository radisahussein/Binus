import csv
import pygal
import matplotlib.pyplot as plt
from datetime import datetime as dt
import statistics

dateList = []
stepList = []
sumStepList = []

with open('activity.csv','r') as f:
    fileReader = csv.reader(f,delimiter=',')
    next(f)
    rows = []
    for row in fileReader:  

        if row[1] not in dateList:
            if len(rows) != 0:
                stepList.append(rows)
                rows = []
            dateList.append(row[1])
            rows.append(row[0])
            
        rows.append(row[0])

    NAList = ['NA'] * 289
 
    stepList.append(NAList)

    mean = []
    for i in range(len(dateList)):
        sum = 0
        for data in stepList[i]:
            if data == 'NA':
                sum += 0
            
            else:
                sum += data

            
        