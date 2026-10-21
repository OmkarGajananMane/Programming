class program711
{
    public static void main(String A[])
    {
        String header = "india  is  my  country";

        String Arr[] = header.split(" ");

        System.out.println("Number of words are : "+Arr.length);

        for(int i = 0; i < Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
    }
}