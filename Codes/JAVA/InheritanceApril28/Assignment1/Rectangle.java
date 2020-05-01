package InheritanceApril28.Assignment1;

public class Rectangle extends Shape
{
    private double width;
    private double length;

    public
        Rectangle()
        {
            super();
            this.width = 1.0;
            this.length = 1.0;
        }

        Rectangle(double width, double length)
        {
            super();
            this.width = width;
            this.length = length;
        }

        Rectangle(double width, double length, String color, boolean filled)
        {
            super(color, filled);
            this.width = width;
            this.length = length;
        }

        double getWidth()
        {
            return width;
        }

        void setWidth(double width)
        {
            this.width = width;
        }

        double getLength()
        {
            return length;
        }

        void setLength(double length)
        {
            this.length = length;
        }

        double getArea()
        {
            return width*length;
        }

        double getPerimeter()
        {
            return (width*2 + length*2);
        }

    @Override
    public String toString()
    {
        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of " + super.toString();
    }
}