#include<stdio.h>

void Number(int iNo)
{
    if(iNo < 0)
    {
        iNo = -iNo;
    }

    if(iNo > 0 && iNo <= 50)
    {
        printf("%d is Small\n",iNo);
    }
    else if(iNo > 50 && iNo <= 100)
    {
        printf("%d is Medium\n",iNo);
    }
    else
    {
        printf("%d is Large\n",iNo);
    }
}
int main()
{
    int iValue = 0;

    printf("Enter number\n");
    scanf("%d",&iValue);

    Number(iValue);

    return 0;
}