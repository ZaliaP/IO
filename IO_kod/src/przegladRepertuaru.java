public class przegladRepertuaru {
	private int _kinoID;
	private IModelKina _model;

	public String[] przeglapertuaru() {
		//Przykładowe filmy
		String[] filmy = pobierzFilmy();;
		return filmy;
	}

	private String[] pobierzFilmy() {
        return new String[]{"Skazani na Shawshank", "Zielona mila", "Nietykalni", "Ojiec chrzestny", "Dwunastu gniewnych ludzi"};
	}
}