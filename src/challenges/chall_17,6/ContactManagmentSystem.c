#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <time.h>

#define BASE_DECIMAL 10
#define ID_LENGTH 5
#define MAX_FNAME_LENGTH 16
#define MAX_SNAME_LENGTH 32
#define MAX_PHONENUMBER_LENGTH 15
#define BUFFER_SIZE 256

//colors
#define ANSI_COLOR_RED     "\x1b[31m"
#define ANSI_COLOR_MAGENTA "\x1b[35m"
#define ANSI_COLOR_CYAN    "\x1b[36m"
#define ANSI_COLOR_RESET   "\x1b[0m"

//structure for contact
struct Contact {
    
    char first_name[MAX_FNAME_LENGTH];
    char surname[MAX_SNAME_LENGTH];
    char phone_number[MAX_PHONENUMBER_LENGTH];
    char generated_id[ID_LENGTH];

};

//prototypes
char* inputFirstName(void);
char* inputSurname(void);
char* inputPhoneNumber(void);
bool searchDuplicatedNumber( FILE *fp, const char* search_Number );
char* checkConditions( FILE *fp );
const char* ordinals( int i );
char* generateID(void);
FILE *checkInAllContacts(void);
void addNewContact( char* path, FILE *allContacts );
void addToAllContacts( char* path );
void showAllContacts(void);
void showContactBasedOnPath( char* path );

int main( void ) {
    
    //declare
    char* id;
    char option;
    char* path_to_specific_file;

    //allocate
    path_to_specific_file = malloc(ID_LENGTH);
    id = malloc(ID_LENGTH);
    
    id = generateID();
    
    //check
    if( id == NULL || path_to_specific_file == NULL) {
        puts( "Memory allocation failed" );
        return 0;
    }
    do{

        printf(
                "\n\t\t***Contact management system***"
                "\n1. Add new contact"
                "\n2. Show all contacts"
                "\n3. Show specific contact"
                "\n*Press 'q' to exit*\n"
                );

        fgets( &option, sizeof(option), stdin );
    
        //MENU
        switch(option) {
        
            case '1':
                addNewContact(id, checkInAllContacts());
                fclose(checkInAllContacts());
                addToAllContacts(id);
                free(id);
                break;

            case '2':
                showAllContacts();
                break;

            case '3':
                do{
                    puts( "Input path to file(based on given id!): ");
                    fgets( path_to_specific_file, (ID_LENGTH + 1), stdin );
                    showContactBasedOnPath(path_to_specific_file);
                }while((getchar()) != '\n');
            
                free(path_to_specific_file);
                break;
        
            case 'q':
                printf(ANSI_COLOR_RED   "\nExiting...\n"   ANSI_COLOR_RESET);
                return 0;

            default:
                puts( "Undefined option!" );
                break;
        }
    }while(1);

    return 0;
}

//functions-----------------------

char* inputFirstName() {
    
    char* name;
    name = (char*) malloc( MAX_FNAME_LENGTH );
    
    if( name == NULL ) {
        fprintf( stderr, "Memory allocation failed - inputFirstName" );
        free(name);
        return NULL;
    }


    printf( "\n\n%s: ", "First name" );
    fgets( name, MAX_FNAME_LENGTH, stdin );
    return name;
}

char* inputSurname() {
        
    char* sName;
    sName = (char*) malloc( MAX_SNAME_LENGTH );

    if( sName == NULL ) {
        fprintf( stderr, "Memory allocation failed - inputSurname" );
        free(sName);
        return NULL;
    }


    printf( "\n%s: ", "Surname");
    fgets( sName, MAX_SNAME_LENGTH, stdin );
    return sName;
}


