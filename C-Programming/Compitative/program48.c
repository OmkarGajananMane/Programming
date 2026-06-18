##include<stdio.h>

int KMtoMeter(int iNo)
{
    int iMeter = 1;
    iMeter = iNo * 1000;
    return  iMeter;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter the distance \n");
    scanf("%d",&iValue);

    iRet = KMtoMeter(iValue);

    printf("%d\n",iRet);

    return 0;
}