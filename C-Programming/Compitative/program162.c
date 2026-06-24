/*Accept the String from user and aslo accept 1 character and Count that character .
Input : Omkar Mane 
        M
Output : 2
*/
#include<stdio.h>

int CountChar(char *str, char ch)
{
    int iCount = 0;

    while(*str != 0)
    {
        if(*str == ch)
        {
            iCount++;
        }
        str++;
    }
    return iCount;
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

    iRet = CountChar(arr,cValue);

    printf("Character Frequency is : %d\n",iRet);

    return 0;
}