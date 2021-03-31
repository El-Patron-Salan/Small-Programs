#include <stdio.h>
#include <stdlib.h>

#define MAX_FNAME_LENGTH 16
#define MAX_SNAME_LENGTH 32
/*
 *This is simpler approach for making this program
 */
char* inputFirstName();
char* inputSurname();

int main(int argC, char* argV[]) {
    

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
    printf( "%s: ", "Surname: ");
    fgets( sName, MAX_SNAME_LENGTH, stdin );
    return sName;
}

