import java.io.*;
import java.util.*;

class program665
{
    public static void main(String A[])
    {
        FileWriter fwobj = null;
        
        try
        {
            fwobj = new FileWriter("Demo.txt");
            fwobj.write("Jay Ganesh...");
            fwobj.close();  // IMP
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        finally
        {
            
        }
    }
}