/* Accept the String from user and 1 Character and Display its last Occurence of that 
Character .
Input : Marvellous Multi
            M
Output : 11
Input : Omkar 
        z
Output : -1
*/

#include<stdio.h>

int LastChar(char *str, char ch)
{
    int iCount = 0,iPos = -1;

    while(*str != '\0')
    {
        if(*str == ch)
        {
            iPos = iCount;
        }
        iCount++;
        str++;
    }
    return iPos;
    
}

int main()
{
    char arr[20];
    char cValue;
    int iRet = 0;

    printf("Enter the String : \n");
    scanf("%[^\n]s",arr);

    printf("Enter the Character : \n");
    scanf(" %c",&cValue);

    iRet = LastChar(arr,cValue);

    printf("Character Location is %d\n",iRet);

    return 0;
}