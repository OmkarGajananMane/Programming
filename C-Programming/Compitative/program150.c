/* Accept character from user and Display its ASCII value in decimal,octal,hexadeciaml format
Input : A
Output : Deciaml        65
         Octal          0101
         Hexadecimal    0x41 

*/
#include<stdio.h>

void Display(char ch)
{
    printf("Decimal\t\t%d\n",ch);
    printf("Octal\t\t0%o\n",ch);
    printf("Hexadecimal\t0x%X\n",ch);
}
int main()
{
    char cValue = '\0';

    printf("Enter the Character\n");
    scanf("%c",&cValue);

    Display(cValue);

    return 0;
}