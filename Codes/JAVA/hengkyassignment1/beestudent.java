package hengkyassignment1;

import java.util.ArrayList;
import java.util.List;

public class beestudent
{
    private String studentName, studentGender, studentID;
    private List<beegrades> gradeList;

    public beestudent()
    {
        this.studentName = "";
        this.studentGender = "";
        this.studentID = "";
        this.gradeList = new ArrayList<beegrades>();
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentGender()
    {
        return studentGender;
    }

    public void setStudentGender(String studentGender)
    {
        this.studentGender = studentGender;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }

    public List<beegrades> getGradeList()
    {
        return this.gradeList;
    }

    public int getStudentScore(String subjectID)
    {
        for (beegrades grade : this.gradeList)
        {
            if(grade.getSubject().getSubjectID().equals(subjectID))
            {
                return grade.getGradeValue();
            }
        }
        return -1;
    }

    public void setGradeList(beegrades grade)
    {
        this.gradeList.add(grade);
    }
};