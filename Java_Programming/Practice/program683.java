import java.io.*;
import java.util.*;

class program683
{
    public static void main(String A[]) throws Exception
    {       
        String Fname = null;
        int iRet = 0;
        File fobj = null;
        FileInputStream fiobj = null;

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        Fname = sobj.nextLine();

        fobj = new File(Fname);

        fiobj = new FileInputStream(fobj);

        byte Buffer[] = new byte[10];

        if(fobj.exists())
        {
            String str = null;

            while((iRet = fiobj.read(Buffer)) != -1)
            {
                str = new String(Buffer,0,iRet);    // IMP
                System.out.print(str);
                str = null;
            }
        }
        else
        {
            System.out.println("There is no such file");
        }

    }
}