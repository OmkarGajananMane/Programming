import java.io.*;

class program815
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iCount = 0;
        int iTemp = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iCount++;
            iNo = iNo / 10;
        }
        
        System.out.println("Number of digits are : "+iCount);
    }
}