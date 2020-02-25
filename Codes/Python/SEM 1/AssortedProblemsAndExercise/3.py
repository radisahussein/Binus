import calendar

yearinput = int(input("Enter Year: "))
monthinput = int(input("Enter Month (1-12): "))

print(calendar.month(yearinput,monthinput,w=0,l=0))