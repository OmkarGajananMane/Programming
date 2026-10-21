import java.util.*;

class program708
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String str = null;

        System.out.println("Enter string : ");
        str = sobj.nextLine();

        System.out.println("String is : "+str+" having length : "+str.length());
    
        str = str.trim();
        
        System.out.println("String is : "+str+" having length : "+str.length());

        str = str.replaceAll("\\s+"," ");

        System.out.println("String is : "+str+" having length : "+str.length());
    }
}