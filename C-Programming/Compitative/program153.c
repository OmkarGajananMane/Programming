/*
    Accept the String from user and Display the Difference bet Capital and Small COunt
    Input : MarvellouS
    Output : 6
*/
#include<stdio.h>

int Difference(char *str)
{
    int iCnt1 = 0,iCnt2 = 0,iDiff = 0;

    while(*str != 0)
    {
        if(*str >= 'A' && *str <= 'Z')
        {
            iCnt1++;
        }
        else if(*str >= 'a' && *str <= 'z')
        {
            iCnt2++;
        }
        str++;
    }
    return (iCnt2 - iCnt1);

}
int main()
{
    char arr[20];
    int iRet = 0;

    printf("Enter the String : \n");
    scanf("%[^\n]s",arr);

    iRet = Difference(arr);

    printf("Difference is : %d\n",iRet);

    return 0;

}