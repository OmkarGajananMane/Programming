import java.util.*;

// java program951.java programming

class program954
{
    public static void main(String A[])
    {
        if(A.length != 1)
        {
            System.out.println("Invalid number of arguments");
            return;
        }

        String str = A[0];

        LinkedHashMap <Character,Integer> frequency = new LinkedHashMap<Character,Integer>();

        for(char ch : str.toCharArray())
        {
            frequency.put(ch,frequency.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : frequency.keySet())
        {   
            if(frequency.get(ch) == 1)
            {
                System.out.println("First non-repeating character : "+ch);
                break;
            }
        }
    }
}