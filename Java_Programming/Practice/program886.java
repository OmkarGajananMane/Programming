import java.util.*;

class program886
{
    public static void main(String A[])
    {
        int Arr[] = {10,13,34,21,15,7,24};

        for(int no : Arr)
        {
            System.out.print(no+"\t");
        }

        System.out.println();

        Arrays.sort(Arr,2,6);
        
        for(int no : Arr)
        {
            System.out.print(no+"\t");
        }

        System.out.println();
    }
}