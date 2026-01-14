public class filtrujFilmy {
	private IModelKina model = new Model();

	public void filtrujFilmy(int filmID, String data){
		String[] filtrowaneFilmy;

				filtrowaneFilmy = model.filtrujFilmy(filmID, data);

		this.model.zarejestrowanieZdarzenia("Przefiltrowano filmy.");
	}
}