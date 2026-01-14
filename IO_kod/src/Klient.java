public class Klient extends Uzytkownik {
	private String _haslo;
	private String _login;

	public Klient(String aEmail, String aImie, String aNazwisko, int aUzytkownikID) {
		super(aEmail, aImie, aNazwisko, aUzytkownikID);
	}
}