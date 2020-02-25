#Testing CSV

import csv

with open('csvtest.txt') as csv_file:
    csv_reader = csv.reader(csv_file,delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            print(f'Column Names are {", ".join(row)}')
            line_count += 1
        
        else:
            print(f'\t{row[0]} studies in the {row[1]} class, and is {row[2]} years old.')
            line_count += 1
    
    print(f'Processed {line_count} lines.')


csvtestfile = open('csvtest.txt','a')
csv_writer = csv.writer(csvtestfile,delimiter=',',quoting=csv.QUOTE_MINIMAL)
csv_writer.writerow(['Azellius','Graphic Design','18'])
csvtestfile.close()

