#include<stdio.h>

double SquareMeter(int iValue)
{
    double dMeter = 0;
    dMeter = iValue * 0.0929;
    return dMeter;
}
int main()
{
    int iValue = 0.0f;
    double dRet = 0.0;

    printf("Enter Area in Square feet\n");
    scanf("%d",&iValue);

    dRet = SquareMeter(iValue);

    printf("The Square Meter is %lf\n",dRet);

    return 0;
}