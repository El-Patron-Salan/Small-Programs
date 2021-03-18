#include <stdio.h>
#include <string.h>

int main(void){
    //point the file   
    FILE *filePointer;
    char input[2000];

    //open the file and tell which action it has to do
    filePointer = fopen("notes.txt", "w") ;
    
    //check if file exist
    if( filePointer == NULL ) {
        printf( "Could not open file ") ;
        return 1;
    }
    puts( "Write smth: " ) ;
    
    //loop as long as user won't terminate program
    while( !feof( stdin ) ) {
        
        //user makes input
        scanf("%s", input) ;
        //put his input in file
        fputs(input, filePointer) ;

    }

    puts( "\nClosing file" ) ;
    fclose(filePointer) ;
    return 0;


}
