/*
Count Capital letters 
Input : Marvellous Multi OS
Output : 4
*/
#include<stdio.h>

int CountCapital(char *str)
{
    int iCnt = 0;

    while(*str != 0)
    {
        if(*str >= 'A' && *str <= 'Z')
        {
            iCnt++;
        }
        str++;
    }
    return iCnt;
}

int main()
{
    char arr[20];
    int iRet = 0;

    printf("Enter the String : \n");
    scanf("%[^\n]",arr);

    iRet = CountCapital(arr);

    printf("%d\n",iRet);

    return 0;
}