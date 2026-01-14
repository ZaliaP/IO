public class Bilet extends Dokument implements IBiletCena {
	private String _numerMiejsca;
	private String _kodQR;
	private Rezerwacja _rezerwacja;
	private Seans _seans;

	public double cena() {
		throw new UnsupportedOperationException();
	}

	public String opisz() {
		throw new UnsupportedOperationException();
	}

	public Bilet(int aDokumentID, double aCena, String aKodQR, String aNumerMiejsca, Rezerwacja aRezerwacja) {
        super(aDokumentID, aCena);

    }
}