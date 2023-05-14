#include <iostream>
#include <ctime>
#include <iomanip>

using namespace std;

class Rachunek {
private:
    // data systemowa
    time_t data;
    // double, poniewaz dane moga byc zmienno przecinkowe
    double wartosc_netto, podatek, wartosc_brutto;
public:
    void wczytaj_dane() {
        time(&data);
        cout << "Podaj wartosc netto: ";
        cin >> wartosc_netto;
    }

    void oblicz_wartosci() {
        podatek = wartosc_netto * 0.23;
        wartosc_brutto = wartosc_netto + podatek;
    }

    void wypisz_rachunek() {
        cout << "Data: " << put_time(localtime(&data), "%F %T") << endl;
        cout << fixed << setprecision(2);
        cout << "Wartość netto: " << wartosc_netto << " zł" << endl;
        cout << "Podatek (23%): " << podatek << " zł" << endl;
        cout << "Wartość brutto: " << wartosc_brutto << " zł" << endl;
    }
};

int main() {
    Rachunek r;
    r.wczytaj_dane();
    r.oblicz_wartosci();
    r.wypisz_rachunek();
    return 0;
}