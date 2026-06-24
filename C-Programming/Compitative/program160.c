/* Accept the String from user and count the WhiteSpaces in it .
Input : Jay Ganesh
Output : 1
*/
#include<stdio.h>

int CountWhite(char *str)
{
    int iCount = 0;
    while(*str != '\0')
    {
        if(*str == ' ')
        {
            iCount++;
        }
        *str++;
    }
    return iCount;
}
int main()
{
    char arr[20];
    int iRet = 0;

    printf("Enter the String : \n");
    scanf("%[^\n]s",arr);

    iRet = CountWhite(arr);

    printf("%d\n",iRet);

    return 0;
}