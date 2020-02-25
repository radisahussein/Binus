#Exercise 3-4 to 3-8 page 46

# Initializing Variable Guest
guest = ["Gardyan", "Jason", "Ali", "Elang"]

# Printing invitation to each guest
for i in range(len(guest)):
    print("Hi " + guest[i] + ", you are invited to my funeral!")

# A guest couldnt come
print("Oh no, Gardyan sucks and can't come!")

# Remove Guest
del guest[0]

#print(guest)   test

# Add Guest
guest.append("Raina")

#print(guest)   test

# Sending out invitations to new Guest List
for i in range(len(guest)):
    print("Hi " + guest[i] + ", you are invited to my funeral!")

# Adding a few more people
print("We're going to invite a few more people, namely Eric, Ravel, and Vincent")

# Inserting guests into beginning, middle, and end
guest.insert(0, "Eric")
guest.insert(3, "Ravel")
guest.insert(-1, "Vincent")

# Sending out invitations to new guest list
for i in range(len(guest)):
    print("Hi " + guest[i] + ", you are invited to my funeral!")

# Unfortunate Altercation
print("Oh no! I can only invite 2 people to my funeral...")

# Remove guests untill 2 are left
for i in range(len(guest)-2):
    removed = guest.pop(0)
    print("Sorry " + removed + " you are uninvited")

# Sending out invitation to new guest list
for i in range(len(guest)):
    print("Hi " + guest[i] + ", you are invited to my funeral!")

# Remove last 2 guests from the list resulting in an empty list
del guest[0:2]
print(guest)
