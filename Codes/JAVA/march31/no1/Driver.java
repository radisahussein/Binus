package march31.no1;

public class Driver
{
    public static void main(String[] args)
    {
        Author a1 = new Author();
        a1.setName("Radisa Hussein");
        a1.setGender('M');
        a1.setEmail("rash@gmail.com");

        Book b1 = new Book("BinusBook",a1,300.0,5);
        

        System.out.println(b1.toString());

    }
}