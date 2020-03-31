package march31.no1;


public class Book
{

    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(){}

    public Book(String name, Author author, double price)
    {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, double price,int qty)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Author getAuthor()
    {
        return this.author;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQty()
    {
        return this.qty;
    }

    public void setQty(int qty)
    {
        this.qty = qty;
    }


    @Override
    public String toString()
    {
        return "Book[" + "name=" + getName() + ",author=" + getAuthor().toString() + ",price=" + getPrice() + ",qty=" + getQty() + "]";
    }

}