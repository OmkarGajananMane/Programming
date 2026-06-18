#include<stdio.h>

int MuiltDigit(int iNo)
{
    int iMult = 1, iDigit = 0;
    
    if(iNo < 0)
    {
        iNo = -iNo;
    }
    
    while(iNo != 0)
    {
       iDigit = iNo % 10;
       iMult = iMult * iDigit;
       iNo = iNo / 10;
    }
    return iMult;
    
    
}
    
int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter the number \n");
    scanf("%d",&iValue);

    iRet = MuiltDigit(iValue);

    printf("%d\n",iRet);


    return 0;
}

//The Time Complexity is N