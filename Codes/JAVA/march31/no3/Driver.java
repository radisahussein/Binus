package march31.no3;

public class Driver
{
    public static void main(String[] args)
    {
        MyPoint p1 = new MyPoint(3,4);

        MyPoint p2 = new MyPoint(1,2);

        p1.setX(4);
        p2.setY(3);

        p1.setXY(5,10);

        System.out.println(p1.distance());
        System.out.println(p1.distance(p2));
        System.out.println(p1.toString());
    }
}