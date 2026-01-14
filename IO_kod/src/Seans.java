import java.util.Map;
import java.util.Vector;

public class Seans {
	private int _seansID;
	private Data _dataWystawienia;
	private int _czasTrwania;
	private int _numerSali;
	private Map<String, StatusMiejsca> _statusMiejsc;
	private Kino _miejsceWystawienia;
	public Repertuar _unnamed_Repertuar_;
	private Vector<Film> _film = new Vector<Film>();
	private Vector<Rezerwacja> _unnamed_Rezerwacja_ = new Vector<Rezerwacja>();

	public String opisz() {
		throw new UnsupportedOperationException();
	}

	public String[] Seans(int aCzasTrwania, Data aDataWystawienia, Kino aMiejsceWystawienia, int aNumerSali, int aSeansID, Map<String, StatusMiejsca> aStatusMiejsc) {

        return new String[5];
    }
}