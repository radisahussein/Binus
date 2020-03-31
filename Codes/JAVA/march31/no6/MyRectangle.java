package march31.no6;

public class MyRectangle
{
    private
        MyPoint p1, p2, p3, p4;
    
    
    public MyRectangle(int x1, int y1, int x2, int y2)
    {
        p1 = new MyPoint(x1,y1);
        p2 = new MyPoint(x2,y2);
        p3 = new MyPoint(p1.getX(),getHeight());
        p4 = new MyPoint(p2.getX(),getHeight());

    }

    public MyRectangle(MyPoint p1, MyPoint p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        p3 = new MyPoint(p1.getX(),getHeight());
        p4 = new MyPoint(p2.getX(),getHeight());

    }

    public int getHeight()
    {
        if(p1.getX() > p2.getX())
        {
            return (p1.getX() - p2.getX());
        }

        else
        {
            return (p2.getX() - p1.getX());
        }
    }
    
    public int getWidth()
    {
        if(p1.getY() > p2.getY())
        {
            return p1.getY() - p2.getY();
        }

        else
        {
            return p2.getY() - p1.getY();
        }
    }

    public int getPerimeter()
    {
        return ((getWidth()*2) + (getHeight()*2));
    }

    public double getArea()
    {
        return (getWidth()*2 + getHeight()*2);
    }

    @Override
    public String toString()
    {
        return "MyRectangle[p1=" + p1.toString() + ",p2=" + p2.toString() + ",p3=" + p3.toString() + ",p4=" + p4.toString() + "]";
    }


    


}