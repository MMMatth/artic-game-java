package glaces.tests;

import glaces.Poisson;
import glaces.Pingouin;
import glaces.Iceberg2D;
import geometrie.Point;

public class TestPoisson {
    static public void main(String[] args) {
        testDeplacer();
        testEstMange();
        testPerdVie();
        testMeurt();
        testEstMort();
        testEstEnDessousIceBerg();
        testGetX();
        testGetY();
        testGetLargeur();
        testGetHauteur();
        testGetDirection();
        testGetCouleurs();
        testGetVitesse();
        testGetViePoisson();
        testToSting();
    }

    static private void testDeplacer() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 0, 0, 1);
        poisson.deplacer();
        assert (poisson.getX() == 1 && poisson.getY() == 0) : "Deplacer n'a pas déplacé le poisson";
        poisson = new Poisson(2, 3, 0, 5, 10, 0, 0, 1);
        poisson.deplacer();
        assert (poisson.getX() == 0 && poisson.getY() == 1) : "Deplacer n'a pas déplacé le poisson";
    }

    static private void testEstMange() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 0, 0, 1);
        Pingouin pingouin = new Pingouin(0, 0, 2, 5);
        assert (poisson.estMange(pingouin)) : "EstMange n'a pas renvoyé true";
        pingouin = new Pingouin(10, 10, 2, 5);
        assert (!poisson.estMange(pingouin)) : "EstMange n'a pas renvoyé false";
    }

    static private void testPerdVie() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 0, 0, 1);
        poisson.perdVie();
        assert (poisson.getViePoisson() == 9) : "PerdVie n'a pas fait perdre une vie au poisson";
    }

    static private void testMeurt() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 0, 0, 1);
        poisson.meurt();
        assert (poisson.getViePoisson() == 0) : "Meurt n'a pas fait mourir le poisson";
    }

    static private void testEstMort() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 0, 0, 1);
        assert (!poisson.estMort()) : "EstMort n'a pas renvoyé false";
        poisson.meurt();
        assert (poisson.estMort()) : "EstMort n'a pas renvoyé true";
    }

    static private void testEstEnDessousIceBerg() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 0, 0, 1);
        Iceberg2D iceberg = new Iceberg2D(new Point(0, 0), new Point(10, 10));
        assert (poisson.estEnDessousIceBerg(iceberg)) : "EstEnDessousIceBerg n'a pas renvoyé true";
        iceberg = new Iceberg2D(new Point(10, 10), new Point(20, 20));
        assert (!poisson.estEnDessousIceBerg(iceberg)) : "EstEnDessousIceBerg n'a pas renvoyé false";
    }

    static private void testGetX() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getX() == 2) : "GetX n'a pas renvoyé la bonne abscisse";
    }

    static private void testGetY() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getY() == 3) : "GetY n'a pas renvoyé la bonne ordonnée";
    }

    static private void testGetLargeur() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getLargeur() == 2) : "GetLargeur n'a pas renvoyé la bonne largeur";
    }

    static private void testGetHauteur() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getHauteur() == 3) : "GetHauteur n'a pas renvoyé la bonne hauteur";
    }

    static private void testGetDirection() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getDirection() == 1) : "GetDirection n'a pas renvoyé la bonne direction";
    }

    static private void testGetCouleurs() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getCouleurs() == 5) : "GetCouleurs n'a pas renvoyé la bonne couleur";
    }

    static private void testGetVitesse() {
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getVitesse() == 10) : "GetVitesse n'a pas renvoyé la bonne vitesse";
    }
    static private void testGetViePoisson(){
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.getViePoisson() == 10) : "GetViePoisson n'a pas renvoyé la bonne vie";
    }

    static private void testToSting(){
        Poisson poisson = new Poisson(2, 3, 1, 5, 10, 2, 3, 1);
        assert (poisson.toString().equals("Poisson [x=2, y=3, largeur=2, hauteur=3, direction=1, couleurs=5, viePoisson=10, vitesse=1]")) : "testToString: Problème avec toString";
    }
} 
    

