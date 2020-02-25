import csv
from statistics import mean
import numpy as np
import matplotlib.pyplot as plt

#1
with open('activity.csv', 'r')as file:
    data = csv.reader(file)
    my_dict = {}
    for row in data:
        if row [0] != 'NA' and row[1] != 'date':
            if row[1] not in my_dict:
                my_dict[row[1]] = [int(row[0])]
            else:
                my_dict[row[1]].append(int(row[0]))
total_perday = {}
mean_total_perday = {}
for key, value in my_dict.items():
    total_perday[key] = sum(value)
    mean_total_perday[key] = round(mean(value),2)

print(total_perday)
print(mean_total_perday)



N = len(my_dict)
meanst = tuple(total_perday.values())
ind = np.arange(N)
width = 0.8
p1 = plt.bar(ind, meanst, width)
plt.ylabel('steps')
plt.title('Mean Total per day')
plt.xticks(ind, tuple(total_perday.keys()))
plt.yticks(np.arange(0,101,20))
plt.show()


