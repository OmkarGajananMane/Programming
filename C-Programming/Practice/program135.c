// Important code for frequently asked in interview

#include<stdio.h>
#include<stdlib.h>


// Time Complexity O(N)
int Maximum(int Arr[], int iSize)
{
    int iCnt = 0;
    int iMax = 0;

    iMax = Arr[0];

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        if(Arr[iCnt] > iMax)  
        {  
            iMax = Arr[iCnt];
        }
    }
    return iMax;
}

int main()
{

    int iLength = 0, iCnt = 0, iRet = 0;
    int *Brr = NULL;

    printf("Enter the number of Elements\n");
    scanf("%d",&iLength);

    Brr = (int *)malloc(sizeof(int) * iLength);
    
    printf("Enter the Elements : \n");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    iRet = Maximum(Brr,iLength);

    printf("Maximum element is %d\n",iRet);

    free(Brr);

    return 0;
}