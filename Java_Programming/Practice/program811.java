// 5!

// 5 * 4 * 3 * 2 * 1
// 1 * 2 * 3 * 4 * 5

import java.io.*;

class program811
{
    public static void main(String A[]) throws Exception
    {
        int iFact[] = {1,1,2,6,24,120,720,5040,40320,362880};

        int iNo = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        int iTemp = 0, iDigit = 0;
        long iSum = 0;

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            iSum = iSum + iFact[iDigit];
            iNo = iNo / 10;            
            
            if(iSum > iTemp)
            {
                break;
            }
        }

        if(iSum == iTemp)
        {
            System.out.println("It is strong number");
        }
        else
        {
            System.out.println("It is not a strong number");
        }
    }
}