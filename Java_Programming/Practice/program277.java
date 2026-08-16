import java.util.*;
import Marvellous.StringX;

class program277
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String data = null;
        StringX strobj = new StringX();     // Error
        int iRet = 0;

        System.out.println("Enter string : ");
        data = sobj.nextLine();

        iRet = strobj.CountCapital(data);

        System.out.println("Number of capital characters : "+iRet);

        iRet = strobj.CountSmall(data);

        System.out.println("Number of small characters : "+iRet);

        iRet = strobj.CountDigits(data);

        System.out.println("Number of digits are : "+iRet);

        iRet = strobj.CountSpace(data);

        System.out.println("Number of white spaces are : "+iRet);

        iRet = strobj.CountSpecial(data);

        System.out.println("Number of special symbols are : "+iRet);
    }
}