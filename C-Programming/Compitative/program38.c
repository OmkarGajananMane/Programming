/*
    Accept kilometer and convert it into meters
    Input : 5
    Output : 5000
*/
#include<stdio.h>

int KmToMeter(int iNo)
{
    int iMet = 0;
    iMet = iNo * 1000;
    return iMet;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter the Distance\n");
    scanf("%d",&iValue);

    iRet = KmToMeter(iValue);

    printf("%d Meters\n",iRet);

    return 0;
}