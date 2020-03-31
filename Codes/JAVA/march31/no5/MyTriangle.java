package march31.no5;

public class MyTriangle
{
    private
        MyPoint v1,v2,v3;
    
    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        v1 = new MyPoint(x1,y1);
        v2 = new MyPoint(x2,y2);
        v3 = new MyPoint(x3,y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public double distance(MyPoint x, MyPoint y)
    {
        int xDiff = x.getX() - y.getX();
        int yDiff = x.getY() - y.getY();

        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    public double getPerimeter()
    {
        return distance(v1,v2) + distance(v2,v3) + distance(v3,v1);
    }

    public String getType()
    {
        double a = distance(v1,v2);
        double b = distance(v2,v3);
        double c = distance(v3,v1);

        if(((a + b + c)/3) == a)
        {
            return "Equilateral";
        }

        else if((a!=b) && (b!=c) && (c!=a))
        {
            return "Scalene";
        }

        else
        {
            return "Isosceles";
        }
    }

    @Override
    public String toString()
    {
        return "MyTriangle[v1=" + v1.toString() + ",v2=" + v2.toString() + ",v3=" + v3.toString() + "]";
    }



        


}