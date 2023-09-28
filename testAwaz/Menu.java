package testAwaz;

import java.util.Scanner;

import awaz.Awaz;
import awaz.AwazImage;
import java.util.Scanner;
import java.lang.Boolean;


public class Menu {
    public static void afficherMenu() {
        System.out.println("Bonjour, bienvenu sur le menu melodie, que voullez vous faire ?");
        System.out.println("1 - Ajouter une note");
        System.out.println("2 - Ajouter plusieurs note");
        System.out.println("3 - Transposer");
        System.out.println("4 - Afficher et jouer la melodie");
        System.out.println("5 - Sauvegarder");
        System.out.println("6 - Effacer");
        System.out.println("7 - Changer / Afficher le titre");
        System.out.println("8 - Recupere melodie format ABC");
        System.out.println("9 - Charger une melodie depuis un fichier");
        System.out.println("10 - Recupere melodie format DoReMi");
        System.out.println("11 - Recupere ieme note");
        System.out.println("Autre - Quitter");
    }
    public static void main(String[] args) {

        boolean start = true;
        Awaz melodie = new Awaz();

        while (start){
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        System.out.println("Vous avez choisi d'ajouter une note, la quelle ?");
                        String note = scanner.next();
                        melodie.add(note);
                        break;
                    case 2:
                        System.out.println("Vous avez choisi d'ajouter plusieurs notes, les quelles ecrivez la et appuyer sur entrée ? (stop pour arrêter)");
                        String note2 = scanner.next();
                        while (!note2.equals("stop")){
                            melodie.add(note2);
                            note2 = scanner.next();
                        }
                        break;
                    case 3:
                        System.out.println("Vous avez choisi de transposer, de combien de demi ton ?");
                        int nbDemiTon = scanner.nextInt();
                        melodie.transposer(nbDemiTon);
                        break;
                    case 4:
                        System.out.println("Vous avez choisi d'afficher et de jouer la melodie");
                        AwazImage display = new AwazImage();
                        display.setMelodie(melodie.toABC());
                        System.out.println("Ecrivez et appuyer sur entre pour quitter");
                        scanner.next();
                        display.fermer();
                        break;
                    case 5:
                        System.out.println("Vous avez choisi d'enregistrer la melodie dans un fichier");
                        System.out.println("Quel est le nom du fichier ?");
                        String nomFichier = scanner.next();
                        melodie.enregistrer(nomFichier);
                        break;
                    case 6:
                        System.out.println("Vous avez choisi d'effacer toutes les notes");
                        melodie.nouveau();
                        break;
                    case 7:
                        System.out.println("Le titre actuel est : " + melodie.getTitre() + " Voulez vous le changer ? (oui/non)");
                        String reponse = scanner.next();
                        if (reponse.equals("oui")){
                            System.out.println("Quel est le nouveau titre ?");
                            String titre = scanner.next();
                            melodie.setTitre(titre);
                        }
                        break;
                    case 8:
                        System.out.println("Vous avez choisi de recuperer la melodie au format ABC");
                        System.out.println(melodie.toABC());
                        break;
                    case 9:
                        System.out.println("Vous avez choisi de charger une melodie depuis un fichier quel est le nom du fichier ?");
                        String nomFichier2 = scanner.next();
                        melodie.ouvrir(nomFichier2);
                        break;
                    case 10:
                        System.out.println("Vous avez choisi de recuperer la melodie au format DoReMi");
                        System.out.println(melodie);
                        break;
                    case 11:
                        System.out.println("Vous avez choisi de recuperer la ieme note, laquelle ? (-1 pour la derniere)");
                        int i = scanner.nextInt();
                        if (i == -1)
                            System.out.println(melodie.getLast());
                        else
                            System.out.println(melodie.ieme(i));
                        break;
                    default:
                        System.out.println("C'est fini");
                        start = false;
                        break;
                }
            }

        }
}
