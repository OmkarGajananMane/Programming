#include<stdio.h>

void PrintEven(int iNo)
{
    int iCnt = 1;

    if(iNo <= 0)  // Guard clause: Stops execution for invalid input (<= 0)
    {
        return;
    }
    while (iCnt <= iNo)
    {
        printf("%d\n",iCnt * 2);
        iCnt++;
    }
}

int main()
{
    int iValue = 0;

    printf("Enter number\n");

    scanf("%d",&iValue);

    PrintEven(iValue);

    return 0;
}
