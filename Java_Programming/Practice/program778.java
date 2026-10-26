import java.util.*;

class program778
{
    public static void main(String A[])
    {
        HashMap <String, Integer> hobj = new HashMap<String, Integer>();

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter string : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        for(String s : Tokens)
        {
            System.out.println(s);
        }

    }
}