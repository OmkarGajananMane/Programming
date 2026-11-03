import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;

    public StudyLog(LocalDate a, String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    @Override
    public String toString()
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description;
    }

    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }
}

class StudyTracker
{
    public ArrayList <StudyLog> Database;

    public StudyTracker()
    {
        Database = new ArrayList<StudyLog>();
    }

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("---- Enter the details of your study ----");
        System.out.println("-----------------------------------------");

        LocalDate lobj = LocalDate.now();

        System.out.println("We are entering the date as : "+lobj);

        System.out.println("Enter the name of subject like C/C++/Java etc");
        String sub = sobj.nextLine();

        System.out.println("Enetr the time period of your study : ");
        double dur = sobj.nextDouble();

        // Issue resolved
        sobj.nextLine();
        
        System.out.println("Please provide the description of your study : ");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(lobj, sub, dur, desc);

        Database.add(studyobj);

        System.out.println("Study log gets inserted succesfully");
        
        System.out.println("-----------------------------------------");
    }

    public void DisplayLog()
    {

    }

    public void ExportToCSV()
    {

    }

    public void SummaryByDate()
    {

    }

    public void SummaryBySubject()
    {

    }
}

class program859
{
    public static void main(String A[])
    {
        int iChoice = 0;

        StudyTracker stobj = new StudyTracker();
        Scanner sobj = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("-- Welcome to Marvellous Study Tracker --");
        System.out.println("-----------------------------------------");

        do
        {
            System.out.println("-----------------------------------------");
            System.out.println("Please select appropriate option : ");
            System.out.println("-----------------------------------------");
            
            System.out.println("1 : Insert new study log");
            System.out.println("2 : View all study logs");
            System.out.println("3 : Export study log to CSV");
            System.out.println("4 : Summary of study log by date");
            System.out.println("5 : Summary of study log by subject");
            System.out.println("6 : Exit the application");
            
            System.out.println("-----------------------------------------");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                // Insert new log
                case 1:
                    stobj.InsertLog();
                    break;
                
                // View all study logs
                case 2:
                    stobj.DisplayLog();
                    break;
                  
                // Export to CSV
                case 3:
                    stobj.ExportToCSV();
                    break;
                
                // Summary by date
                case 4:
                    stobj.SummaryByDate();
                    break;
                 
                // Summary by subject
                case 5:
                    stobj.SummaryBySubject();
                    break;
                
                // Terminate the project    
                case 6:
                    break;
                 
                default:
                    System.out.println("Please enter valid option");
                    break;
            }

        }while(iChoice != 6);

        System.out.println("-----------------------------------------");
        System.out.println("----- Thank for using Study Tracker -----");
        System.out.println("-----------------------------------------");

    }   // End of main
}       // End of class