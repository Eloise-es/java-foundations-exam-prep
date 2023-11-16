package bibliotheek;
import bibliotheek.mensen.*;
import bibliotheek.items.*;

/**
 * Representeert een bibliotheek met leen- en aankoopfunctionaliteiten.
 */
public class Bibliotheek {
	/**
	 * Leent een boek uit aan een lid en actualiseert de uitgeleende boeken van het lid.
	 *
	 * @param boek Het boek dat wordt uitgeleend.
	 * @param lid  Het lid dat het boek leent.
	 */
	void lenen(Boek boek, Lid lid) {
		lid.pas.momenteelUitgeleend += 1;
		System.out.println(boek.titel + " geleend door " + lid.naam);
		System.out.printf("Momenteel %d boeken uitgeleend door %s.\n", lid.pas.momenteelUitgeleend, lid.naam);
	}

	/**
	 * Koopt een nieuw boek en stelt de kenmerken ervan in.
	 *
	 * @param titel De titel van het boek.
	 * @param auteur De naam van de auteur van het boek.
	 * @param paginas Het aantal pagina's van het boek.
	 * @return Het nieuw aangekochte boek.
	 */
	Boek boekKopen(String titel, String auteur, int paginas) {
		Boek nieuwBoek = new Boek(titel, auteur);
		nieuwBoek.paginas = paginas;
		return nieuwBoek;
	}
}
