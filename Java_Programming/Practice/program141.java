import java.util.*;

class program141
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        int iCnt = 0;

        System.out.println("Enter the number of Elements: ");
        int iLength = sobj.nextInt();

        // Brr = (int *)malloc(sizeof(int)) * iLength;
        int Brr[] = new int[iLength];

        System.out.println("Enter the elements : ");
        for(iCnt = 0; iCnt < Brr.length; iCnt++)
        {
            Brr[iCnt] = sobj.nextInt();
        }

        System.out.println("Elements of Array are : ");
        for(iCnt = 0; iCnt < Brr.length; iCnt++)
        {
            System.out.println(Brr[iCnt]);
        }              
    }
}