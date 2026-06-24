/*Accept the String from user and also 1 character and display index of that character
Input : Omkar
        m
Output : 1
*/

#include<stdio.h>

int FirstChar(char *str, char ch)
{
    int iCount = 0;

    while(*str != '\0')
    {
        if(*str == ch)
        {
            return iCount;
        }
        iCount++;
        str++;
    }
    return -1;
}

int main()
{
    char arr[20];
    char cValue = 0;
    int iRet = 0;
    
    printf("Enter the String : \n");
    scanf("%[^\n]s",arr);

    printf("Enter the Character : \n");
    scanf(" %c",&cValue);

    iRet = FirstChar(arr,cValue);

    printf("Character location is %d\n",iRet);

    return 0;
}