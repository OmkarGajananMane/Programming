#include<stdio.h>

int Table(int iNo)
{
    int iCnt = 0;
    int iTab = 1;

    for(iCnt = 10; iCnt >= 1; iCnt--)
    {
        iTab = iNo * iCnt;
        printf("%d\t",iTab);
    }
    
}
int main()
{
    int iValue = 0;

    printf("Enter the number \n");
    scanf("%d",&iValue);

    Table(iValue);

    return 0;
}