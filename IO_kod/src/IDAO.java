public interface IDAO {

	public int dodajBilet(Bilet aBilet);

	public int dodajKoszyk(String aKoszyk);

	public int dodajRezerwacje(String aRezerwacja);

	public int dodajUzytkownika(String aUzytkownik);

	public void edytujBilet(String aBilet);

	public void edytujKoszyk(String aKoszyk);

	public void edytujRezerwacje(String aRezerwacja);

	public void edytujUzytkownika(String uzytkownikID, String[] aUzytkownik);

	public String[] znajdzRezerwacjeUzytkownika(String aUzytkownikID);

	public void usunBilet(String aBilet);

	public void usunKoszyk(String aKoszyk);

	public void usunRezerwacje(String aRezerwacja);

	public void usunUzytkownika(int aUzytkownikID);

	public String znajdzBilet(String aKodQR);

	public String znajdzKoszyk(int aKoszykID);

	public String znajdzRezerwacje(int aRezerwacjaID);

	public String znajdzUzytkownika(String aLogin);

	void dodajWpisDoRejestruZdarzen(String zdarzenie);
}