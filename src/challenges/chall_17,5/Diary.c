#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

#define MAX_INPUT_SZ 256
#define LENGTH_OF_PIN 4
#define PIN_NUMBER 2000

char* askForPIN();
int* verifyProvidedPIN( char* in );
bool checkIfCorrectPIN( int* PIN );
char* getDate();
char* showPreviousEntries();

int main(int argC, char *argV[]) {
    
    int count = 0;
    bool checker = false;
    char* PIN;
    do{
        
        if(count == 3){
            printf( "\n\n\t\t****Access denied****\n\n" );
            exit(1);
        }
        PIN = askForPIN() ;
        checker = checkIfCorrectPIN( verifyProvidedPIN(PIN));
        count++;

    }while( !checker );
    free( PIN );

    //point the file   
    FILE *filePointer ;
    //dynamically allocated memory
    char *input = malloc( MAX_INPUT_SZ ) ;

    //open the file and tell which action it has to do
    filePointer = fopen("notes.txt", "a") ;
    
    //check if file exist
    if( filePointer == NULL || input == NULL ) {
        perror( "Error!" ) ;
        exit(1) ;
    }
    
    char* date = getDate() ;
    printf( "%sWrite in your Diary:\n", date ) ;
    

    fputs( date, filePointer ) ; 
    //user makes input
    fgets( input, MAX_INPUT_SZ, stdin ) ;
    //put his input in file
    fputs( input, filePointer ) ;
    //generate two empty lines so it's more readable
    fputs( "\n\n", filePointer ) ;
    

    //free memory
    free( date ) ;
    free( input ) ;

    puts( "\nClosing file" ) ;
    fclose(filePointer) ;
    return 0;
}

char* askForPIN() {
    
    char* input = ( char* )malloc(sizeof(input)) ;
    if( input == NULL ) {
        perror( "Memory not allocated! " ) ;
        exit( EXIT_FAILURE ) ;
    }
    printf( "\nProvide PIN code: " ) ;
    fgets(input, LENGTH_OF_PIN, stdin) ;
    return input;
}

int* verifyProvidedPIN( char* in ) {
    
    for(int i = 0; strlen(in); ++i) {
        if( !isdigit( in[i] ) )
            return 0;
    }
    return (int*) in;
}

bool checkIfCorrectPIN( int* PIN ) {
    return (PIN == PIN_NUMBER) ? true : false;
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

   sprintf( actualDate, "[%d/%d/%d] ", day, month, year ) ;

   return actualDate ;
}

char* showPreviousEntries() {
    
    FILE* fp;
    char* buffer ;
    long numbytes ;

    fp = fopen( "notes.txt", "r" ) ;
    
    if( fp == NULL ) {
        perror( "File to read not found! " ) ;
        return "\n***Proceeding without output***\n" ;
    }
    //move to the end
    fseek( fp, 0L, SEEK_END ) ;
    //get the size of file
    numbytes = ftell( fp ) ;
    //move to the start
    fseek( fp, 0L, SEEK_SET ) ;
    //allocate memory space
    buffer = ( char* ) calloc( numbytes, sizeof(char)) ;
    
    if( buffer == NULL ){
            perror( "Couldn't allocate memory for buffer! " ) ;
            return "\n***Proceeding without output***\n" ;
    }
    //with fread() copy all the text into an array (buffer) 
    fread(buffer, sizeof(char), numbytes, fp) ;
    //close file
    fclose(fp) ;

    return buffer ;
}


