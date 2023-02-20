#include <iostream>
#include <cstdlib>
#include <ctime>
#include <algorithm>

// nie trzeba używać std::
using namespace std;

// generowanie liczb losowych
int randNum() {
    return rand() % 251 + 50;
}

// wyświetla zawartość tablicy
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// znajduje najczęściej występującą liczbę w tablicy
int mostFrequentNumber(int arr[], int size) {
    int maxCount = 0;
    int maxNum = 0;
    for (int i = 0; i < size; i++) {
        int count = 0;
        for (int j = i; j < size; j++) {
            if (arr[i] == arr[j]) {
                count++;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            maxNum = arr[i];
        }
    }
    return maxNum;
}

// sortuje tablice
void sortArray(int arr[], int size) {
    // jak coś to jest funkcja z biblioteki <algorithm>
    sort(arr, arr + size);
}


int main() {
    // potrzebne dla generatora liczb losowych!
    srand(time(NULL));

    // określamy rozmiar tablicy, czyli 1000 liczb
    const int SIZE = 1000;
    int numbers[SIZE];

    // dodajemy losowe liczby do tablicy
    for (int i = 0; i < SIZE; i++) {
        numbers[i] = randNum();
    }
    
    cout << "Tablica nieposortowana:" << endl;
    printArray(numbers, SIZE);

    int mostFreqNubmer = mostFrequentNumber(numbers, SIZE);
    cout << endl << "Najczesciej wystepujaca liczba: " << mostFreqNubmer << endl << endl;

    // sortowanie tablicy i ją wypisujemy (operujemy na jednej tablicy jak coś)
    sortArray(numbers, SIZE);
    printArray(numbers, SIZE);

    return 0;
}
