/*  Accept the Character from User and print its Correspounding Case Sensitive
Input : Q
Output : q
Input : a
Output : A
*/

#include<stdio.h>

void Display(char ch)           // Arr[i] = (char)(Arr[i] + 32);
{
    if((ch >= 'A') && (ch <= 'Z'))
    {
        ch = (char)(ch) + 32;
    }
    else if((ch >= 'a') && (ch <= 'z'))
    {
        ch = (char)(ch) - 32;
    }

    printf("%c\n",ch);
}

int main()
{
    char cValue = '\0';

    printf("Enter the Characters\n");
    scanf("%c",&cValue);

    Display(cValue);

    return 0;
}