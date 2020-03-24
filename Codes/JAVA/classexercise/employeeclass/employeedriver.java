package employeeclass;

public class employeedriver
{
    public static void main(String[] args)
    {
        int id = 1;
        String firstName = "Radisa";
        String lastName = "Hussein";
        int salary = 5000;
        employee main = new employee(id,firstName,lastName,salary);

        //Get id
        System.out.println(main.getID());

        //Get First Name
        System.out.println(main.getFirstName());

        //get Last name
        System.out.println(main.getLastName());

        //get full name
        System.out.println(main.getFullName());

        //get salary
        System.out.println(main.getSalary());

        //get annual
        System.out.println(main.getAnnualSalary());

        //set salary
        main.setSalary(10000);

        //raise salary
        System.out.println(main.raiseSalary(50));

        //to string
        System.out.println(main.toString());
        
    }

};