/*
Accept the Division from user and Display the Exam Time Table 
A at 7 AM , b at 8:30 AM , C at 9:20 AM , d at 10:30
Input : c
Output : Your Exam at 9:20   // Case-Sensitive 
*/
#include<stdio.h>
int DisplaySchedule(char chDiv)
{
    if((chDiv == 'A')||(chDiv == 'a'))
    {
        printf("Your Exam at 7 AM\n");
    }
    else if((chDiv == 'B')||(chDiv == 'b'))
    {
        printf("Your Exam at 8:30 AM\n");
    }
    else if((chDiv == 'C')||(chDiv == 'c'))
    {
        printf("Your Exam at 9:20 AM\n");
    }
    else if((chDiv == 'D')||(chDiv == 'd'))
    {
        printf("Your Exam at 10:30 AM\n");
    }
    else
    {
        printf("Invalid Input\n");
    }
}
int main()
{
    char cValue = 0;

    printf("Enter Your Division : \n");
    scanf("%c",&cValue);

    DisplaySchedule(cValue);

    return 0;
}