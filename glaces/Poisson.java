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
    private int direction;
    private int couleurs; 
    private int viePoisson;
    private int vitesse;

    public Poisson( int largeur, int hauteur, int direction, int couleurs,
        int viePoisson, int x, int y, int vitesse) {
        this.x = x;
        this.y = y;

        this.largeur = largeur;
        this.hauteur = hauteur;


        this.direction = direction; 
        this.couleurs = couleurs; 
        this.viePoisson = viePoisson;
        this.vitesse = vitesse;
    }


    public void deplacer() {
        if (direction == 1) {
            x = (x + vitesse);
        } else {
            y = (y + vitesse);
        }
    }

    public boolean estMange(Pingouin pingouin) {
        if (getDirection() == 1) {
            if (pingouin.getX() < x + hauteur && pingouin.getX() + pingouin.getTaille() > x
                    && pingouin.getY() < y + largeur && pingouin.getY() + pingouin.getTaille() > y) {
                return true;
            }
        } else {
            if (pingouin.getX() < x + largeur && pingouin.getX() + pingouin.getTaille() > x
                    && pingouin.getY() < y + hauteur && pingouin.getY() + pingouin.getTaille() > y) {
                return true;
            }
        }
        return false;
    }

    public void perdVie() {
        viePoisson--;
    }


    public void meurt() {
        viePoisson = 0;
    }

    public boolean estMort() {
        return viePoisson == 0;
    }

    public boolean estEnDessousIceBerg(Iceberg2D iceberg) {
        if (iceberg.coinEnBasAGauche().getAbscisse() < x + largeur && iceberg.coinEnHautADroite().getAbscisse() > x
                && iceberg.coinEnBasAGauche().getOrdonnee() < y + hauteur
                && iceberg.coinEnHautADroite().getOrdonnee() > y) {
            return true;
        }
        return false;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x; 
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y; 
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

    public int getVitesse() {
        return viePoisson;
    }
}