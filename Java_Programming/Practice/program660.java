import java.io.*;

class program660
{
    public static void main(String A[])
    {
        File fobj = null;
        boolean bRet = false;
        
        try
        {
            fobj = new File("Demo.txt");
            
            bRet = fobj.exists();

            if(bRet == true)
            {
                System.out.println("File already present");
            }
            else
            {
                fobj.createNewFile();
                System.out.println("File gets succesfully created");
            }
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }
    }
}