/*
Input : 23 30 , Addition of all even elements of given Range
Output : 108
*/
#include<stdio.h>

int RangeSumEven(int iStart, int iEnd)
{
    int iCnt = 0, iSum = 0;

    if(iStart < 0 || iStart > iEnd)
    {
        printf("Invalid Range\n");
    }
    else
    {
        for(iCnt = iStart; iCnt <= iEnd; iCnt++)
        {
            if((iCnt % 2) == 0)
            {
                iSum = iSum + iCnt;
            }
        }
    }
    return iSum;
}

int main()
{
    int iValue1 = 0, iValue2 = 0, iRet = 0;

    printf("Enter the Starting Point :\n");
    scanf("%d",&iValue1);

    printf("Enter the End Point :\n");
    scanf("%d",&iValue2);

    iRet = RangeSumEven(iValue1,iValue2);

    printf("Addition is %d\n",iRet);

    return 0;
}