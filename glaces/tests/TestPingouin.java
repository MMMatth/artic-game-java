package glaces.tests;

import glaces.Pingouin;
import glaces.Iceberg2D;
import geometrie.Point;



public class TestPingouin {
    static public void  main(String[] args) {
        testDeplacer();
        testGetX();
        testGetY();
        testGetTaille();
        testCreator();
        testEstFatigue();
        testEstSurIceberg();
        testEstRepose();
        testToSting();
    }

    static private void testCreator(){
        Pingouin pingouin = new Pingouin(0, 0, 5, 10);
        assert (pingouin.getX() == 0 
            && pingouin.getY() == 0 
            && pingouin.getTaille() == 5
            && pingouin.getVitesse() == 10
            ) : "Le pingouin n'a pas été créé correctement";
    }

    static private void testEstFatigue(){
        Pingouin pingouin = new Pingouin(0, 0, 5, 10);
        pingouin.estFatigue();
        assert (pingouin.getVitesse() == 5) : "EstFatigue n'a pas réduit la vitesse du pingouin";
        assert (pingouin.getCouleur() == 2) : "EstFatigue n'a pas changé la couleur du pingouin";
    }

    static private void testEstSurIceberg(){
        Pingouin pingouin = new Pingouin(0, 0, 5, 10);
        Iceberg2D iceberg = new Iceberg2D(new Point(0, 0), new Point(10, 10));
        assert (pingouin.estSurIceberg(iceberg)) : "EstSurIceberg n'a pas renvoyé true";
        pingouin.deplacer(1, 1);
        assert (!pingouin.estSurIceberg(iceberg)) : "EstSurIceberg n'a pas renvoyé false";
    }

    static private void testEstRepose(){
        Pingouin pingouin = new Pingouin(0, 0, 5, 10);
        pingouin.estFatigue();
        pingouin.estRepose();
        assert (pingouin.getVitesse() == 10) : "EstRepose n'a pas remis la vitesse à 10";
        assert (pingouin.getCouleur() == 3) : "EstRepose n'a pas remis la couleur à 3";
    }

    static private void testDeplacer() {
        Pingouin pingouin = new Pingouin(0, 0, 1, 5);
        pingouin.deplacer(1, 1);
        assert(pingouin.getX() == 5 && pingouin.getY() == 5) : "Deplacer n'a pas déplacé le pingouin";
        pingouin.deplacer(-1, -1);
        assert(pingouin.getX() == 0 && pingouin.getY() == 0) : "Deplacer n'a pas déplacé le pingouin";
    }

    static private void testGetX() {
        Pingouin pingouin = new Pingouin(2, 3, 1, 5);
        assert(pingouin.getX() == 2) : "GetX n'a pas renvoyé la bonne abscisse";
    }

    
    static private void testGetY() {
        Pingouin pingouin = new Pingouin(2, 3, 1, 5);
        assert(pingouin.getY() == 3) : "GetY n'a pas renvoyé la bonne ordonnée";
    }

    static private void testGetTaille() {
        Pingouin pingouin = new Pingouin(0, 0, 2, 5);
        assert(pingouin.getTaille() == 2) : "GetTaille n'a pas renvoyé la bonne taille";
    }

    static private void testToSting() {
        Pingouin pingouin = new Pingouin(0, 0, 2, 5);
        assert(pingouin.toString().equals("Pingouin [x=0, y=0, taille=2, vitesse=5, fatigue=0]")) : "ToString n'a pas renvoyé la bonne chaine";
    }
}