import java.io.*;

class program804
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        System.out.println("Input value is : "+iNo);

        int iDigit = 0;
        int iTemp = 0;

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            System.out.println(iDigit);
            iNo = iNo / 10;
        }

        System.out.println("Original number is : "+iTemp);
    }
}