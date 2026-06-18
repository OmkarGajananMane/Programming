/*
Accept the temperature in Fehrenhiet from user and convert it into Celcius 
(1 Celcius = (Fehrenhiet - 32) * (5/9))

Input = 10
Output = -12.2222
*/
#include<stdio.h>

double FhToCs(float fTemp)
{
    double dTemp = 0;
    dTemp = (fTemp - 32) * 0.5555;
    return dTemp;
}
int main()
{
    float fValue = 0.0f;
    double dRet = 0.0;

    printf("Enter the Temperature in Fahrenhiet\n");
    scanf("%f",&fValue);

    dRet = FhToCs(fValue);

    printf("The Celcius of given Fehrenhiet is %lf\n",dRet);

    return 0;
}