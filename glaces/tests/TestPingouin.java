package glaces.tests;
import glaces.Pingouin;



public class TestPingouin {
    static public void  main(String[] args) {
        testDeplacer();
        testGetX();
        testGetY();
        testGetTaille();
    }

    static private void testDeplacer() {
        Pingouin pingouin = new Pingouin(0, 0, 1);
        pingouin.deplacer(1, 1);
        assert (pingouin.getX() == 1 && pingouin.getY() == 1) : "Deplacer n'a pas déplacé le pingouin"; 
    }

    static private void testGetX() {
        Pingouin pingouin = new Pingouin(2, 3, 1);
        assert(pingouin.getX() == 2) : "GetX n'a pas renvoyé la bonne abscisse";
    }

    
    static private void testGetY() {
        Pingouin pingouin = new Pingouin(2, 3, 1);
        assert(pingouin.getY() == 3) : "GetY n'a pas renvoyé la bonne ordonnée";
    }

    static private void testGetTaille() {
        Pingouin pingouin = new Pingouin(0, 0, 2);
        assert(pingouin.getTaille() == 2) : "GetTaille n'a pas renvoyé la bonne taille";
    }
}