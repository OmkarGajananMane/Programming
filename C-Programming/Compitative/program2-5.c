#include<stdio.h>

#define TRUE 1
#define FALSE 0 

typedef int BOOL;

BOOL ChkEven(int iNo)
{
    if((iNo % 2) == 0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int main()
{
    int iValue = 0;
    BOOL bRet = FALSE;

    printf("Enter number\n");
    scanf("%d",&iValue);

    bRet = ChkEven(iValue);

    if(bRet)     // it means (bRet == 1)
    {
        printf("%d is Even\n",iValue);
    }
    else
    {
        printf("%d is odd\n",iValue);
    }

    return 0;
}