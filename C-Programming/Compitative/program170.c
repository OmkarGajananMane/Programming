/* Accept 2 String from user and concat 2nd String after 1st String(Implement strcat() function)
Input : "Marvellous Infosystems"
          "Logic Building"
Output : "Marvellous Infosystems Logic Building"
*/

#include<stdio.h>

void StrCatX(char *src,char *dest)
{
    while(*src != '\0')
    {
        src++;
    }
    while(*dest != '\0')
    {
        *src = *dest;
        src++;
        dest++;
    }
    *dest = '\0';
}

int main()
{
    char arr[50] = "Marvellous Infosystems ";
    char brr[30] = "Logic Building";

    StrCatX(arr,brr);

    printf("%s\n",arr);

    return 0;
}