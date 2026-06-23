/*  Display the String in Reverse order 
Input : Marvellou
Output : uollevraM
*/
#include<stdio.h>

void ReverseDisplay(char *str)
{
    char *start = NULL;

    start = str;

    while(*str != '\0')
    {
        str++;
    }

    str--;
    
    while(start <= str)
    {
        printf("%c",*str);
        str--;
    }
    printf("\n");
}

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n']s",Arr);

    ReverseDisplay(Arr);

    return 0;
}

// WE Create here 2 pointers ,1st points to '\0' last elements as we were performing 
// Reverse Order So , And Another Pointer(2nd Pointer) Points to 1st Element of Array
// WE DONT HAVE ANY END POINT IF WERE TRAVELING FROM LAST ELEMENTS (WERE TO STOP)
// So we Start the 2nd Pointer from last element till it Reches to 1st pointer .