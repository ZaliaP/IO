import java.util.List;

public interface IModelKina {

	public void zarejestrowanieZdarzenia(String aZdarzenie);

	public boolean sprawdzDostepnoscMiejsca(int aSeansID, String[] aNumerMiejsca);

	public boolean zapiszRezerwacje(String[] aNumerMiejsc, int aRezerwacjaID, int aSeansID);

	public void aktualizujDaneUzytkownika(String aUzytkownikID, String[] aNoweDane);

	public String[] pobierzHistorieRezerwacji(String aUzytkownikID);

	public String zarejestrujUzytkownika(String aEmail, String aImie, String aNazwisko);

	public String[] pobierzRepertuar(int kinoID, String data);

	public String[] filtrujSeanse(int aFilmID, String aData);

	public boolean zapiszBiletDoKoszyka(String uzytkownikID, int filmID, int kinoID, String data, String numerMiejsca);

	String[] filtrujFilmy(int filmID, String data);

	public List<Dokument> finalizujZakup(String[] numeryMiejsc, int seansID, int cena);

	void aktualizujMiejscaNaSali(int seansID, String[] miejsca);
}