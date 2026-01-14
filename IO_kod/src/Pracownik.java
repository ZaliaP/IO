public class Pracownik extends Uzytkownik {
	private String _rola;
	private String _haslo;
	private String _login;

	public Pracownik(String aEmail, String aImie, String aNazwisko, int aUzytkownikID, String aHaslo, String aLogin, String aRola) {
		super(aEmail, aImie, aNazwisko, aUzytkownikID);
	}
}