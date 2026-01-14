public class DAO implements IDAO {

	public int dodajBilet(String aBilet) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int dodajBilet(Bilet aBilet) {
		return 0;
	}

	public int dodajKoszyk(String aKoszyk) {
		throw new UnsupportedOperationException();
	}

	public int dodajRezerwacje(String aRezerwacja) {
		throw new UnsupportedOperationException();
	}

	public String znajdzUzytkownika(String aLogin) {
		throw new UnsupportedOperationException();
	}

	public void edytujUzytkownika(String aUzytkownik) {
		throw new UnsupportedOperationException();
	}

	public void usunUzytkownika(int aUzytkownikID) {
		throw new UnsupportedOperationException();
	}

	public String znajdzRezerwacje(int aRezerwacjaID) {
		throw new UnsupportedOperationException();
	}

	public int dodajUzytkownika(String aUzytkownik) {
		throw new UnsupportedOperationException();
	}

	public String[] znajdzRezerwacjeUzytkownika(String aUzytkownikID) {
		throw new UnsupportedOperationException();
	}

	public void edytujBilet(String aBilet) {
		throw new UnsupportedOperationException();
	}

	public void edytujKoszyk(String aKoszyk) {
		throw new UnsupportedOperationException();
	}

	public void edytujRezerwacje(String aRezerwacja) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void edytujUzytkownika(String uzytkownikID, String[] aUzytkownik) {

	}

	public void usunBilet(String aBilet) {
		throw new UnsupportedOperationException();
	}

	public void usunKoszyk(String aKoszyk) {
		throw new UnsupportedOperationException();
	}

	public void usunRezerwacje(String aRezerwacja) {
		throw new UnsupportedOperationException();
	}

	public String znajdzBilet(String aKodQR) {
		throw new UnsupportedOperationException();
	}

	public String znajdzKoszyk(int aKoszykID) {
		throw new UnsupportedOperationException();
	}

	public DAO() {

	}

	public void dodajWpisDoRejestruZdarzen(String aZdarzenie) {
		System.out.println("Dodano zdarzenie "+aZdarzenie);
	}
}