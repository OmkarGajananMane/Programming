/*
Addition of all the number bet range 
Input : 23 30 
output : 212      
    */
#include<stdio.h>

int RangeSum(int iStart, int iEnd)
{
    int iCnt = 0, iSum = 0;

    if(iStart < 0 || iStart > iEnd)
    {
        printf("Invalid range");   // Instead of this we can also write return 0 in if condition
    }
    else
    {
        for(iCnt = iStart; iCnt <= iEnd; iCnt++)
        {
            iSum = iSum + iCnt;
        }
    }
    return iSum;

    
    return iSum;
}
int main()
{
    int iValue1 = 0,iValue2 = 0, iRet = 0;
    
    printf("Enter the Starting point\n");
    scanf("%d",&iValue1);

    printf("Enter the End point\n");
    scanf("%d",&iValue2);

    iRet = RangeSum(iValue1, iValue2);

    printf("Addition is %d\n",iRet);

    return 0;
}

/*  
    if(iStart < 0 || iStart > iEnd)
    {
        iSum = iSum + iCnt;
        return 0;
    }
*/