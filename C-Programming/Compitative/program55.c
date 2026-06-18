/*
    Input : 23 35   // Display the numbers in Reverse Order 
    Output : 35 34 33 32 31 30 29 28 27 26 25 24 23
*/
#include<stdio.h>

void RangeDisplayRev(int iStart, int iEnd)
{
    for(int iCnt = iEnd; iCnt >= iStart; iCnt--)
    {
        printf("%d\t",iCnt);
    }
    printf("\n");
}
int main()
{
    int iValue1 = 0, iValue2 = 0;

    printf("Enter the Stating Point\n");
    scanf("%d",&iValue1);

    printf("Enter the End Point\n");
    scanf("%d",&iValue2);

    RangeDisplayRev(iValue1,iValue2);

    return 0;
}