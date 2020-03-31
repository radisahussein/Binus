package march31.no7;

public class Invoice
{
    private
        int ID;
        Customer customer;
        double amount;

    public Invoice(int ID, Customer customer, double amount)
    {
        this.ID = ID;
        this.customer = customer;
        this.amount = amount;
    }

    public int getID()
    {
        return this.ID;
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getCustomerName()
    {
        return this.customer.getName();
    }

    public double getAmountAfterDiscount()
    {
        double discount = this.amount * (this.customer.getDiscount()/100);
        return this.amount-discount;
    }
}