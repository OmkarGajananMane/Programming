/*  Accept the String form user and convert the only small to Capital
Input : omkar 
Output : OMKAR
*/

#include<stdio.h>

void struprX(char *str)
{
    int iCnt = 0;
    if(*str >= 'a' && *str <= 'z')
        for(; *str != '\0'; *str++)   // OR while(str != '\0);
        {
            *str = (char)(*str - 32);
        }
}
int main()
{
    char arr[20];

    printf("Enter the String :\n");
    scanf("%[^\n]s",arr);

    struprX(arr);

    printf("Modified String is : %s\n",arr);

    return 0;
}