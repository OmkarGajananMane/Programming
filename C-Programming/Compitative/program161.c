/* Accept the String from user and accept 1 chracter and check that character is present 
int that STring or not .
INput : Omkar 
        k
Output : TRUE
*/
#include<stdio.h>
#define TRUE 1
#define FALSE 0

typedef int BOOL;

BOOL ChkChar(char *str, char ch)
{
    while(*str != '\0')
    {
        if(*str == ch)
        {
            return TRUE;
        }
        *str++;    
    }
    return FALSE;
    
}

int main()
{
    char arr[20];
    char cValue = 0;
    BOOL bRet = FALSE;

    printf("Enter the String :\n");
    scanf("%[^\n]s",arr);

    printf("Enter the Character : \n");
    scanf(" %c",&cValue);

    bRet  = ChkChar(arr,cValue);

    if(bRet == TRUE)
    {
        printf("Character Found : \n");
    }
    else
    {
        printf("Character Not Found : \n");
    }

    return 0;
}