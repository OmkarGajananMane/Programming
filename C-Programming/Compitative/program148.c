/*
Input : Q
Output : Q  R   S   T   U   V   W   X   Y   Z

Input : f
Output : f  e   d   c   b   a
*/
#include<stdio.h>

void Display(char ch)
{
    int iCount = 0;

    if(ch >= 'A' && ch <= 'Z')
    {
        for(iCount = ch; iCount <= 'Z'; iCount++)
        {
            printf("%c\t",iCount);
        }
        printf("\n");   
    }
    else if(ch >= 'a' && ch <= 'z')
    {
        for(iCount = ch; iCount >= 'a'; iCount--)
        {
            printf("%c\t",iCount);
        }
        printf("\n");
    }
}

int main()
{
    char cValue = '\0';

    printf("Enter the Character: \n");
    scanf("%c",&cValue);

    Display(cValue);

    return 0;
}