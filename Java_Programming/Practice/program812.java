// x = 3, y = 5
// 3 * 3 * 3 * 3 * 3

import java.io.*;

class program812
{
    public static void main(String A[]) throws Exception
    {
        int x = 0, y = 0, i = 0;
        int iPower = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Enter number as a base : ");
        x = Integer.parseInt(bobj.readLine());

        System.out.println("Enter number as a power : ");
        y = Integer.parseInt(bobj.readLine());

        iPower = 1;

        for(i = 1; i <= y; i++)
        {
            iPower = iPower * x;
        }

        System.out.println("Result is : "+iPower);
    }
}