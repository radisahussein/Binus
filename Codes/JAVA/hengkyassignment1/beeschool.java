//Radisa Hussein Rachmadi - 2301891752
package hengkyassignment1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class beeschool
{
    private List<beesubject> subjects;
    private List<beestudent> students;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        beeschool main = new beeschool();
        main.mainMenu(sc);
    }

    public beeschool()
    {
        this.subjects = new ArrayList<beesubject>();
        this.students = new ArrayList<beestudent>();
    }

    public void mainMenu(Scanner sc)
    {
        while (true)
        {
            System.out.println("\nBee School");
            System.out.println("=======================");
            System.out.println("1. Insert New Subject");
            System.out.println("2. View All Subject");
            System.out.println("3. Insert New Student");
            System.out.println("4. View All Student");
            System.out.println("5. Insert Student Score");
            System.out.println("6. View Student Score");
            System.out.println("7. Exit");
            System.out.println("=======================");

            System.out.print("Choose menu: ");
            int input = sc.nextInt();
            switch (input)
            {
                case 1:
                    this.newSubject(sc);
                    break;

                case 2:
                    this.viewSubject();
                    break;

                case 3:
                    this.newStudent(sc);
                    break;
                
                case 4:
                    this.viewStudent();
                    break;

                case 5:
                    this.newStudentScore(sc);
                    break;

                case 6:
                    this.viewStudentScore();
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    continue;
            }
        }
        
    }

    public void newSubject(Scanner sc)
    {
        beesubject subject = new beesubject();
        
        // Check if subject name is valid
        checkSubject:
        while (true)
        {
            System.out.print("Input subject name [3-25 characters | ends with 'Subject']: ");
            String inputSubjectName = sc.nextLine();
            int subjectIndex = inputSubjectName.indexOf(" Subject");

            if (subjectIndex != -1 && inputSubjectName.substring(0,subjectIndex).length() >= 3 && inputSubjectName.substring(0,subjectIndex).length() <= 25)
            {
                for (beesubject sub : this.subjects)
                {
                    if (sub.getSubjectName().equals(inputSubjectName))
                    {
                        System.out.print("Subject already exists!");
                        continue checkSubject;
                    }
                }
                subject.setSubjectName(inputSubjectName);
                break;
            }

        }

        // Input category

        while(true)
        {
            System.out.print("Input subject category [Main|Elective]: ");
            String inputCategory = sc.nextLine();
            
            //Check if valid
            if(inputCategory.equalsIgnoreCase("Main") || inputCategory.equalsIgnoreCase("Elective"))
            {
                subject.setSubjectCategory(inputCategory);
                break;
            }
        }

        // Create ID
        subject.setSubjectID(this.generateID("SB", this.subjects));


        //add to list of subjects
        this.subjects.add(subject);

        System.out.println("\n Successfully inserted new subject!");

        
    }

    public void viewSubject()
    {
        if (this.subjects.size() == 0)
        {
            System.out.println("No Data!");
        }

        else
        {
            System.out.println("Subject ID" + "\t" + "Subject Name" + "\t\t" +  "Subject Category");
            System.out.println("========================================================");
            for (beesubject subject : this.subjects)
            {
                System.out.println(subject.getSubjectID() + "\t\t" + subject.getSubjectName() + "\t\t" + subject.getSubjectCategory());
            }
            System.out.println("========================================================");
        }
    }

    public void newStudent(Scanner sc)
    {
        beestudent student = new beestudent();

        //User input new student
        while(true)
        {
            System.out.print("Input student name [3-25 characters]: ");
            String inputName = sc.nextLine();

            if (inputName.length() >= 3 && inputName.length() <= 25)
            {
                student.setStudentName(inputName);
                break;
            }
        }

        //user input student gender
        while(true)
        {
            System.out.println("Input student gender [Male | Female]: ");
            String inputGender = sc.nextLine();

            if (inputGender.equalsIgnoreCase("Male") || inputGender.equalsIgnoreCase("Female"))
            {
                student.setStudentGender(inputGender);
                break;
            }
        }

        //create student id
        student.setStudentID(this.generateID("ST",this.students));

        //add student to list
        this.students.add(student);

        System.out.println("\nSuccesfully inserted new student!");
    }

    public void viewStudent()
    {
        if (this.students.size() == 0)
        {
            System.out.println("No Data!");
        }

        else
        {
            System.out.println("Student ID\tStudent Name\tStudent Gender");
            System.out.println("========================================================");
            
            for (beestudent student : this.students)
            {
                System.out.println(student.getStudentID() + "\t\t" + student.getStudentName() + "\t\t" + student.getStudentGender());
            }
            System.out.println("========================================================");

        }
    }

    public void newStudentScore(Scanner sc)
    {
        if (this.students.size() != 0 && this.subjects.size() != 0)
        {
            System.out.println("Student Data:");
            this.viewSubject();
            System.out.println("Subject Data:");
            this.viewStudent();

            //Enter student id
            beestudent student;
            studentID:
            while(true)
            {
                System.out.print("Input Student ID:");
                String checkStudentID = sc.nextLine();

                //Check student id
                for (beestudent std : this.students)
                {
                    if (checkStudentID.equals(std.getStudentID()))
                    {
                        student = std;
                        break studentID;
                    }
                }
            }

            //enter subject id
            beesubject subject = null;
            while(true)
            {
                System.out.print("Input subject ID:");
                String checkSubjectID = sc.nextLine();

                //check subject id
                boolean exists = false;
                for(beesubject sbj : this.subjects)
                {
                    if(sbj.getSubjectID().equals(checkSubjectID))
                    {
                        subject = sbj;
                        exists = true;
                        break;
                    }
                }
            
                if(exists)
                {
                    //check if subject already has a score
                    if(student.getStudentScore(checkSubjectID) != -1)
                    {
                        System.out.println("Subject score already inserted!");
                    }

                    else
                    {
                        break;
                    }
                }
            }

            beegrades grade = new beegrades();
            grade.setSubject(subject);

            while(true)
            {
                System.out.print("Input score [0-100]: ");
                String inputScore = sc.nextLine();

                //String to integer
                int inputtedScore = Integer.parseInt(inputScore);
                
                if (inputtedScore >= 0 && inputtedScore <= 100)
                {
                    grade.setGradeValue(inputtedScore);
                    break;
                }
            }

            //generate score id
            grade.setID(this.generateID("SC", student.getGradeList()));

            //save score data
            student.setGradeList(grade);
            
            System.out.println("Successfully inserted student score!");
        }

        else
        {
            System.out.println("Student and Subject data must exist!");
        }
    }

    public void viewStudentScore()
    {
        for (beestudent student : this.students)
        {
            System.out.println("Student ID\tStudent Name\tStudent Gender");
            System.out.println("========================================================");
            System.out.println(student.getStudentID() + "\t\t" + student.getStudentName() + "\t\t" + student.getStudentGender());
            System.out.println("\nScores: ");
            System.out.println("========================================================");
            if (student.getGradeList().size() == 0)
            {
                System.out.println("No Data");
            }
            else
            {
                for (beegrades grade : student.getGradeList())
                {
                    System.out.println(grade.getID() + "\t" + grade.getSubject().getSubjectName() + "\t" + Integer.toString(grade.getGradeValue()));
                }
            }
            
            System.out.println("========================================================");


            
        }
    }

    public String generateID(String suffix,List<?> list)
        {
            String num = Integer.toString(list.size() + 1);

            if (num.length() < 3)
            {
                int length = num.length();

                for (int i = 0; i < 3-length; i++)
                {
                    num = "0" + num;    
                }
            }

            return suffix + num;
        }

}
