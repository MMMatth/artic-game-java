package glaces;
import geometrie.Point ;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 */
public class Iceberg2D {

    private Point enBasAGauche ;
    private Point enHautADroite ;

    /**
     * Construction
     * @param g le coin en bas à gauche
     * @param d le coin en haut à droite
     * uniquement en coordonnées positives
     */
    public Iceberg2D(Point g, Point d) {
        // on gere le cas ou les points sont inversés
        if (g.getAbscisse() > d.getAbscisse() || g.getOrdonnee() > d.getOrdonnee()) {
            this.enBasAGauche = d;
            this.enHautADroite = g;
        }else{
            this.enBasAGauche = g;
            this.enHautADroite = d;
        }
    }

    /**
     * Construction par fusion de deux icebergs qui se touchent
     * @param i1 premier iceberg à fusionner
     * @param i2 deuxième iceberg à fusionner
     */
    public Iceberg2D(Iceberg2D i1, Iceberg2D i2) {
        if (i1.collision(i2)){ // on verifie que les icebergs se touchent
            double absBasGauche = Math.min(i1.enBasAGauche.getAbscisse(), i2.enBasAGauche.getAbscisse());
            double ordBasGauche = Math.min(i1.enBasAGauche.getOrdonnee(), i2.enBasAGauche.getOrdonnee());
            double absHautDroite = Math.max(i1.enHautADroite.getAbscisse(), i2.enHautADroite.getAbscisse());
            double ordHautDroite = Math.max(i1.enHautADroite.getOrdonnee(), i2.enHautADroite.getOrdonnee());
            this.enBasAGauche = new Point(absBasGauche, ordBasGauche);
            this.enHautADroite = new Point(absHautDroite, ordHautDroite);
        }else{
            throw new IllegalArgumentException("Les icebergs ne se touchent pas");
        }
    }

    /**
     * Retourne le coin en bas à gauche
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        return this.enBasAGauche ;
    }

    /**
     * Retourne le coin en haut à droite
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        return this.enHautADroite ;
    }


    /**
     * Retourne la hauteur
     * @return hauteur
     */
    public double hauteur() {
        return this.enHautADroite.getOrdonnee() - this.enBasAGauche.getOrdonnee();
    }

    /**
     * Retourne la largeur
     * @return largeur
     */
    public double largeur() {
        return this.enHautADroite.getAbscisse() - this.enBasAGauche.getAbscisse();
    }

    /**
     * Retourne la surface totale
     * @return surface totale
     */
    public double surface() {
        return this.hauteur() * this.largeur() ;
    }

    /**
     * Retourne vrai si il y a une collision entre les deux icebergs
     * @param i iceberg potentiellement en collision
     * @return vrai si collision entre les deux icebergs
     */
    public boolean collision(Iceberg2D i) {
        if (this.enBasAGauche.getAbscisse() > i.enHautADroite.getAbscisse() || this.enHautADroite.getAbscisse() < i.enBasAGauche.getAbscisse()) {
            return false;
        }else if (this.enBasAGauche.getOrdonnee() > i.enHautADroite.getOrdonnee() || this.enHautADroite.getOrdonnee() < i.enBasAGauche.getOrdonnee()) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * Retourne vrai si this est plus volumineux que i
     * @param i iceberg à comparer
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(Iceberg2D i) {
        return this.surface() > i.surface() ;
    }

    public String toString() {       
        return  ("Point en bas a gauche : " + this.enBasAGauche + "\n" +
                "Point en haut a droite : " + this.enHautADroite + "\n" +
                "Hauteur : " + this.hauteur() + "\n" +
                "Largeur : " + this.largeur() + "\n" +
                "Surface : " + this.surface() + "\n");

    }

    /**
     * Retourne le point au centre
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
        double abs = this.largeur() / 2 + this.enBasAGauche.getAbscisse();
        double ord = this.hauteur() / 2 + this.enBasAGauche.getOrdonnee();
        return  (new Point(abs, ord));
    }

    /**
     * Réduction dans les quatre directions ; le centre ne bouge pas
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(double fr) {
        if (fr > 0 && fr < 1) {
            double largeur = this.largeur() * fr;
            double hauteur = this.hauteur() * fr;
            double absBasGauche = this.enBasAGauche.getAbscisse() + largeur / 2;
            double ordBasGauche = this.enBasAGauche.getOrdonnee() + hauteur / 2;
            double absHautDroite = this.enHautADroite.getAbscisse() - largeur / 2;
            double ordHautDroite = this.enHautADroite.getOrdonnee() - hauteur / 2;
            this.enBasAGauche = new Point(absBasGauche, ordBasGauche);
            this.enHautADroite = new Point(absHautDroite, ordHautDroite);
        }
    }

    /**
     * Casser une partie à droite
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(double fr) {
        if (fr > 0 && fr < 1) {
            double largeur = this.largeur() * fr;
            this.enHautADroite = new Point(this.enHautADroite.getAbscisse() - largeur, this.enHautADroite.getOrdonnee());
        }

    }

    /**
     * Casser une partie à gauche
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(double fr) {
        if (fr > 0 && fr < 1) {
            double largeur = this.largeur() * fr;
            this.enBasAGauche = new Point(this.enBasAGauche.getAbscisse() + largeur, this.enBasAGauche.getOrdonnee());
        }
    }

    /**
     * Casser une partie en haut
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(double fr) {
        if (fr > 0 && fr < 1) {
            double hauteur = this.hauteur() * fr;
            this.enHautADroite = new Point(this.enHautADroite.getAbscisse(), this.enHautADroite.getOrdonnee() - hauteur);
        }
    }

    /**
     * Casser une partie en bas
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(double fr) {
        if (fr > 0 && fr < 1) {
            double hauteur = this.hauteur() * fr;
            this.enBasAGauche = new Point(this.enBasAGauche.getAbscisse(), this.enBasAGauche.getOrdonnee() + hauteur);
        }
    }

}