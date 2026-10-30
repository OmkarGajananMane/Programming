import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class StudyLog
{
    public String Subject;
    public double Duration;

    public StudyLog(String a, double d)
    {
        this.Subject = a;
        this.Duration = d;
    }
}

class program840
{
    public static void main(String A[])
    {
        StudyLog sobj1 = new StudyLog("C",2.5);
        StudyLog sobj2 = new StudyLog("Java",4.5);
            
        System.out.println(sobj1);
        System.out.println(sobj2);

        LocalDate lobj = LocalDate.now();

        System.out.println(lobj);
    }
}