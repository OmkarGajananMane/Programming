/*Accept the String from user and toggle it 
Input : oMkAr
Output : OmKaR
*/
#include<stdio.h>

void strtoggleX(char *str)
{
    while(*str != '\0')
    {
        if(*str >= 'A'  && *str <= 'Z')
        {
            *str = (char)(*str + 32);
        }
        else if(*str >= 'a' && *str <= 'z')
        {
            *str = (char)(*str - 32);
        }
        str++;
    }
}
int main()
{
    char arr[20];

    printf("Enter the String : \n");
    scanf("%[^\n]s",arr);

    strtoggleX(arr);

    printf("Modified String is %s\n",arr);

    return 0;
}