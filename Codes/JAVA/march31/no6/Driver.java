package march31.no6;

public class Driver
{
    public static void main(String[] args)
    {
        MyPoint p1 = new MyPoint(1,2);
        MyPoint p2 = new MyPoint(5,6);

        MyRectangle t1 = new MyRectangle(p1,p2);

        System.out.println(t1.getArea());
        System.out.println(t1.getPerimeter());
        System.out.println(t1.toString());
    }
}