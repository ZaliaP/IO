import java.util.Vector;

public class Rezerwacja {
	private int _seansID;
	private int _rezerwacjaID;
	private String[] _numeryMiejsc;
	private double _kwotaRezerwacji;
	private Data _dataWygasniecia;
	private Data _dataUtworzenia;
	private Seans _seans;
	public Uzytkownik _unnamed_Uzytkownik_;
	public Koszyk _unnamed_Koszyk_;
	public Vector<Bilet> _unnamed_Bilet_ = new Vector<Bilet>();

	public Rezerwacja(Data aDataUtworzenia, Data aDataWygasniecia, double aKwotaRezerwacji, String[] aNumeryMiejsc, int aRezerwacjaID, int aSeansID) {
		throw new UnsupportedOperationException();
	}
}