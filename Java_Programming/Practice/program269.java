import java.util.*;

class StringX
{
    public void Display(String str)
    {
        System.out.println("Received string is : "+str);
    }
}

class program269
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String data = null;
        StringX strobj = new StringX();

        System.out.println("Enter string : ");
        data = sobj.nextLine();

        strobj.Display(data);
    }
}