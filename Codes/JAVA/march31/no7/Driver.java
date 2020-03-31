package march31.no7;

public class Driver
{
    public static void main(String[] args)
    {
        Customer c1 = new Customer(1,"Cen",50);
        Customer c2 = new Customer(2,"Nec",100);
        Invoice i1 = new Invoice(10,c1,100.0);

        System.out.println(i1.getCustomerName());
        
        i1.setCustomer(c2);
        System.out.println(i1.getAmountAfterDiscount());
    }
}