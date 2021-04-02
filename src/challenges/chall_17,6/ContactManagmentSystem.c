#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

#define MAX_FNAME_LENGTH 16
#define MAX_SNAME_LENGTH 32
#define MAX_PHONENUMBER_LENGTH 15
#define BUFFER_SIZE 256

/*
 *This is simpler approach for making this program
 */
char* inputFirstName();
char* inputSurname();
char* inputPhoneNumber();
char* ordinals( int i );

int main(int argC, char* argV[]) {
    
    char* x = malloc( sizeof(char));
    x = inputPhoneNumber();
    printf( "\n%s\n", x);
    return 0;
}

char* inputFirstName() {
    
    char* name;
    name = (char*) malloc( MAX_FNAME_LENGTH * sizeof(char) );
    printf( "%s: ", "First name" );
    fgets( name, MAX_FNAME_LENGTH, stdin );
    return name;
}

char* inputSurname() {
        
    char* sName;
    sName = (char*) malloc( MAX_SNAME_LENGTH * sizeof(char) );
    printf( "%s: ", "Surname");
    fgets( sName, MAX_SNAME_LENGTH, stdin );
    return sName;
}


//phone number functions
char* inputPhoneNumber() {
    
    char* phoneNumber;
    char* whichOrdinal;
    phoneNumber = (char*) malloc( MAX_PHONENUMBER_LENGTH * sizeof(char) );
    whichOrdinal = (char*) malloc( 2 * sizeof(char) );

    printf( "%s: ", "Phone number" );
    fgets( phoneNumber, MAX_PHONENUMBER_LENGTH, stdin );
    //check if it has character
    for(int i = 0; i < strlen(phoneNumber) - 1; ++i) {
        if( !isdigit( phoneNumber[i] ) ){
            
            whichOrdinal = ordinals(i + 1);
            printf( "\nDetected error in input at %d%s position\nTry again\n"
                    , i + 1, whichOrdinal);
            //use recursion to make user provide correct input
            return inputPhoneNumber();
        }
    }
    free(whichOrdinal);
    return phoneNumber;
}
//add ordinals to the number so it'd look more professional
char* ordinals( int i ) {

    switch(i) {
        case 1:
            return "st";
            break;
        case 2:
            return "nd";
            break;
        case 3:
            return "rd";
            break;
        default:
            return "th";
            break;
    }
}
//search for duplicates
bool searchDuplicatedNumber(FILE *fp, char* search_Number) {
    
    char* properties = (char*) malloc( BUFFER_SIZE );
    //point to character
    char *ptc;
    while( ( fgets(properties, BUFFER_SIZE, fp) ) != NULL ) {
        
        ptc = strstr(properties, search_Number);
        if( ptc != NULL) {
            return true;
        }
    }
    return false;
}
