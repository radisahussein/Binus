package InheritanceApril28.Assignment1;

public class Square extends Rectangle 
{
    public 
        Square()
        {
            super();
        }

        Square(double side)
        {
            super(side, side);
        }

        Square(double side, String color, boolean filled)
        {
            super(side, side, color, filled);
        }

        double getSide()
        {
            return super.getWidth();
        }

        void setSide(double side)
        {
            super.setWidth(side);
            super.setLength(side);
        }

        void setWidth(double side)
        {
            super.setLength(side);
            super.setWidth(side);
        }

        void setLength(double side)
        {
            super.setLength(side);
            super.setWidth(side);
        }

    @Override
    public String toString()
    {
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }



}