package march31.no4;

public class Driver
{
    public static void main(String[] args)
    {
        MyPoint p1 = new MyPoint(1,2);
        MyPoint p2 = new MyPoint(4,5);

        MyCircle c1 = new MyCircle(p1,4);
        MyCircle c2 = new MyCircle(p2,5);

        System.out.println(c1.getRadius());

        System.out.println(c1.getArea());
        System.out.println(c2.getCircumference());

        System.out.println(c1.distance(c2));
    }
}