// Important code for frequently asked in interview

#include<stdio.h>
#include<stdlib.h>

// Time Complexity O(N)
int Minimum(int Arr[], int iSize)
{
    int iCnt = 0;
    int iMin = 0;

    iMin = Arr[0];

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        if(Arr[iCnt] < iMin)  
        {  
            iMin = Arr[iCnt];
        }
    }
    return iMin;
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

    iRet = Minimum(Brr,iLength);

    printf("Minimum element is %d\n",iRet);

    free(Brr);

    return 0;
}