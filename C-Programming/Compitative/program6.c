#include<stdio.h>

void Display(int iNo)
{
    int iCnt = 0;
    // Updater
    if(iNo < 0)
    {
        iNo = -iNo;
    }
    while(iCnt < iNo)
    {
        printf("*\n");
        iCnt++;
    }
}
int main()
{
    int iValue = 0;

    printf("Enter number");
    scanf("%d",&iValue);

    Display(iValue);

    return 0;
}
