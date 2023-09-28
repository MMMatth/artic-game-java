package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;

/**
 * Cette classe est le point de d�part du Tp Awaz
 * @author martine
 * @version Janvier 2018
 */
public class MainAwaz {
    public static void main(String[] args) {
        // Cr�ation d'une m�lodie vide
        Awaz melodie = new Awaz() ;
	melodie.add("Do");
	melodie.add("R�");
	melodie.add("Mi");
	melodie.add("Fa");
	melodie.add("Sol");
	System.out.println(melodie);
	melodie.transposer(2);
	melodie.nouveau();

	melodie.add("Do");
	melodie.add("R�");
	melodie.add("Mi");

	for (int i = 0; i < melodie.nbNotes(); i++) {
		System.out.print(melodie.ieme(i) + " ");
	}
	System.out.println();

	melodie.add("Do");
	melodie.add("R�");
	melodie.add("Mi");

	melodie.enregistrer("melodie.ABC");

	System.out.println(melodie.toABC());
	
	AwazImage display = new AwazImage();
	display.setMelodie(melodie.toABC());

    }
}