//phone number functions
char* inputPhoneNumber() {
    
    char* phoneNumber;
    phoneNumber = (char*) malloc( MAX_PHONENUMBER_LENGTH );
    
    if( phoneNumber == NULL ) {
        fprintf( stderr, "Memory allocation failed - inputPhoneNumber" );
        return NULL;
    }

    printf( "\n%s: ", "Phone number" );
    fgets( phoneNumber, MAX_PHONENUMBER_LENGTH, stdin );
    return phoneNumber;
}
//search for duplicates
bool searchDuplicatedNumber(FILE *fp, const char* search_Number) {
    
    char* properties = (char*) malloc( BUFFER_SIZE );

    if( properties == NULL ) {
        fprintf( stderr, "Memory allocation failed - searchDuplicatedNumber" );
        free(properties);
        return NULL;
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
    const char* which_Ordinal;

    phone_Number = malloc( MAX_PHONENUMBER_LENGTH * sizeof(phone_Number));
    
    if( !phone_Number ) {
        fprintf( stderr, "Memory allocation failed - checkConditions" );
        free(phone_Number);
        exit( EXIT_FAILURE );
    }
    phone_Number = inputPhoneNumber();
    
    //check if it has character
    size_t iteration = 0;
    const size_t phone_length = strlen( phone_Number );
    for(size_t i = 0; i < phone_length; ++i) {
        if( !isdigit( phone_Number[i] ) ){
            iteration = i + 1; 
            which_Ordinal = ordinals( iteration );
            printf( "\nDetected error in input at %ld%s position\nTry again\n"
                    , i , which_Ordinal);
            //use recursion to make user provide correct input
            return checkConditions(fp);
        }
    }
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
const char* ordinals( int i ) {

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
    
    srand( (unsigned int) time(NULL));
    
    char* str_id = malloc(5 * sizeof(str_id));
    
    if( str_id == NULL ) {
        fprintf( stderr, "Memory allocation failed - generateID" );
        free(str_id);
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
        fprintf( stderr, "\nCould not open file\n" );
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
    f_Name = (char*) malloc(MAX_FNAME_LENGTH);
    surname = (char*) malloc(MAX_SNAME_LENGTH);
    ph_Number = malloc(MAX_PHONENUMBER_LENGTH * sizeof(ph_Number));
    //check allocation
    if(f_Name == NULL || surname == NULL || ph_Number == NULL) {
        puts( "Memory allocation failed - addNewContact" );
        free(f_Name);
        free(surname);
        free(ph_Number);
        exit( EXIT_FAILURE );
    }
    //assign functions to variables
    //f_Name = inputFirstName();
    surname = inputSurname();
    ph_Number = checkConditions(allContacts);
    printf( "\nGenerated id: %s\n", path );
    
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

void addToAllContacts( char* path ) {
    
    FILE *fpS, *fpD;
    //buffer
    int putIn;
    
    fpS = fopen(path, "r");
    fpD = fopen("All_Contacts.txt", "a");

    if( fpS == NULL || fpD == NULL ) {
        fprintf( stderr, "File not found - appending" );
        exit( EXIT_FAILURE );
    }
    
    //add line to make it more readable
    fprintf(fpD, "\n----------------------------------------\n");
    
    //get text from source
    while ( (putIn = fgetc( fpS )) != EOF ) {
        //put it to destination file
        fputc(putIn, fpD);
    }
    fclose(fpS);
    fclose(fpD);
}


void showAllContacts() {
    
    FILE* fp;
    int buffer;

    fp = fopen("All_Contacts.txt", "r");
    //check if exist
    if( !fp ) {
        fprintf( stderr, "\n**File not found**\n" );
        return;
    }

    while( (buffer = fgetc(fp)) != EOF ) {
        printf(ANSI_COLOR_CYAN   "%c"   ANSI_COLOR_RESET , buffer );
    }
    fclose(fp);
}

void showContactBasedOnPath( char* path ) {
    
    FILE* fp;
    int buffer;

    fp = fopen(path, "r");
    //check if exist
    if( !fp ) {
        fprintf( stderr, "\n**File not found**\n" );
        return;
    }

    while( (buffer = fgetc(fp)) != EOF ) {
        printf(ANSI_COLOR_MAGENTA   "%c"   ANSI_COLOR_RESET , buffer );
    }
    fclose(fp);
}
