import java.util.*;

class Matrix
{
    public int Arr[][];
    public int iRow;
    public int iCol;

    public Matrix(int iRow, int iCol)
    {
        System.out.println("Inside Matrix Constructor");

        this.iRow = iRow;
        this.iCol = iCol;

        Arr = new int[iRow][iCol];
    }

    protected void finalize()
    {
        System.out.println("Inside finalize method");
        
       Arr = null;
       System.gc(); 
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elements of matrix");

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
        }
    }

    public void Display()
    {
        System.out.println("Elements of matrix are : ");

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

class program792
{
    public static void main(String A[])
    {        
        Scanner sobj = new Scanner(System.in);

        int iRow = 0, iCol = 0;
        int i = 0, j = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of coluns : ");
        iCol = sobj.nextInt();

        Matrix mobj = new Matrix(iRow, iCol);

        mobj.Accept();
        mobj.Display();

        mobj = null;

        System.gc();
    }

}