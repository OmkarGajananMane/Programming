import java.util.*;

class program837
{
    public static void main(String A[])
    {
        ArrayList <String> aobj = new ArrayList <String> ();

        aobj.add("Pune");
        aobj.add("Mumbai");
        aobj.add("Satara");
        aobj.add("Nashik");
        aobj.add("Mumbai");

        if(aobj.contains("Satara"))
        {
            System.out.println("Satara is present in arraylist");
        }

    }
}