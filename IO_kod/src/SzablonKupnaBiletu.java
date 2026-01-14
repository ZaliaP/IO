public abstract class SzablonKupnaBiletu {
	private int _uzytkownikID;
	private int[] _miejscaID;
	private int _rezerwacjaID;
	private IModelKina _model;

	public boolean kupnoBiletu() {
		throw new UnsupportedOperationException();
	}

	protected abstract boolean weryfikujWybraneMiejsce(String[] aMiejscaID);

	protected abstract boolean dokonajPlatnosc(int aRezerwacjaID, int aUzytkownikID);

	protected void aktualizujMiejscaNaSali(String aMiejscaID) {
		throw new UnsupportedOperationException();
	}

	protected abstract void wyslijPotwierdzenie(int aRezerwacjaID);
}