#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

bool LinearSearch(int Arr[], int iSize)
{
    int iCnt = 0;
    bool bFlag = false;

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        if(Arr[iCnt] == 11)
        {
            bFlag = true;  // With Flag
            break;
        }
    }
    return bFlag;
}

int main()
{
    int iLength = 0, iCnt = 0;
    bool bRet = false;
    int *Brr = NULL;

    printf("Enter the bumber of Elements\n");
    scanf("%d",&iLength);

    Brr = (int *)malloc(sizeof(int) * iLength);
    
    printf("Enter the Elements : \n");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    bRet = LinearSearch(Brr,iLength);

    if(bRet == true)
    {
        printf("Element is present:\n");
    }
    else
    {
        printf("Element is not present:\n");
    }

    free(Brr);

    return 0;
}