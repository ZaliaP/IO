public class zarzadzanieKontemUzytkownika {
	private int _uzytkownikID;
	private IModelKina model = new Model();

	public void zarzadzanieKontemUzytkownika(int opcja, String uzytkownikID, String[] noweDane) {
		if(opcja == 1){
			System.out.println("Wybrano opcje edycji danych");

			this.edytujDane();
			model.aktualizujDaneUzytkownika(uzytkownikID, noweDane);

			System.out.println("Zaktualizowano dane");
		}
		else if(opcja == 2){
			System.out.println("Wybrano opcje pokazania historii rezerwacji");


			String[] historiaUzytkownika = this.wyswietlHistorie();
			String[] historia = model.pobierzHistorieRezerwacji(uzytkownikID);

			System.out.println("Pobrano Historie");
		}

		this.zakonczZarzadzanie();
		this.model.zarejestrowanieZdarzenia("Zakonczono zarzadzanie kontem.");
	}

	public void edytujDane() {
		System.out.println("Nastąpiła zmiana danych");
	}

	public String[] wyswietlHistorie() {
		throw new UnsupportedOperationException();
	}

	public void zakonczZarzadzanie() {
		;System.out.println("Zakoncz zarzadzanie");
	}
}