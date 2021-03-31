#include <stdio.h>

#define MAX_NAME_LENGTH 16
/*
 *This is simpler approach for making this program
 */

int main(int argC, char* argV[]) {
    

    return 0;
}

char* inputName() {
    
    char* name = malloc( sizeof(name) );
    printf( "%s: ", "Name" );
    fgets( name, MAX_NAME_LENGTH, stdin );
    return name;
}
