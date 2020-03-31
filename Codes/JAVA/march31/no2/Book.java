package march31.no2;

import java.util.ArrayList;

public class Book
{

    private String name;
    private ArrayList<Author> authors = new ArrayList<Author>();
    private double price;
    private int qty = 0;

    public Book(String name, Author author, double price)
    {
        this.name = name;
        this.authors.add(author);
        this.price = price;
    }

    public Book(String name, ArrayList<Author> authors, double price, int qty)
    {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, Author author, double price,int qty)
    {
        this.name = name;
        this.authors.add(author);
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

    public String getAuthors()
    {
        String out = "";
        for(int i = 0; i < this.authors.size(); i++)
        {
            out += authors.get(i).toString() + ", ";
        }

        return out;

    }

    public void addAuthors(Author author)
    {
        this.authors.add(author);
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
        return "Book[" + "name=" + getName() + ",authors=" + getAuthors() + ",price=" + getPrice() + ",qty=" + getQty() + "]";
    }

}