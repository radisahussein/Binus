package march31.no8;

public class Driver
{
    public static void main(String[] args)
    {
        Customer c1 = new Customer(0,"Cen",'m');
        Customer c2 = new Customer(1,"Nec",'f');

        Account a1 = new Account(8,c1,100);
        Account a2 = new Account(9,c2,200);

        a1.setBalance(400);
        a2.deposit(100);
        a1.withdraw(600);
        a1.withdraw(300);
        System.out.println(a1.getBalance());
        System.out.println(a1.toString());
        System.out.println(a2.toString());
    }
}