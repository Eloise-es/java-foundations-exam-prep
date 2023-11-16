package bibliotheek.mensen;

/**
 * Representeert een lid van de bibliotheek.
 */
public class Lid {
	public String naam;
	int geboorteJaar;
	int leeftijd;
	public Pas pas;
	/**
	 * Constructor om een nieuw Lid-object aan te maken.
	 *
	 * @param naam			Naam van de nieuwe lid.
	 * @param geboorteJaar	Geboortejaar van de nieuwe lid.
	 */
	public Lid(String naam, int geboorteJaar) {
		this.naam = naam;
		this.geboorteJaar = geboorteJaar;
		this.pas = new Pas();
	}
	/**
	 * Constructor om een nieuw Lid-object aan te maken met geen argumenten.
	 */
	public Lid(){
		this.pas = new Pas();
	}
}
