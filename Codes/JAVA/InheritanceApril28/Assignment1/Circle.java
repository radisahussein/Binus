package InheritanceApril28.Assignment1;

public class Circle extends Shape
{
    private double radius = 1.0;

    public
        Circle()
        {
            super();
            this.radius = 1.0;
        }

        Circle(double radius)
        {
            super();
            this.radius = radius;
        }

        Circle(double radius, String color, boolean filled)
        {
            super(color, filled);
            this.radius = radius;
        }

        double getRadius()
        {
            return radius;
        }

        void setRadius(double radius)
        {
            this.radius = radius;
        }

        double getArea()
        {
            double pi = 3.14;
            return (pi * (radius*radius));
        }

        double getPerimeter()
        {
            double pi = 3.14;
            return (2 * pi * radius);
        }

    @Override
    public String toString()
    {
        return "A Circle with radius=" + radius +", which is a subclass of " + super.toString();
    }


}