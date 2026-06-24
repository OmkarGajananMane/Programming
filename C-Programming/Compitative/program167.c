/* Accept the String from user and copy the contents of that string into another string
(implement strncpy() function)
Input : Marvellous Multi OS
        10
Output : Marvellous
*/

#include<stdio.h>

void StrNCpyX(char *src, char *dest, int iCnt)
{
    while((*src != '\0') && (iCnt != 0))
    {
        *dest = *src;
        src++;
        dest++;
        iCnt--;
    }
    *dest = '\0';
}
int main()
{
    char arr[30] = "Marvellous Mutli OS";
    char brr[30];
    StrNCpyX(arr,brr,10);

    printf("%s\n",brr);

    return 0;
}