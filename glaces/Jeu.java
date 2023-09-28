package glaces;

import java.util.Scanner;
import java.util.ArrayList;

public class Jeu {
    private ArcticImage image;
    private Ocean ocean;
    private Pingouin pingouin;
    private ArrayList<Poisson> poissons;

    public Jeu() {
        ocean = new Ocean();
        pingouin = new Pingouin(30, 30, 14); // on met le pingouin au milieu
        image = new ArcticImage(ocean.getWidth(), ocean.getHeight()); // on cree l'image
        poissons = new ArrayList<Poisson>();

        for (int i = 0; i < 20; i++) {
            poissons.add(new Poisson(ocean.getWidth() - 1, ocean.getHeight() - 1, 5, 10));
        }

        image.setColors(creeCarte(ocean.getWidth(), ocean.getHeight(), ocean, pingouin, poissons)); // on met les couleurs
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            
            System.out.println("Deplacez le pingouin avec les touches zqsd (ou tapez une autre touche pour quitter) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("z")) { // ingore case dans le cas de la maj
                deplacerPingouin(0, 7);
            } else if (input.equalsIgnoreCase("q")) {
                deplacerPingouin(-7, 0);
            } else if (input.equalsIgnoreCase("s")) {
                deplacerPingouin(0, -7);
            } else if (input.equalsIgnoreCase("d")) {
                deplacerPingouin(7, 0);
            } else {
                break;
            }
            for (int i = 0; i < poissons.size(); i++) {
                if (poissons.get(i).estMange(pingouin) && ) {
                    poissons.remove(i);
                }
            }
            image.setColors(creeCarte(ocean.getWidth(), ocean.getHeight(), ocean, pingouin, poissons));
        }
    }
    /**
     * Deplace le pingouin de dx et dy (en gerant les limites de l'ocean)
     * @param dx
     * @param dy
     */
    private void deplacerPingouin(int dx, int dy) {
        int newX = pingouin.getX() + dx;
        int newY = pingouin.getY() + dy;
        if (newX >= 0 && newX < ocean.getWidth() && newY >= 0 && newY < ocean.getHeight()) {
            pingouin.deplacer(dx, dy);
        }
    }

    private int[][] creeCarte(int mapWidth, int mapHeight, Ocean ocean, Pingouin pingouin, ArrayList<Poisson> poissons) {
        int[][] carte = new int[mapWidth][mapHeight];
        ajouterPoissons(carte, poissons);
        ajouterIceberg(carte, ocean);
        ajouterPingouin(carte, pingouin);
        return carte;
    }

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

    private void ajouterPingouin(int[][] carte, Pingouin pingouin) {
        for (int i = pingouin.getX(); i < pingouin.getX() + pingouin.getTaille(); i++) {
            for (int j = pingouin.getY(); j < pingouin.getY() + pingouin.getTaille(); j++) {
                carte[i][j] = 3;
            }
        }
    }

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