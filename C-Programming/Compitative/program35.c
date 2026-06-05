#include<stdio.h>

int  FactorialDiff(int iNo)
{
    int iCnt = 0, iEven = 1, iOdd = 1;

    if(iNo < 0)
    {
        iNo = -iNo;
    }

    for(iCnt = 1; iCnt <= iNo; iCnt++)
    {
        if((iCnt % 2) == 0)
        {
            iEven = iEven * iCnt;
        }
        else
        {
            iOdd = iOdd * iCnt;
        }       
    }
    return iEven - iOdd;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter the number \n");
    scanf("%d",&iValue);

    iRet = FactorialDiff(iValue);

    printf("Factorial difference is %d\n",iRet);

    return 0;
}

// The time complexity is N