/*Accept the String from user and find & display the Digits 
Input : Om123k4r
Output : 1234
*/
#include<stdio.h>

void DisplayDigit(char *str)
{
    while(*str != '\0')
    {
        if(*str >= '0' && *str <= '9')
        {
            printf("%c",*str);
        }
        *str++;
    }
    printf("\n");
}
int main()
{
    char arr[20];

    printf("Enter the String :\n");
    scanf("%[^\n]s",arr);

    DisplayDigit(arr);

    return 0;
}