package glaces;
import geometrie.Point;

import java.sql.Ref;
// random
import java.util.Random;

public class Poisson {
    private int x;
    private int y;
    private int largeur;
    private int hauteur;
    private int direction; // 0 pour horizontal, 1 pour vertical
    private int couleurs; // 4 ou 5
    private int mapHeight;
    private int mapWidth;

    public Poisson(int mapHeight, int mapWidth, int largeur, int hauteur) {
        this.x = new Random().nextInt(mapWidth - 1);
        this.y = new Random().nextInt(mapHeight- 1);
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        if (this.x + largeur > mapWidth) this.x = mapWidth - largeur; // on verifie que le poisson ne sort pas de l'ocean
        if (this.y + hauteur > mapHeight) this.y = mapHeight - hauteur;
        
        this.direction = new Random().nextInt(2);
        this.couleurs = new Random().nextInt(2) + 4;
    }

    public void refreshPosPoisson(int vitesse){
        if (direction == 0) // si le poisson est vertical
            {
                if (y + (hauteur + vitesse)  >= mapHeight)
                {
                    y = 0;
                }
            }
        else
            {            
                if (x + (hauteur + vitesse) >= mapWidth)
                {
                    x = 0;
                }
            }
        
    }

    public void deplacer(int vitesse, int largeurOcean, int hauteurOcean) {
        refreshPosPoisson(vitesse);

        if (direction == 1) {
            x = (x + vitesse) ;
        } else {
            y = (y + vitesse) ;
        }
        refreshPosPoisson(vitesse);
    }

    public boolean estMange(Pingouin pingouin) {
        if (getDirection() == 1 )
        {
            if (pingouin.getX() < x + hauteur && pingouin.getX() + pingouin.getTaille() > x && pingouin.getY() < y + largeur && pingouin.getY() + pingouin.getTaille() > y) 
            {
                return true;
            }
        }
        else
        {
            if (pingouin.getX() < x + largeur && pingouin.getX() + pingouin.getTaille() > x && pingouin.getY() < y + hauteur && pingouin.getY() + pingouin.getTaille() > y) 
            {
                return true;
            }
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getDirection() {
        return direction;
    }

    public int getCouleurs() {
        return couleurs;
    }
}