/*
Input : 2395            // To Check Whether the number contain 0 or not .
Output : There is a no zero 
*/
#include<stdio.h>
#include<stdbool.h>

#define TRUE 1
#define FALSE 0

bool ChkZero(int iNo)
{
    int iDigit = 0;

    while(iNo > 0)
    {
        iDigit = iNo % 10;
        if(iDigit == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
        iNo = iNo / 10;
    }

}

int main()
{
    int iValue = 0;
    bool bRet = FALSE;

    printf("Enter number\n");
    scanf("%d",&iValue);

    bRet = ChkZero(iValue);

    if(bRet == TRUE)
    {
        printf("It Contains Zero : \n");
    }
    else
    {
        printf("There is no Zero : \n");
    }

    return 0;
}