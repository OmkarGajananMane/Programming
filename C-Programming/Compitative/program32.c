#include<stdio.h>

int DollarToINR(int iNo)
{
    int iAns = 0;
    iAns = iNo * 70;
    return iAns;
}


int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter the number of USD\n");
    scanf("%d",&iValue);

    iRet = DollarToINR(iValue);

    printf("Value in INR is %d\n",iRet);

    return 0;
}