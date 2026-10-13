#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include<sys/stat.h>

# define BUFFER_SIZE 1024

int CalculateFileSize(char FileName[])
{
    struct stat sobj;

    stat(FileName,&sobj);

    return sobj.st_size;
}

int main()
{   
    char Fname[30] = {'\0'};
    int iRet = 0;

    printf("Enter the file name : \n");
    scanf("%[^'\n']s",Fname);

    iRet = CalculateFileSize(Fname);

    printf("File size is : %d bytes\n",iRet);

    return 0;
}