package march31.no8;

public class Customer
{
    private
        int ID;
        String name;
        char gender;

    public Customer(int ID, String name, char gender)
    {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

    public int getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public char getGender()
    {
        return this.gender;
    }

    public String toString()
    {
        return getName() + "(" + getID() + ")";
    }

}