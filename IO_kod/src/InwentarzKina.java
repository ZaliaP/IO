import java.util.Map;

public class InwentarzKina {
	private IDAO dao;
	private Uzytkownik[] uzytkownicy = null;
	private Film[] filmy = null;

	public void anulujRezerwacje(int aRezerwacjaID) {
		throw new UnsupportedOperationException();
	}

	public void dodajDoKoszyka(String uzytkownikID, int filmID, int kinoID, String data, String numerMiejsca){

	}

	public void finalizujZakup(int aKoszykID) {
		throw new UnsupportedOperationException();
	}

	public void edytujDaneUzytkownika(int aUzytkownikID, Uzytkownik aNoweDane) {
		throw new UnsupportedOperationException();
	}

	public Seans[] dajRepertuar(String aData) {
        return new Seans[0];
    }

	public Rezerwacja[] dajRezerwacje(int aUzytkownikID) {
		throw new UnsupportedOperationException();
	}

	public Map<String, StatusMiejsca> dajStatusMiejsc(int aSeansID) {
        return Map.of();
    }

	public void rezerwujMiejsca(int aKlientID, int aSeansID, Object aNumeryMiejsc) {
		throw new UnsupportedOperationException();
	}

	public void usunUzytkownika(int aUzytkownikID) {
		throw new UnsupportedOperationException();
	}

	public String zalogujUzytkownika(String aLogin, String aHaslo) {
		throw new UnsupportedOperationException();
	}

	public void zarejestrujZdarzenie(String aZdarzenie) {
		throw new UnsupportedOperationException();
	}

	public Uzytkownik zarejestrujUzytkownika(Object aLogin, Object aHaslo) {
		throw new UnsupportedOperationException();
	}

	public void zwrocBilet(Object aKodQR) {
		throw new UnsupportedOperationException();
	}
}