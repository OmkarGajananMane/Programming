class program721
{
    public static void main(String A[])
    {
        String header = "A.txt 10";

        System.out.println("Actual header length : "+header.length());    // 8
        
        System.out.println("Number of white spaces we need : "+(100 - header.length()));    // 11
        
        int size = 100 - header.length();

        for(int i = 1; i <= size; i++)
        {
            header = header + " ";
            System.out.println(i);
        }
    
        System.out.println("Updated header length is : "+header.length());
    }
}