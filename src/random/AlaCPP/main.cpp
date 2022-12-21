#include <iostream>
#include <bits/stdc++.h>

// nie trzeba używać std::
using namespace std;

// funkcja do generowania liczb losowych
// !! będziesz potrzebować kompilatora w najnowszej wersji
// int random_dev(){
//     // utwórz generator liczb losowych
// 	random_device rd;
//     // generator Mersenna 64bit
// 	mt19937_64 mt(rd());
//     // określ zakres
// 	uniform_real<int> dist(1, 300);
//     // zwróć wartość funkcji
// 	return dist(mt);
// }

// drugi mniej zaawansowany sposób generowania liczb 1-300
int random_numb(){
    // na początku "1 +"" oznacza, że zakres startuje od 1, a znak "%" oznacza jaka wartość jest ostatnia w zakresie 
    return 1 + (rand() % 300);
}

// proste sortowanie bąbelkowe
void sort_asc(int arr[], int n){
    int i, j, temp;

    for(i=0; i<n; i++){
        // wewnętrzną pętla j dla sortowania bąbelkowego od 0 do N-1-i
        for(j=0; j<n-i; j++){
            // teraz sprawdza czy wartość w arr[j] jest większa od wartości w arr[j+1]
            if(arr[j] > arr[j+1]){
                // jeśli wartość jest większa to zamień liczby
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}

void sort_desc(int arr[], int n){
    int i, j, temp;

    for(i=0; i<n; i++){
        for(j=0; j<n-i; j++){
            // to samo co w poprzedniej funkcji, tyle że tutaj sprawdzany jest warunek mniejszości
            if(arr[j] < arr[j+1]){
                // jeśli jest mniejsza to zamień
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}

// funkcja do wyświetlenia tablicy
void printArray(int arr[], int size){
    for(int i = 0; i < size; i++) 
        cout <<" "<< arr[i];
}

int main(){
    // stała zmienna o wartości 100
    const int size = 100;
    int option;
    
    //inicjalizacja tablicy jednowymiarowej
    int arr[size];

    //wypełnij tablice wartościami 1-300
    for (int i = 0; i<=size; ++i) 
        arr[i] = random_numb();
    // lub
    //for (int i = 0; i<=size; ++i) arr[i] = random_dev();
    
    // zapytaj użytkownika jak sortować tablice
    cout << "Tablica nieposortowana: ";

    // pokaż nieposortowaną tablicę
    printArray(arr, size);
    
    cout << endl << endl << "Wybierz sposób w jaki chcesz posortować tablice:" << endl
    << "1. Sortowanie rosnące" << endl << "2. Sortowanie malejące" << endl << "Wybierz opcje: ";
    
    // tutaj user wpisuje opcję
    cin >> option;
    
    // switch-case, bo if'y są bleh
    switch(option){
        case 1:
            sort_asc(arr, size);
            printArray(arr, size);
            break;
        case 2:
            sort_asc(arr, size);
            printArray(arr, size);
            break;
        default:
            cout << "Wybrana opcja nie istnieje" << endl;
            break;
    }

    return 0;
}
