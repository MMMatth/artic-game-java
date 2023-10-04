package glaces;

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


    /**
     * Deplace le poisson en fonction de sa direction et de sa vitesse
     */
    public void deplacer() {
        if (direction == 1) {
            x = (x + vitesse);
        } else {
            y = (y + vitesse);
        }
    }

    /**
     * Teste si le poisson est mangé par le pingouin
     * @param pingouin
     * @return
     */
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

    /**
     * Fait perdre une vie au poisson
     */
    public void perdVie() {
        viePoisson--;
    }

    /**
     * Retourne le nombre de vie du poisson
     * @return nombre de vie du poisson
     */
    public int getViePoisson() {
        return viePoisson;
    }

    /**
     * Fait mourir le poisson
     */
    public void meurt() {
        viePoisson = 0;
    }

    /**
     * Teste si le poisson est mort
     * @return vrai si le poisson est mort faux sinon
     */
    public boolean estMort() {
        return viePoisson == 0;
    }

    /**
     * Teste si le poisson est en dessous de l'iceberg
     * @param iceberg 
     * @return vrai si le poisson est en dessous de l'iceberg faux sinon
     */
    public boolean estEnDessousIceBerg(Iceberg2D iceberg) {
        if (iceberg.coinEnBasAGauche().getAbscisse() < x + largeur && iceberg.coinEnHautADroite().getAbscisse() > x
                && iceberg.coinEnBasAGauche().getOrdonnee() < y + hauteur
                && iceberg.coinEnHautADroite().getOrdonnee() > y) {
            return true;
        }
        return false;

    }

    /**
     * Retourne la position x du poisson
     * @return position x du poisson
     */
    public int getX() {
        return x;
    }

    /**
     * redéfinit la position x du poisson
     * @param x : nouvelle position x
     */
    public void setX(int x) {
        this.x = x; 
    }

    /**
     * Retourne la position y du poisson
     * @return position y du poisson
     */
    public int getY() {
        return y;
    }

    /**
     * redéfinit la position y du poisson
     * @param y : nouvelle position y
     */
    public void setY(int y) {
        this.y = y; 
    }

    /**
     * Retourne la largeur du poisson
     * @return largeur du poisson
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Retourne la hauteur du poisson
     * @return hauteur du poisson
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Retourne la direction du poisson
     * @return direction du poisson
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Retourne la couleur du poisson
     * @return couleur du poisson
     */
    public int getCouleurs() {
        return couleurs;
    }

    /**
     * Retourne la vitesse du poisson
     * @return vitesse du poisson
     */
    public int getVitesse() {
        return viePoisson;
    }

    /**
     * Fonction toString
     * @return String
     */
    public String toString() {
        return "Poisson [x=" + x + ", y=" + y + ", largeur=" + largeur + ", hauteur=" + hauteur + ", direction="
                + direction + ", couleurs=" + couleurs + ", viePoisson=" + viePoisson + ", vitesse=" + vitesse + "]";
    }
}