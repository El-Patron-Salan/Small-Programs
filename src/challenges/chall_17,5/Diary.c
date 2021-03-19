#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_INPUT_SZ 256

//Add day/month/year to every input from user

int main(int argC, char *argV[]){
    //point the file   
    FILE *filePointer ;
    char *input = malloc( MAX_INPUT_SZ ) ;

    //open the file and tell which action it has to do
    filePointer = fopen("notes.txt", "a") ;
    
    //check if file exist
    if( filePointer == NULL ) {
        printf( "Could not open file ") ;
        return 1;
    }
    
    
    //loop as long as user won't terminate program
    while( !feof( stdin ) ) {
        
        //user makes input
        fgets( input, MAX_INPUT_SZ, stdin ) ;
        //put his input in file
        fputs( input, filePointer ) ;

    }
    free( input ) ;
    puts( "\nClosing file" ) ;
    fclose(filePointer) ;
    return 0;
}


