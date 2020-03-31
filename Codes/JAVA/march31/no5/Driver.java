package march31.no5;

public class Driver
{
    public static void main(String[] args)
    {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(6,0);
        MyPoint p3 = new MyPoint(3,4);

        MyTriangle t1 = new MyTriangle(p1, p2, p3);

        System.out.println(t1.getPerimeter());
        System.out.println(t1.getType());
        
    }
}