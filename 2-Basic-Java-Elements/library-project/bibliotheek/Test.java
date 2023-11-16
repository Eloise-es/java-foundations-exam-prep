package bibliotheek;

import bibliotheek.mensen.*;
import bibliotheek.items.*;

/**
 * De hoofdklasse die de functionaliteit van de bibliotheek demonstreert.
 */
public class Test {
	/**
	 * Het hoofdprogramma dat de bibliotheekfunctionaliteiten aanroept en demonstreert.
	 *
	 * @param args De array met invoerargumenten.
	 */
	public static void main(String[] args) {
		
		Boek b1 = new Boek("Sonny Boy", "Annejet van der Zijl");
		b1.paginas = 220;
		int huidigePagina = b1.lezen(35, 20);
		b1.huidigePagina = huidigePagina;
		System.out.printf("Jij bent nu op pagina %d.\n", huidigePagina); 
		
		System.out.println("--------");
		Bibliotheek bieb = new Bibliotheek();
		
		Lid l1 = new Lid("Elise", 1995);
		l1.naam = "Eloise";
		
		bieb.lenen(b1, l1);
		
		System.out.println("--------");
		Boek b2 = bieb.boekKopen("Het Diner", "Herman Koch", 300);
		System.out.println("Nieuw boek gekocht: " + b2.titel);
		
		
		System.out.println("--------");
		Personeel manager = new Personeel();
		manager.naam = "Inge";
		manager.functie = "manager";
		System.out.printf("%s is een %s.\n", manager.naam, manager.functie);
		
		System.out.println("--------");
		bieb.lenen(b2, l1);
		
	}
}
