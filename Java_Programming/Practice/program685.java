import java.io.*;
import java.util.*;

class program685
{
    public static void main(String A[]) throws Exception
    {       
        Scanner sobj = new Scanner(System.in);
        String FolderName = null;

        System.out.println("Enter Folder name : ");
        FolderName = sobj.nextLine();

        File fobj = new File(FolderName);

        if(fobj.exists())
        {
            System.out.println("Folder exists");
        }
        else
        {
            System.out.println("There is no such folder");
        }

    }
}