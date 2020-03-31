package march31.no8;

public class Account
{
    private
        int id;
        Customer customer;
        double balance;

    public Account(int id, Customer customer, double balance)
    {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Account(int id, Customer customer)
    {
        this.id = id;
        this.customer = customer;
        this.balance = 0.0;
    }

    public int getID()
    {
        return this.id;
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getCustomerName()
    {
        return this.customer.getName();
    }

    public Account deposit(double amount)
    {
        this.balance += amount;
        return this;
    }

    public Account withdraw(double amount)
    {
        if(balance >= amount)
        {
            balance -= amount;
        }
        else
        {
            System.out.println("Amount withdrawn exceeds the current balance!");
        }

        return this;
    }

    public String toString()
    {
        return this.customer.toString() + " balance=$" + getBalance();
    }
}