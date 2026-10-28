import java.io.*;

class program802
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        System.out.println("Input value is : "+iNo);
    }
}