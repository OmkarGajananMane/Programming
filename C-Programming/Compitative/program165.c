#include<stdio.h>

void StrRev(char *str)
{
    char *start = NULL;
    char *end = NULL;
    char temp = '\0';

    start = str;

    while(*str != '\0')
    {
        str++;
    }
    str--;
    end = str;

    while(start < end)
    {
        temp = *start;
        *start = *end;
        *end = temp;

        start++;
        end--;
    }
    
}
int main()
{
    char arr[20] = {'\0'};

    printf("Enter the String : \n");
    scanf("%[^\n]s",arr);

    StrRev(arr);

    printf("The Modified String is : %s\n",arr);

    return 0;
}