public class dodajBiletDoKoszyka {
	private IModelKina model = new Model();

	public void dodajBiletDoKoszyka(String uzytkownikID, int filmID, int kinoID, String data, String numerMiejsca) {
		boolean sukces = this.model.zapiszBiletDoKoszyka(uzytkownikID, filmID, kinoID, data, numerMiejsca);
		if ( sukces ) {
			this . model . zarejestrowanieZdarzenia ( " Dodano bilet do koszyka. " ) ;
		}
		else {}
	}
}