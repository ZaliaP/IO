public interface IKontrolerKlienta {

	public boolean kupnoBiletuKlient();

	public String[] przegladRepertuaru();

	public boolean rejestracjaKontaUzytkownika();

	public boolean zarzadzanieKontemUzytkownika();

	public boolean zalogowanieSieNaKontoUzytkownika();

	public boolean zwrotBiletu();

	public boolean dodajBiletDoKoszyka();

	public String[] filtrujFilmy();
}