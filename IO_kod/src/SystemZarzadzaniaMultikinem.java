import java.util.Scanner;

public class SystemZarzadzaniaMultikinem {
	private static IModelKina modelKina;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IModelKina modelKina = new Model();
		int kinoID = 305;

		System.out.println("Zaloguj się. Wpisz 1 dla klienta albo 2 dla kasjera");
		int login = scanner.nextInt();

		if (login == 1) {
			kupnoBiletuKlient klinet = new kupnoBiletuKlient();
			zarzadzanieKontemUzytkownika konto = new zarzadzanieKontemUzytkownika(modelKina);
			przegladRepertuaru repertuar = new przegladRepertuaru();
			filtrujFilmy filtruj = new filtrujFilmy();
			dodajBiletDoKoszyka koszyk = new dodajBiletDoKoszyka();

			//dane potrzebne do uruchomienia kodu dla klienta
			int seansID = 108;
			int opcja = 1; //wybrane zmienienie danych użytkownika
			String uzytkownikID = "502";
			String[] noweDane = {"Ula", "Kowalska"};
			String data = "20.01.2026";
			String miejsce = "10A";

			//symulacja kupna biletu oraz dodania biletu do koszyka
			System.out.println("Wybrano film o id 108");
			System.out.println("Wybrane miejsce ma numer 10A");
			klinet.kupnoBiletu(modelKina, seansID);
			koszyk.dodajBiletDoKoszyka(uzytkownikID, seansID, kinoID, data, miejsce);

			//symulacja zarządzania kontem
			System.out.println("\nWybrano zarządzanie kontem użytkownika");
			konto.zarzadzanieKontemUzytkownika(opcja, uzytkownikID, noweDane);

			//symulacja przeglądu repertuaru oraz filtrowania filmów
			System.out.println("\nDostępny repertuar:");
			String[] filmy = repertuar.przeglapertuaru();
            for (String s : filmy) {
                System.out.println(s);
            }
			System.out.println("Filtrowanie po wybranej dacie "+ data);
			filtruj.filtrujFilmy(seansID, data);
		}
		else if (login == 2) {
			kupnoBiletuKasjer kasjer = new kupnoBiletuKasjer();
			System.out.println("Wybrano film o id 109");
			int seansID = 109;
			kasjer.kupnoBiletu(modelKina, seansID);
		}
		else{
			System.out.println("Niepoprawny wybór");
		}

	}
}