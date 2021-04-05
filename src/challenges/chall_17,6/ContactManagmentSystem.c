#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <time.h>

#define BASE_DECIMAL 10
#define MAX_FNAME_LENGTH 16
#define MAX_SNAME_LENGTH 32
#define MAX_PHONENUMBER_LENGTH 15
#define BUFFER_SIZE 256

//prototypes
char* inputFirstName();
char* inputSurname();
char* inputPhoneNumber();
bool searchDuplicatedNumber(FILE *fp, char* search_Number);
char* checkConditions(FILE *fp);
char* ordinals( int i );
char* generateID();
FILE *checkInAllContacts();
void addNewContact( char* path, FILE *allContacts );


int main(int argC, char* argV[]) {
    //declare
    char* id;
    char* option;
    int integer_option;
    char *eptr;

    //allocate
    id = malloc(5 * sizeof(char));
    option = malloc(sizeof(char));

    //check
    if( id == NULL || option == NULL ) {
        puts( "Memory allocation failed" );
        return 0;
    }

    printf(     "\n\t\t***Contact management system***\n1. Add new contact\n2. Show all contacts\n3. Show specific contact\n"      );
    fgets( option, 3, stdin );
    
    //assign
    id = generateID();
    integer_option = strtol( option, &eptr, BASE_DECIMAL );

    switch(integer_option) {
        
        case 1:
            addNewContact(id, checkInAllContacts());
            fclose(checkInAllContacts());
            break;

    }
    return 0;
}

//functions-----------------------

char* inputFirstName() {
    
    char* name;
    name = (char*) malloc( MAX_FNAME_LENGTH * sizeof(char) );
    
    if( name == NULL ) {
        puts( "Memory allocation failed - inputFirstName" );
        exit( EXIT_FAILURE );
    }


    printf( "\n\n%s: ", "First name" );
    fgets( name, MAX_FNAME_LENGTH, stdin );
    return name;
}

char* inputSurname() {
        
    char* sName;
    sName = (char*) malloc( MAX_SNAME_LENGTH * sizeof(char) );

    if( sName == NULL ) {
        puts( "Memory allocation failed - inputSurname" );
        exit( EXIT_FAILURE );
    }


    printf( "\n%s: ", "Surname");
    fgets( sName, MAX_SNAME_LENGTH, stdin );
    return sName;
}


//phone number functions
char* inputPhoneNumber() {
    
    char* phoneNumber;
    phoneNumber = (char*) malloc( MAX_PHONENUMBER_LENGTH * sizeof(char) );
    
    if( phoneNumber == NULL ) {
        puts( "Memory allocation failed - inputPhoneNumber" );
        exit( EXIT_FAILURE );
    }

    printf( "\n%s: ", "Phone number" );
    fgets( phoneNumber, MAX_PHONENUMBER_LENGTH, stdin );
    return phoneNumber;
}
//search for duplicates
bool searchDuplicatedNumber(FILE *fp, char* search_Number) {
    
    char* properties = (char*) malloc( BUFFER_SIZE * sizeof(char) );

    if( properties == NULL ) {
        puts( "Memory allocation failed - searchDuplicatedNumber" );
        exit( EXIT_FAILURE );
    }
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
    if( phone_Number == NULL || which_Ordinal == NULL ) {
        puts( "Memory allocation failed - checkConditions" );
        exit( EXIT_FAILURE );
    }
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
        fgets(&continue_Question, 3, stdin);
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
char* generateID() {
    srand(time(NULL));
    char* str_id = malloc(4 * sizeof(char));
    if( str_id == NULL ) {
        puts( "Memory allocation failed - generateID" );
        exit( EXIT_FAILURE );
    }
    sprintf(str_id, "%d", (rand() % (99999 - 10000 + 1)) + 10000);
    return str_id;
}

//files handling functions

//needed to look for duplicates
FILE *checkInAllContacts() {
    
    FILE *fp;
    fp = fopen( "All_Contacts.txt", "r");
    if( fp == NULL ) {
        printf( "\nCould not open file\n" );
        exit( EXIT_FAILURE );
    }
    return fp;
}

//add new contact
void addNewContact( char* path, FILE *allContacts ) {
        
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
    //check allocation
    if(f_Name == NULL || surname == NULL || ph_Number == NULL) {
        puts( "Memory allocation failed - addNewContact" );
        exit( EXIT_FAILURE );
    }
    //assign functions to variables
    f_Name = inputFirstName();
    surname = inputSurname();
    ph_Number = checkConditions(allContacts);
    printf( "Generated id: %s\n", path );
    
    //add them to file
    fprintf( fp, "\nFirst name: %s", f_Name );
    fprintf( fp, "\nSurname: %s", surname );
    fprintf( fp, "\nPhone number: %s", ph_Number );
    fprintf( fp, "\nid: %s\n", path );

    //free memory and close file
    free(f_Name);
    free(surname);
    free(ph_Number);
    fclose(fp);
}
