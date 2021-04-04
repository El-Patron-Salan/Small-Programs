#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <time.h>

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
bool searchDuplicatedNumber(FILE *fp, char* search_Number);
char* checkConditions(FILE *fp);
char* ordinals( int i );
int generateID();

int main(int argC, char* argV[]) {
    
    //switch() {}
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
    phoneNumber = (char*) malloc( MAX_PHONENUMBER_LENGTH * sizeof(char) );

    printf( "%s: ", "Phone number" );
    fgets( phoneNumber, MAX_PHONENUMBER_LENGTH, stdin );
    return phoneNumber;
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
    free(properties);
    return false;
}
//check if p.number meets all conditions
char* checkConditions(FILE *fp) {
    
    char continue_Question;
    char* phone_Number;
    char* which_Ordinal;
    phone_Number = (char*) malloc( MAX_PHONENUMBER_LENGTH * sizeof(char) );
    which_Ordinal = (char*) malloc( 2 * sizeof(char) );

    phone_Number = inputPhoneNumber();
    
    //check if it has character
    for(int i = 0; i < strlen(phone_Number) - 1; ++i) {
        if( !isdigit( phone_Number[i] ) ){
            
            which_Ordinal = ordinals(i + 1);
            printf( "\nDetected error in input at %d%s position\nTry again\n"
                    , i + 1, which_Ordinal);
            //use recursion to make user provide correct input
            return checkConditions(fp);
        }
    }
    free(which_Ordinal);
    //check for duplicated number 
    if( searchDuplicatedNumber(fp, phone_Number) ) {
        printf( "\nPhone number -> %s is assigned to another contact!\n", phone_Number );
        //if user accidentally provided phone number that already exist in contacts
        //ask him if he wants to continue
        printf( "\nWould you like to continue?(Y/N) " );
        fgets(&continue_Question, 2, stdin);
        if(continue_Question == 'Y' || continue_Question == 'y') {
            return checkConditions(fp);
        }
        else {
            exit(0);
        }
    }
    return phone_Number;
}
//add ordinals to the number so it'd be grammatically correct 
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

//generate unique id for each contact
int generateID() {
    srand(time(NULL));
    return (rand() % (99999 - 10000 + 1)) + 10000;
}

//files handling functions
void addNewContact( char* path ) {
        
    FILE *fp;
    fp = fopen(path, "w");
    if(fp == NULL) {
        printf( "\nUnable to create file\n" );
        exit( EXIT_FAILURE );
    }
    //get user input
    char* f_Name; 
    char* surname;
    char* ph_Number;
    //allocate memory
    f_Name = (char*) malloc(MAX_FNAME_LENGTH * sizeof(char));
    surname = (char*) malloc(MAX_SNAME_LENGTH * sizeof(char));
    ph_Number = malloc(MAX_PHONENUMBER_LENGTH * sizeof(ph_Number));
    //assign functions to variables

}
