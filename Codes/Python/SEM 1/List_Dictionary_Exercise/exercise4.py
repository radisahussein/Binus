#exercise 4

eren = {
    'name':'Eren',
    'homework':[90.0,97.0,75.0,92.0],
    'quizzes':[88.0,40.0,94.0],
    'tests':[75.0,90.0]
}

mikasa = {
    'name':'Mikasa',
    'homework':[100.0,92.0,98.0,100.0],
    'quizzes':[82.0,83.0,91.0],
    'tests':[89.0,97.0]
}

armin = {
    'name':'Armin',
    'homework':[0.0,87.0,75.0,22.0],
    'quizzes':[0.0,75.0,78.0],
    'tests':[100.0,100.0]
}

students = [eren,mikasa,armin]

for pupil in students:
    print("Name:",pupil['name'])
    print("Homework:",pupil['homework'])
    print("Quizz:",pupil['quizzes'])
    print('Tests:',pupil['tests'])
    print('\n')

#average function
def average(numbers):
    total = sum(numbers)
    total = float(total)
    total = total / len(numbers)
    return total

def get_average(student):
    homework = average(student['homework'])
    quizzes = average(student['quizzes'])
    tests = average(student['tests'])

    homework *= 10/100
    quizzes *= 30/100
    tests *= 60/100
    
    score = homework + quizzes + tests
    return score

print(get_average(armin))

def get_letter_Grade(score):
    if score >= 90:
        return 'A'

    elif score >= 80:
        return 'B'

    elif score >=70:
        return 'C'
    
    elif score >= 60:
        return 'D'

    else:
        return 'F'
    
print(str(armin['name']),get_letter_Grade(get_average(armin)))

def get_class_average(students):
    result = []
    for pupil in students:
        result.append(get_average(pupil))
    
    return average(result)

print("Class Average:",get_class_average(students))
print('Class Letter Grade:',get_letter_Grade(get_class_average(students)))
