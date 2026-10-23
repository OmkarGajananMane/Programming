import java.util.*;

class program739
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter string : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        System.out.println("Number of words : "+Tokens.length);

        String temp = null;

        temp = Tokens[0];

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].length() > temp.length())
            {
                temp = Tokens[i];
            }
        }

        System.out.println("Largest word is : "+temp+" having lenggth : "+temp.length());
    }
}