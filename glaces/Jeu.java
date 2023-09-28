package glaces;

import java.util.Scanner;

public class Jeu {
    private ArcticImage image;
    private Ocean ocean;
    private Pingouin pingouin;

    public Jeu() {
        ocean = new Ocean();
        pingouin = new Pingouin(ocean.getWidth() / 2, ocean.getHeight() / 2, 14); // on met le pingouin au milieu
        image = new ArcticImage(ocean.getWidth(), ocean.getHeight()); // on cree l'image
        image.setColors(creeCarte(ocean.getWidth(), ocean.getHeight(), ocean, pingouin)); // on met les couleurs
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
            
            image.setColors(creeCarte(ocean.getWidth(), ocean.getHeight(), ocean, pingouin));
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

    private int[][] creeCarte(int mapWidth, int mapHeight, Ocean ocean, Pingouin pingouin) {
        int[][] carte = new int[mapWidth][mapHeight];
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                carte[i][j] = 0; // on met de l'eau de base
                // on met de la glace si on est dans un iceberg
                for (Iceberg2D iceberg : ocean.getIcebergs()) {
                    if (iceberg.coinEnBasAGauche().getAbscisse() <= i
                        && iceberg.coinEnBasAGauche().getOrdonnee() <= j
                        && iceberg.coinEnHautADroite().getAbscisse() > i
                        && iceberg.coinEnHautADroite().getOrdonnee() > j) 
                    {
                        carte[i][j] = 1;
                    }
                }
                // on met le pingouin si on est dans le pingouin
                if (pingouin.getX() <= i 
                    && i < pingouin.getX() + pingouin.getTaille()
                    && pingouin.getY() <= j 
                    && j < pingouin.getY() + pingouin.getTaille()) {
                    carte[i][j] = 3;
                }


            }
        }
        return carte;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.jouer();
    }
}