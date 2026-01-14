import java.util.List;

public class kupnoBiletuKlient extends SzablonKupnaBiletu {

	private int seansID;
	private IModelKina model;
	private int uzytkownikID = 7;
	private int rezerwacjaID = uzytkownikID*1000 + 1;
	private int cena;


	public java.util.List<Dokument> kupnoBiletu(IModelKina model, int seansID){
		this.seansID = seansID;
		this.model = model;

			String[] miejsce = this.wyborMiejsca();

			boolean dostepnosc = this.model.sprawdzDostepnoscMiejsca(this.seansID, miejsce);
			boolean weryfikacjaMiejsca = this.weryfikujWybraneMiejsce(miejsce);

			if(weryfikacjaMiejsca) {
					boolean rezerwacja = this.model.zapiszRezerwacje(miejsce, this.rezerwacjaID, this.seansID);

					this.model.aktualizujMiejscaNaSali(this.seansID, miejsce);

					boolean platnosc = this.dokonajPlatnosc(this.rezerwacjaID, this.uzytkownikID);

					List<Dokument> dokumenty = this.model.finalizujZakup(miejsce, this.seansID, this.cena);
					this.wyslijPotwierdzenie(this.rezerwacjaID);
					this.model.zarejestrowanieZdarzenia("Zakup zakonczony dla rezerwacji: " + this.rezerwacjaID);
					return dokumenty;
			}
			return null;
    }

	private String[] wyborMiejsca(){
        return new String[]{"10A"};
    }

	protected void aktualizujMiejscaNaSali(String aMiejscaID) {
		throw new UnsupportedOperationException();
	}

	protected boolean dokonajPlatnosc(int aRezerwacjaID, int aUzytkownikID) {
		return true;
	}

	protected boolean weryfikujWybraneMiejsce(String[] aMiejscaID) {
		return true;
	}

	protected void wyslijPotwierdzenie(int aRezerwacjaID) {
		System.out.println("Rezerwacja udana. ID rezerwacji: " + this.rezerwacjaID);
	}
}