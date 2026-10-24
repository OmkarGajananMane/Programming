// Input : india is my country i live in india
// Output : bharat is my country i live in bharat

import java.util.*;

class program751
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter string : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        int iCount = 0;

        StringBuffer FinalStr = new StringBuffer("");

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].equals("india"))
            {
                FinalStr = FinalStr.append("bharat");
                FinalStr = FinalStr.append(" ");

                continue;
            }

            FinalStr = FinalStr.append(Tokens[i]);

            FinalStr = FinalStr.append(" ");
        }

        String Output = new String(FinalStr);

        Output = Output.trim();

        System.out.println(Output);
    }
}