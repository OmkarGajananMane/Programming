import java.io.*;

class program814
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

        iPower = (int)Math.pow(x, y);

        System.out.println("Result is : "+iPower);
    }
}