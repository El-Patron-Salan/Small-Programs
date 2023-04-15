#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;

struct UserData {
    string login;
    string password;
};

void registerUser() {
    UserData user;
    cout << "Podaj login: ";
    cin >> user.login;
    cout << "Podaj haslo: ";
    cin >> user.password;

    // Otwieramy plik z danymi do logowania w trybie do dopisywania (ofstream) oraz odczytywania (ifstream)
    ofstream file("login.txt", ios::app);
    ifstream readfile("login.txt");

    if (!file) {
        cout << "Nie udalo sie otworzyc pliku." << endl;
        return;
    }

    // Sprawdzamy, czy plik jest pusty
    file.seekp(0, ios::end);
    if (file.tellp() == 0) {
        // Jeśli plik jest pusty, zapisujemy do niego pierwszy rekord
        file << user.login << " " << user.password << endl;
        cout << "Konto zostalo utworzone." << endl;
    } else {
        // W przeciwnym wypadku sprawdzamy, czy podany login już istnieje
        file.seekp(0, ios::beg);
        string login, password;
        while (readfile >> login >> password) {
            if (login == user.login) {
                cout << "Podany login juz istnieje. Sprobuj ponownie." << endl;
                return;
            }
        }
        // Jeśli podany login nie istnieje, zapisujemy nowy rekord
        file.clear();
        file << user.login << " " << user.password << endl;
        cout << "Konto zostalo utworzone." << endl;
    }
    file.close();
}

// odczytaj dane z pliku login.txt i przypisz do struktury
UserData readUserDataFromFile() {
    ifstream file("login.txt");
    UserData userData;
    file >> userData.login >> userData.password;
    file.close();
    return userData;
}

// sprawdz czy login i haslo sa poprawne
bool checkLoginAndPassword(string login, string password) {
    UserData userData = readUserDataFromFile();
    return (login == userData.login && password == userData.password);
}

// wylosuj 500 liczb i zapisz do pliku
void generateAndSaveRandomNumbers() {
    ofstream file("liczby_wylosowane.txt");
    srand(time(NULL));
    for (int i = 0; i < 500; i++) {
        int randomNumber = rand();
        file << randomNumber << endl;
    }
    file.close();
}

// posortuj wylosowane liczby
void sortRandomNumbersAndSaveToFile() {
    ifstream inputFile("liczby_wylosowane.txt");
    ofstream outputFile("posortowane_liczby.txt");
    int numbers[500];
    int i = 0;
    while (inputFile >> numbers[i]) {
        i++;
    }
    sort(numbers, numbers + i);
    for (int j = 0; j < i; j++) {
        outputFile << numbers[j] << endl;
    }
    inputFile.close();
    outputFile.close();
}

// po zalogowaniu
void loginUser(){
    string login, password;

    cout << "Podaj login: ";
    cin >> login;
    cout << "Podaj hasło: ";
    cin >> password;
    if (checkLoginAndPassword(login, password)) {
        cout << "Logowanie pomyślne." << endl;
        cout << "Co chcesz zrobić?" << endl;

        do{
            cout << "1. Wylosuj 500 liczb i zapisz je do pliku liczby_wylosowane.txt" << endl;
            cout << "2. Posortuj wylosowane liczby i zapisz wynik do pliku posortowane_liczby.txt" << endl;
            cout << "3. Wyjdz" << endl;

            int choice;
            cin >> choice;
            switch (choice) {
                case 1:
                    generateAndSaveRandomNumbers();
                    cout << "Wylosowane liczby zapisano do pliku liczby_wylosowane.txt." << endl;
                    break;
                case 2:
                    sortRandomNumbersAndSaveToFile();
                    cout << "Wylosowane liczby posortowano i zapisano do pliku posortowane_liczby.txt." << endl;
                    break;
                case 3:
                    exit(0);
                default:
                    cout << "Niepoprawny wybór." << endl;
                    break;
            }
        }while(true);
    } else {
        cout << "Niepoprawny login lub hasło." << endl;
    }
}

int main() {
    int choice;
    do {
        cout << "1. Zarejestruj sie" << endl;
        cout << "2. Zaloguj sie" << endl;
        cout << "3. Wyjdz" << endl;
        cout << "Wybierz opcje: ";
        cin >> choice;
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                cout << "Do zobaczenia!" << endl;
                return 0;
            default:
                cout << "Niepoprawny wybor, sprobuj ponownie." << endl;
                break;
        }
    } while (true);

    return 0;
}
