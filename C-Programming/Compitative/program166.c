/* Accept String from user and copy the contents of that string into another string using
strcpy() function.
Input : Marvellous Multi OS
Output : Marvellous Multi OS
*/
#include<stdio.h>

void StrCpyX(char *src, char *dest)
{
    while(*src != '\0')
    {
        *dest = *src;
        src++;
        dest++;
    }
    *dest = '\0';
    
}
int main()
{
    char arr[30] = "Marvellous Multi OS";
    char brr[20];

    StrCpyX(arr,brr);

    printf("%s\n",brr);


    return 0;
}