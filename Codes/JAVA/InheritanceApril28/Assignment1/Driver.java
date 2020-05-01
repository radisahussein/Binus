package InheritanceApril28.Assignment1;


public class Driver 
{
    public static void main(String[] args)
    {
        Shape s1 = new Shape();

        System.out.println(s1.getColor());
        System.out.println(s1.toString());

        Circle c1 = new Circle(10);
        System.out.println(c1.getArea());
        System.out.println(c1.toString());

        Rectangle r1 = new Rectangle(10, 20);
        System.out.println(r1.getArea());
        System.out.println(r1.toString());

        Square sq1 = new Square(5);
        System.out.println(sq1.getSide());
        System.out.println(sq1.getArea());
        System.out.println(sq1.toString());

    }
}