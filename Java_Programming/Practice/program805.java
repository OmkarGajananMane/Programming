// 5!

// 5 * 4 * 3 * 2 * 1
// 1 * 2 * 3 * 4 * 5

import java.io.*;

class program805
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iFact = 0;
        int i = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;

        for(i = 1; i <= iNo; i++)
        {
            iFact = iFact * i;
        }

        System.out.println("Factorial is : "+iFact);
    }
}