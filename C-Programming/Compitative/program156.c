/*  Accept the STring from user and Covert the only Capital letters to small
Input : Marvellous Multi OS
Output : marvellous multi
*/
#include<stdio.h>

void strlwrx(char *str)
{

    while(*str != '\0')
    {
        if(*str >= 'A' && *str <= 'Z')
        {
            *str = (char)(*str + 32);
        }
        *str++;
    }
}

int main()
{
    char arr[20];

    printf("Enter the String \n");
    scanf("%[^\n]s",arr);

    strlwrx(arr);

    printf("Modified string is %s\n",arr);

    return 0;
}