package bibliotheek.items;

/**
 * Representeert een boek in de bibliotheek.
 */
public class Boek {
	public String titel;
	public String auteur;
	public int paginas;
	public int huidigePagina;
	/**
	 * Constructor om een nieuw Boek-object aan te maken.
	 *
	 * @param titel   De titel van het boek.
	 * @param auteur  De auteur van het boek.
	 */
	public Boek(String title, String author) {
		this.titel = title;
		this.auteur = author;
	}
	/**
	 * Houdt bij hoeveel pagina's er zijn gelezen in een leessessie en print hoeveel pagina's er nog over zijn naar de console.
	 *
	 * @param huidigePagina De startpagina van de leessessie.
	 * @param gelezenPaginas Het aantal gelezen pagina's in die sessie.
	 * @return De huidige pagina na de leessessie (startpagina + gelezen pagina's).
	 */
	public int lezen(int huidigePagina, int gelezenPaginas){
		System.out.printf("%d pagina's gelezen. %d pagina's te gaan.\n", gelezenPaginas, (paginas - huidigePagina - gelezenPaginas));
		int nieuweHuidigePagina = huidigePagina + gelezenPaginas;
		return nieuweHuidigePagina;
	}
}
