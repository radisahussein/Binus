package Banking;

public class Driver
{
    public static void main(String[] args)
    {
        Account a1 = new Account(100);
        Account a2 = new Account(50);

        a1.deposit(100);
        a2.deposit(100);

        Customer c1 = new Customer("Cen", "Nec");
        Customer c2 = new Customer("Tol","Ko");

        c1.setAccount(a1);
        
        Bank b1 = new Bank("BCA");
        System.out.println(b1.getNumOfCustomers());

        b1.addCustomer(c1);
        b1.addNewCustomer("ber", "lin");
        b1.addCustomer(c2);

        System.out.println(b1.getNumOfCustomers());

        System.out.println(b1.getCustomer(2));

        System.out.println(b1.getAllCustomers());



    }
}