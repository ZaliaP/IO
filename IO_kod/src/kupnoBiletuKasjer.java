import java.util.List;

public class kupnoBiletuKasjer extends SzablonKupnaBiletu {
	private IModelKina model;
	private int rezerwacjaID;
	private int uzytkownikID;
	int cena;
	private int seansID;

	public List<Dokument> kupnoBiletu(IModelKina model, int seansID) {
		this.seansID = seansID;
		this.model = model;

		Seans seans = this.pobierzDaneSeansu(seansID);

		String[] miejsce = this.wyborMiejsca();

		boolean dostepnosc = this.model.sprawdzDostepnoscMiejsca(seansID, miejsce);
		boolean weryfikacjaMiejsca = this.weryfikujWybraneMiejsce(miejsce);

		if(weryfikacjaMiejsca) {
			boolean rezerwacja = this.zapiszRezerwacje(miejsce, seansID);

			boolean platnosc = this.dokonajPlatnosc(this.rezerwacjaID, this.uzytkownikID);

			this.model.aktualizujMiejscaNaSali(seansID, miejsce);

			List<Dokument> dokumenty = this.model.finalizujZakup(miejsce, seansID, cena);

			this.wyslijPotwierdzenie(this.rezerwacjaID);
			this.model.zarejestrowanieZdarzenia("Zakup zakonczony dla rezerwacji: " + this.rezerwacjaID);
			return dokumenty;
		}
		return null;
	}


	private boolean zapiszRezerwacje(String[] miejsca, int seansID) {
        return true;
    }

	private String[] wyborMiejsca() {
		String[] miejsce = {"01B"};
        return miejsce;
    }

	private Seans pobierzDaneSeansu(int seansID) {
        return null;
    }

	protected void aktualizujMiejscaNaSali(int seansID, String[] aMiejscaID) {
	}

	protected boolean dokonajPlatnosc(int aRezerwacjaID, int aUzytkownikID) {
        return true;
    }

	protected boolean weryfikujWybraneMiejsce(String[] aMiejscaID) {
        return true;
    }

	protected void wyslijPotwierdzenie(int aRezerwacjaID) {
		System.out.println("Wysłano potwierdzenie o rezerwacji numer: " + aRezerwacjaID);
	}
}