import java.util.*;

class program787
{
    public static void main(String A[])
    {        
        int Arr[][] = {{10,20,30}, {40,50,60}, {70,80,90}};

        for(int i = 0; i < Arr.length; i++)
        {
            for(int j = 0; j < Arr[i].length; j++)
            {
                System.out.print(Arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

}