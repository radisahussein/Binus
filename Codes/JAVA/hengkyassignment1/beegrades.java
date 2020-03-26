package hengkyassignment1;

public class beegrades
{
    private String gradeID;
    private int gradeValue;
    private beesubject subject;

    public beegrades()
    {
        this.gradeID = "";
        this.gradeValue = -1;
        this.subject = new beesubject();
    }

    public String getID()
    {
        return gradeID;
    }

    public void setID(String gradeID)
    {
        this.gradeID = gradeID;
    }

    public int getGradeValue()
    {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue)
    {
        this.gradeValue = gradeValue;
    }

    public beesubject getSubject()
    {
        return subject;
    }

    public void setSubject(beesubject subject)
    {
        this.subject = subject;
    }

};