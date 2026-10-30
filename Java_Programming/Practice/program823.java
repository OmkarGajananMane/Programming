import java.io.*;

class program823
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iDigit = 0;
        int iTemp = 0;
        int iSquare = 0;
        int iCount = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        iSquare = iNo * iNo;

        while(iNo != 0)
        {
            iCount++;
            iNo = iNo / 10;
        }

        
    }
}