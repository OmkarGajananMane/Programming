#include<stdio.h>

int CountDiff(int iNo)
{
    int iOddSum = 0, iEvenSum = 0, iDigit = 0;
    
    if(iNo < 0)
    {
        iNo = -iNo;
    }

    while(iNo != 0)
    {
        iDigit = iNo % 10;
        
        if((iDigit % 2) == 0)
        {
            iEvenSum = iEvenSum + iDigit;
        }
        else
        {
            iOddSum = iOddSum + iDigit;
        }
        
        iNo = iNo / 10;
    }
    return (iEvenSum - iOddSum);
    
}
int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter the number \n");
    scanf("%d",&iValue);

    iRet = CountDiff(iValue);

    printf("%d\n",iRet);


    return 0;
}

//The Time Complexity is N