#include <stdio.h>
#include <stdlib.h>

#define MAX_FNAME_LENGTH 16
#define MAX_SNAME_LENGTH 32
#define MAX_PHONENUMBER_LENGTH 15
/*
 *This is simpler approach for making this program
 */
char* inputFirstName();
char* inputSurname();
size_t inputPhoneNumber();

int main(int argC, char* argV[]) {
    
    size_t x = inputPhoneNumber();
    printf( "\n%zu\n", x);
    return 0;
}

char* inputFirstName() {
    
    char* name = malloc( sizeof(name) );
    printf( "%s: ", "First name" );
    fgets( name, MAX_FNAME_LENGTH, stdin );
    return name;
}

char* inputSurname() {
        
    char* sName = malloc( sizeof(sName) );
    printf( "%s: ", "Surname");
    fgets( sName, MAX_SNAME_LENGTH, stdin );
    return sName;
}


//phone number functions
size_t inputPhoneNumber() {
    
    char* phoneNumber = malloc( sizeof(phoneNumber) );
    char* eptr;
    printf( "%s: ", "Phone number" );
    
    fgets( phoneNumber, MAX_PHONENUMBER_LENGTH, stdin );
    return strtol(phoneNumber, &eptr, 10);
}
