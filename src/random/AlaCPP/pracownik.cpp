#include <iostream>
#include <string>

using namespace std;

class Pracownik {
private:
    string imie, nazwisko, ulica, kod_pocztowy, miejscowosc, nr_domu;
public:
    void wczytaj_dane() {
        cout << "Podaj imie: ";
        getline(cin, imie);
        cout << "Podaj nazwisko: ";
        getline(cin, nazwisko);
        cout << "Podaj ulice: ";
        getline(cin, ulica);
        cout << "Podaj numer domu: ";
        cin >> nr_domu;
        cout << "Podaj kod pocztowy: ";
        cin >> kod_pocztowy;
        cin.ignore(); // ignorujemy znak nowej linii pozostawiony w buforze po wczytaniu nr domu
        cout << "Podaj miejscowosc: ";
        getline(cin, miejscowosc);
    }

    void wizytowka() {
        cout << "-----------------------" << endl;
        cout << "   " << imie << " " << nazwisko << endl;
        cout << "   ul. " << ulica << " " << nr_domu << endl;
        cout << "   " << kod_pocztowy << " " << miejscowosc << endl;
        cout << "-----------------------" << endl;
    }
};

int main() {
    Pracownik p;
    p.wczytaj_dane();
    p.wizytowka();
    return 0;
}