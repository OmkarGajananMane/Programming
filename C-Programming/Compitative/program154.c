/*  Accept the String from user and Check wether it contains vowels or not .

Input : Marvellous
Output : TRUE
Input : xyz
Output : FALSE

*/
#include<stdio.h>
# define TRUE 1
# define FALSE 0

typedef int BOOL;

BOOL ChkVowels(char *str)
{
    while(*str != 0)
    {
        if(*str == 'A' ||*str == 'E' || *str == 'I' ||*str == 'O' ||*str == 'U'||
        *str == 'a'||*str == 'e'||*str == 'i'||*str == 'o'||*str == 'u')
        {
            return 1;
        }
        else
        {
            return 0;
        }
        str++;
    }
}

int main()
{
    char arr[20];
    BOOL bRet = FALSE;

    printf("Enter the String :\n");
    scanf("%[^\n]s",arr);

    bRet = ChkVowels(arr);
    if(bRet == TRUE)
    {
        printf("The String Contains Vowel\n");
    }
    else
    {
        printf("The String does Not Contain Vowel\n");
    }

    return 0;
}