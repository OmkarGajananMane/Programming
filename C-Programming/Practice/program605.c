#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>

# define BUFFER_SIZE 1024

int CountCapital(char *FileName)
{
    char Buffer[BUFFER_SIZE] = {'\0'};
    int fd = 0, iRet = 0, iCount = 0, i = 0;

    fd = open(FileName,O_RDONLY);
    if(fd == -1)
    {
        printf("Unable to open file\n");
        return;
    }

    while((iRet = read(fd,Buffer,sizeof(Buffer))) != 0)
    {
        // LOGIC

        memset(Buffer,'\0',sizeof(Buffer));
    }

    return iCount;
}

int main()
{   
    char Fname[30] = {'\0'};

    printf("Enter the file name : \n");
    scanf("%[^'\n']s",Fname);

    DisplayFile(Fname);

    return 0;
}