#include<stdio.h>

float CircleArea(float fRadius)
{
    double dArea = 0.0;

    dArea = 3.14 * fRadius * fRadius;

    return dArea;
}
int main()
{
    float fValue = 0.0f;
    double dRet = 0.0;

    printf("Enter the Radius\n");
    scanf("%f",&fValue);

    dRet = CircleArea(fValue);

    printf("The Area of Circle is %f\n",dRet);
    return 0;
}