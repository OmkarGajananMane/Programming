/*
Input : 2395    // count the only 2
Output : 1 
*/
#include<stdio.h>

int CountTwo(int iNo)
{
    int iDigit = 0, iCount = 0;

    while(iNo > 0)
    {
        iDigit = iNo % 10;
        if(iDigit == 2)
        {
            iCount++;
        }
        iNo = iNo / 10;
    }
    return iCount;
}

int main()
{
    int iValue = 0, bRet = 0;

    printf("Enter the number : \n");
    scanf("%d",&iValue);

    bRet = CountTwo(iValue);

    printf("%d\n",bRet);

    return 0;
}