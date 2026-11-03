import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate a, String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    public String toString()
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description;
    }
}

class program843
{
    public static void main(String A[])
    {
        LocalDate lobj = LocalDate.now();

        StudyLog sobj1 = new StudyLog(lobj,"C Programming",3.5,"Pointers in C");
        StudyLog sobj2 = new StudyLog(lobj,"JAva Programming",5.5,"Inheritance in java");

        System.out.println(sobj1);  //         System.out.println(sobj1.toSting());  
        System.out.println(sobj2);
    }
}