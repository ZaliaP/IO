import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model implements IModelKina{
	IDAO dao = new DAO();
	private Seans seans;
	//private InwentarzKina inwentarzKina;
	private Repertuar repertuar;
	//private FabrykaBiletu fabrykaBiletu;
	FabrykaPotwierdzenia fabrykaPotwierdzenia = new FabrykaPotwierdzenia();
	InwentarzKina inwentarzKina = new InwentarzKina();
	FabrykaBiletu fabrykaBiletu = new FabrykaBiletu();

	int czasTrwania = 90;
	Data dataWystawienia = null;
	Kino miejsceWystawienia = null;
	int seansID = 10;
	int numerSali = 19;
	Map<String, StatusMiejsca> statusMiejsc = Map.of();

	public String[] filtrujSeanse(int filmID, String data){
		String[] seanse;
		seanse = this.seans.Seans(czasTrwania, dataWystawienia, miejsceWystawienia, numerSali, seansID, statusMiejsc);
        return seanse;
	}

	@Override
	public boolean zapiszBiletDoKoszyka(String uzytkownikID, int filmID, int kinoID, String data, String numerMiejsca) {
		this.inwentarzKina.dodajDoKoszyka(uzytkownikID, filmID, kinoID, data, numerMiejsca);

		Map<String, StatusMiejsca> status = this.inwentarzKina.dajStatusMiejsc(filmID);

		StatusMiejsca statusMiejsca = status.get(numerMiejsca);

		if (statusMiejsca == StatusMiejsca.WOLNE) {
			return true;
		}

		return false;
	}

	@Override
	public String[] filtrujFilmy(int filmID, String data) {
		return new String[0];
	}

	public boolean sprawdzDostepnoscMiejsca(int seansID, String[] numerMiejsca) {
		Map<String, StatusMiejsca> statusyMiejsc = this.inwentarzKina.dajStatusMiejsc(seansID);

		StatusMiejsca statusMiejsca = statusyMiejsc.get(numerMiejsca);

		if (statusMiejsca != null && statusMiejsca == StatusMiejsca.WOLNE) {
			return true;
		}
		return false;
	}

	@Override
	public boolean zapiszRezerwacje(String[] aNumerMiejsc, int aRezerwacjaID, int aSeansID) {
		return false;
	}

	@Override
	public void aktualizujDaneUzytkownika(String uzytkownikID, String[] noweDane) {
		this.dao.edytujUzytkownika(uzytkownikID, noweDane);
	}

	@Override
	public String[] pobierzHistorieRezerwacji(String aUzytkownikID) {
        return dao.znajdzRezerwacjeUzytkownika(aUzytkownikID);
	}

	@Override
	public String zarejestrujUzytkownika(String aEmail, String aImie, String aNazwisko) {
		return "";
	}

	@Override
	public String[] pobierzRepertuar(int kinoID, String data) {
		Seans[] repertuar = this.inwentarzKina.dajRepertuar(data);
		String opis = this.repertuar.opisz();
		return new String[]{opis};
	}

	public void zarejestrowanieZdarzenia(String zdarzenie){
		this.dao.dodajWpisDoRejestruZdarzen(zdarzenie);
	}

	public List<Dokument> finalizujZakup(String[] numeryMiejsc, int seansID, int cena) {
		Dokument bilet = this.fabrykaBiletu.utworzDokument(numeryMiejsc, seansID, cena);
		Dokument potwierdzenie = this.fabrykaPotwierdzenia.utworzDokument(numeryMiejsc, seansID, cena);

		List<Dokument> listaDokumentow = new ArrayList<Dokument>();
		listaDokumentow.add(bilet);
		listaDokumentow.add(potwierdzenie);

		return listaDokumentow;
	}

	@Override
	public void aktualizujMiejscaNaSali(int seansID, String[] miejsca) {

	}
}