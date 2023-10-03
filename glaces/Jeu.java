package glaces;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;


public class Jeu {
    private ArcticImage image;
    private Ocean ocean;
    private Pingouin pingouin;
    private ArrayList<Poisson> poissons;

    /** 
     * Constructeur
     */
    public Jeu() {
        ocean = new Ocean();
        pingouin = new Pingouin(30, 30, 14, 28); // on met le pingouin au milieu
        image = new ArcticImage(ocean.getWidth(), ocean.getHeight()); // on cree l'image
        poissons = InitPoissons(); // on cree les poissons
        image.setColors(creeCarte(ocean.getWidth(), ocean.getHeight(), ocean, pingouin, poissons)); // on met les couleurs
    }

    /**
     * Initialise les poissons
     * @return liste des poissons
     */
    public ArrayList<Poisson> InitPoissons(){
        poissons = new ArrayList<Poisson>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            random = new Random();
            poissons.add(new Poisson(5, 10, random.nextInt(2), // direction = 0 ou 1
            random.nextInt(2) + 4, // couleur = entre 4 et 5
            random.nextInt(3) + 1, // nombre aller retoure avant de mourir = entre 1 et 3
            random.nextInt(ocean.getWidth() - 5),
            random.nextInt(ocean.getHeight() - 10),
            14));
        }
        updatePoisson(); // on met les poissons a leur place
        return poissons;
    }

    /**
     * Deplace le pingouin en fonction de l'input de l'utilisateur
     * @param scanner scanner pour recuperer l'input
     */
    public void updatePingouin(Scanner scanner) {
        
        for (Iceberg2D iceberg : ocean.getIcebergs()) {
            if (pingouin.estSurIceberg(iceberg)){
                pingouin.estRepose();
                // on verifie si l'iceberg est assez grand pour supporter le pingouin
                if (iceberg.largeur() < pingouin.getTaille() * 2 || iceberg.hauteur()  < pingouin.getTaille() * 2)
                {
                    iceberg.fondre(1);
                    System.out.println("L'iceberg a casser sous le pingouin");
                }
            }
        }
        System.out.println("Deplacez le pingouin avec les touches zqsd (ou tapez une autre touche pour quitter) :");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("z")) 
        { // ingore case dans le cas de la maj
            deplacerPingouin(0, 1);
        } else if (input.equalsIgnoreCase("q")) 
        {
            deplacerPingouin(-1, 0);
        } else if (input.equalsIgnoreCase("s")) 
        {
            deplacerPingouin(0, -1);
        } else if (input.equalsIgnoreCase("d")) 
        {
            deplacerPingouin(1, 0);
        }
        if (pingouin.getFatigue() == 8)
            pingouin.estFatigue(); 
    }

    /**
     * Deplace les poissons et les supprime si ils sont morts
     */
    public void updatePoisson() {
        for (int i = 0; i < poissons.size(); i++) {
            Poisson poisson = poissons.get(i);
            poisson.deplacer();
            if (poisson.getDirection() == 1){                
                if (poisson.getX() + (poisson.getHauteur() + poisson.getVitesse()) >= ocean.getWidth()) 
                {
                    poisson.setX(0);
                    poisson.perdVie();
                }
                if (poisson.getX() < 0) 
                {
                    poisson.setX(ocean.getWidth() - poisson.getLargeur());
                    poisson.perdVie();
                }
            } else {
                if (poisson.getY() + (poisson.getHauteur() + poisson.getVitesse()) >= ocean.getHeight()) 
                {
                    poisson.setY(0);
                    poisson.perdVie();
                }
                if (poisson.getY() < 0) 
                {
                    poisson.setY(ocean.getHeight() - poisson.getHauteur());
                    poisson.perdVie();
                }
            }
            if (poisson.estMange(pingouin)) {
                for (Iceberg2D iceberg : ocean.getIcebergs()){
                    if (!poisson.estEnDessousIceBerg(iceberg)){
                        poisson.meurt();
                        pingouin.estRepose();
                    }
                }
            }
            if (poisson.estMort()) {
                poissons.remove(i);
                i--;
            }
        }
    }

    /**
     * Fait fondre un iceberg aleatoirement
     */
    public void updateIceBerg(){
        Random random = new Random();
        if (random.nextInt(20) == 0)
            ocean.fondreOcean(0.2);
    }

    /**
     * Boucle principale du jeu
     */
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        while (poissons.size() > 0) {
            updatePingouin(scanner);
            updateIceBerg();
            updatePoisson();
            if (poissons.size() > 0){
                image.setColors(creeCarte(ocean.getWidth(), ocean.getHeight(), ocean, pingouin, poissons));
            }
        }
        System.out.println("Vous avez gagne !");
        image.fermer();
    }

    /**
     * Deplace le pingouin de dx et dy (en gerant les limites de l'ocean)
     * @param dx
     * @param dy
     */
    private void deplacerPingouin(int dx, int dy) {
        int newX = pingouin.getX() + dx * pingouin.getVitesse();
        int newY = pingouin.getY() + dy * pingouin.getVitesse();
        
        if (newX >= 0 
        && newX < ocean.getWidth() - pingouin.getTaille() 
        && newY >= 0 
        && newY < ocean.getHeight() - pingouin.getTaille()) {
            pingouin.deplacer(dx, dy);
        }
    }

    /**
     * Cree la carte avec les couleurs des poissons, du pingouin et des icebergs
     * @param mapWidth
     * @param mapHeight
     * @param ocean
     * @param pingouin
     * @param poissons
     * @return
     */
    private int[][] creeCarte(int mapWidth, int mapHeight, Ocean ocean, Pingouin pingouin, ArrayList<Poisson> poissons) {
        int[][] carte = new int[mapWidth][mapHeight];
        ajouterPoissons(carte, poissons);
        ajouterIceberg(carte, ocean);
        ajouterPingouin(carte, pingouin);
        return carte;
    }

    /**
     * Ajoute les icebergs a la carte
     * @param carte tableau de couleurs
     * @param ocean ocean
     */
    private void ajouterIceberg(int[][] carte, Ocean ocean) {
        for (Iceberg2D iceberg : ocean.getIcebergs()) {
            int x1 = (int) iceberg.coinEnBasAGauche().getAbscisse();
            int y1 = (int) iceberg.coinEnBasAGauche().getOrdonnee();
            int x2 = (int) iceberg.coinEnHautADroite().getAbscisse();
            int y2 = (int) iceberg.coinEnHautADroite().getOrdonnee();
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    carte[i][j] = 1; // on met la couleur de l'iceberg
                }
            }
        }
    }

    /**
     * Ajoute le pingouin a la carte
     * @param carte tableau de couleurs
     * @param pingouin
     */
    private void ajouterPingouin(int[][] carte, Pingouin pingouin) {
        for (int i = pingouin.getX(); i < pingouin.getX() + pingouin.getTaille(); i++) {
            for (int j = pingouin.getY(); j < pingouin.getY() + pingouin.getTaille(); j++) {
                carte[i][j] = pingouin.getCouleur();
            }
        }
    }

    /**
     * Ajoute les poissons a la carte
     * @param carte tableau de couleurs
     * @param poissons
     */
    private void ajouterPoissons(int[][] carte, ArrayList<Poisson> poissons) {
        for (Poisson poisson : poissons) {
            if (poisson.getDirection() == 0) // horizontal
                for (int i = poisson.getX(); i < poisson.getX() + poisson.getLargeur(); i++) {
                    for (int j = poisson.getY(); j < poisson.getY() + poisson.getHauteur(); j++) {
                        carte[i][j] = poisson.getCouleurs();
                    }
                }
            else // vertical
                for (int i = poisson.getX(); i < poisson.getX() + poisson.getHauteur(); i++) {
                    for (int j = poisson.getY(); j < poisson.getY() + poisson.getLargeur(); j++) {
                        carte[i][j] = poisson.getCouleurs();
                    }
                }
        }
    }
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.jouer();
    }
}