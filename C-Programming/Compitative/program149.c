/*
Input : %
Output : TRUE           
Input : d 
Output : FALSE

*/
#include<stdio.h>

#define TRUE 1
#define FALSE 0

typedef int BOOL;

BOOL ChkSpecial(char ch)
{
    if( (ch >= '!' && ch <= '/')||
        (ch >= ':' && ch <= '@')||
        (ch >= '[' && ch <= '`')||
        (ch >= '{' && ch <= '~'))
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
    char cValue = '\0';
    BOOL bRet = FALSE;

    printf("Enter the Character :\n");
    scanf("%c",&cValue);

    bRet = ChkSpecial(cValue);

    if(bRet == TRUE)
    {
        printf("It is Special Character\n");
    }
    else
    {
        printf("It is Not Special Character\n");
    }
    return 0;
}