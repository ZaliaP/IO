public class filtrujFilmy {
	private IModelKina model = new Model();

	public void filtrujFilmy(int filmID, String data){
		if (filmID < 0 || data == null || data.isEmpty()){
			throw new IllegalArgumentException("FilmID and Data cannot be empty");
		}
		String[] filtrowaneFilmy;

				filtrowaneFilmy = model.filtrujFilmy(filmID, data);

		this.model.zarejestrowanieZdarzenia("Przefiltrowano filmy.");
	}
}