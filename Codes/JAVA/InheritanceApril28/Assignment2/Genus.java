package InheritanceApril28.Assignment2;


public class Genus 
{
    private String genusName;

    public
        Genus(String g)
        {
            this.genusName = g;
        }

        String getGenusName()
        {
            return this.genusName;
        }

        void setGenusName(String name)
        {
            this.genusName = name;
        }

    @Override
    public String toString()
    {
        return "Genus: " + this.getGenusName();
    }



}