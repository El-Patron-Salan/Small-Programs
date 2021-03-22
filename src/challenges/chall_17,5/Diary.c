#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#define MAX_INPUT_SZ 256

char* getDate();

int main(int argC, char *argV[]){
    //point the file   
    FILE *filePointer ;
    //dynamically allocated memory
    char *input = malloc( MAX_INPUT_SZ ) ;

    //open the file and tell which action it has to do
    filePointer = fopen("notes.txt", "a") ;
    
    //check if file exist
    if( filePointer == NULL ) {
        perror( "Could not open file ") ;
        return 1;
    }

    if( input == NULL ) {
        perror( "Memory not allocated!" ) ;
        return 1;
    }
    
    char* date = getDate(); 
    //loop as long as user won't terminate program
    while( !feof( stdin ) ) {

        fputs( date, filePointer); 
        //user makes input
        fgets( input, MAX_INPUT_SZ, stdin ) ;
        //put his input in file
        fputs( input, filePointer ) ;

    }
    free( date ) ;
    free( input ) ;
    puts( "\nClosing file" ) ;
    fclose(filePointer) ;
    return 0;
}

char* getDate() {
    
   time_t s ;
   struct tm* current_time ;

   s = time(NULL) ;

   current_time = localtime(&s) ;

   int day = current_time -> tm_mday;
   int month = current_time -> tm_mon + 1 ;
   int year = current_time -> tm_year + 1900 ;

   char* actualDate = malloc(sizeof(actualDate));
   
   if( !actualDate ) {
        perror( "Memory not allocated - getDate()" ) ;
        exit( EXIT_FAILURE ) ;
   }

   sprintf( actualDate, "[%d/%d/%d]", day, month, year ) ;

   return actualDate ;
}

