import java.io.*;
import java.util.*;

class program724
{
    public static void main(String A[]) throws Exception
    {     
        int iRet = 0;

        Scanner sobj = new Scanner(System.in);
        String FolderName = null;
        String PackFileName = null;
        String header = "";

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        System.out.println("Enter Folder name : ");
        FolderName = sobj.nextLine();

        System.out.println("Enter the name of packed file : ");
        PackFileName = sobj.nextLine();
        
        File fobjfolder = new File(FolderName);

        if((fobjfolder.exists()) && (fobjfolder.isDirectory()))
        {
            System.out.println("Folder exists");

            File fobjpack = new File(PackFileName);
            fobjpack.createNewFile();   // Pack file gets created

            foobj = new FileOutputStream(fobjpack);

            File fArr[] = fobjfolder.listFiles();
         
            System.out.println("Number of files in folder : "+fArr.length);

            byte Buffer[] = new byte[1024];

            for(int i = 0; i < fArr.length; i++)
            {
                fiobj = new FileInputStream(fArr[i]);

                header = header + fArr[i].getName();
                header = header + " ";
                header = header + fArr[i].length();

                System.out.println("Header is : "+header);

                // Write file name and size 
                
                /*// Loop to read from fiobj & write to foobj
                
                while((iRet = fiobj.read(Buffer)) != -1)
                {
                    foobj.write(Buffer,0,iRet);
                }*/

                fiobj.close();
                header = "";
            }

            foobj.close();
            sobj.close();
        }
        else
        {
            System.out.println("There is no such folder");
        }

    }
}