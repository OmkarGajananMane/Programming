class program700
{
    public static void main(String A[])
    {
        String header = "marvellous";

        System.out.println(header);

        header.replaceAll("l", "L");    // Issue

        System.out.println(header);
    }
}