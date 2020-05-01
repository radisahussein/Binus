package InheritanceApril28.Assignment2;

public class Specimen 
{
    private
        String name;
        int cageNumber;
        Species toa; //"Type of Animal"
    
    public
        Specimen(String a, int c, Species s)
        {
            setName(a);
            setCage(c);
            setTOA(s);
        }

        void setName(String a)
        {
            name = a;
        }

        void setCage(int c)
        {
            cageNumber = c;
        }

        void setTOA(Species s)
        {
            toa = s;
        }
        
        String getName()
        {
            return name;
        }

        int getCage()
        {
            return cageNumber;
        }

        Species getTOA()
        {
            return toa;
        }

    public String toString()
    {
        return name + " is a " + toa + " in cage " + cageNumber;
    }

}