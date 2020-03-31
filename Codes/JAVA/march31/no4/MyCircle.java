package march31.no4;

public class MyCircle
{
    private
        MyPoint center;
        int radius;

    public MyCircle()
    {
        this.radius = 1;
        center = new MyPoint(0,0);
    }

    public MyCircle(int x, int y, int radius)
    {
        center = new MyPoint(x,y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius)
    {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius()
    {
        return this.radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public MyPoint getCenter()
    {
        return this.center;
    }

    public void setCenter(MyPoint center)
    {
        this.center = center;
    }

    public int getCenterX()
    {
        return this.center.getX();
    }

    public void setCenterX(int x)
    {
        this.center.setX(x);
    }

    public int getCenterY()
    {
        return this.center.getY();
    }

    public void setCenterY(int y)
    {
        this.center.setY(y);
    }

    public int[] getXY()
    {
        int intArray[] = new int[2];
        intArray[0] = this.center.getX();
        intArray[1] = this.center.getY();

        return intArray;

    }

    public void setXY(int x, int y)
    {
        this.center.setX(x);
        this.center.setY(y);
    }

    public double getArea()
    {
        double pi = 3.14;
        return pi * (this.radius * this.radius);
    }

    public double getCircumference()
    {
        double pi = 3.14;
        return 2 * pi * this.radius;
    }

    public double distance(MyCircle another)
    {
        int xDiff = this.center.getX() - another.center.getX();
        int yDiff = this.center.getY() - another.center.getY();

        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    @Override
    public String toString()
    {
        return "MyCircle[radius=" + this.radius + ",center=" + this.center.toString() + "]";
    }


}