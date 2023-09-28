package glaces.tests;
import geometrie.Point ;
import glaces.Iceberg2D;

public class TestIceberg2D {
    static public void main(String[] args) {
        testCreator();
        testFusionner();
        testCoinEnBasAGauche();
        testCoinEnHautADroite();
        testHauteur();
        testLargeur();
        testSurface();
        testCollision();
        testToString();
        testCentre();
        testFondre();
        testCasserDroite();
        testCasserGauche();
        testCasserHaut();
        testCasserBas();

    }
    private static void testCreator() {
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.coinEnBasAGauche().getAbscisse() == 0. &&
                i1.coinEnBasAGauche().getOrdonnee() == 0. &&
                i1.coinEnHautADroite().getAbscisse() == 1. &&
                i1.coinEnHautADroite().getOrdonnee() == 1.) : "Iceberg2D() failed";
        i1 = new Iceberg2D(new Point(1., 1.), new Point(0., 0.));
        assert (i1.coinEnBasAGauche().getAbscisse() == 0. &&
                i1.coinEnBasAGauche().getOrdonnee() == 0. &&
                i1.coinEnHautADroite().getAbscisse() == 1. &&
                i1.coinEnHautADroite().getOrdonnee() == 1.) : "Iceberg2D() failed";
    }
    private static void testFusionner(){
        Iceberg2D i1, i2, i3;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        i2 = new Iceberg2D(new Point(0.5, 0.5), new Point(1.5, 1.5));
        i3 = new Iceberg2D(i1, i2);
        // cas les deux icebergs se touchent (erreur sinon)
        assert (i3.coinEnBasAGauche().getAbscisse() == 0. 
        && i3.coinEnBasAGauche().getOrdonnee() == 0.0 
        && i3.coinEnHautADroite().getAbscisse() == 1.5
        && i3.coinEnHautADroite().getOrdonnee() == 1.5) : "fusionner() failed";  
    }
    private static void testCoinEnBasAGauche() {
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.coinEnBasAGauche().getAbscisse() == 0.) : "coinEnBasAGauche() failed";
        assert (i1.coinEnBasAGauche().getOrdonnee() == 0.) : "coinEnBasAGauche() failed";
    }
    private static void testCoinEnHautADroite() {
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.coinEnHautADroite().getAbscisse() == 1.) : "coinEnHautADroite() failed";
        assert (i1.coinEnHautADroite().getOrdonnee() == 1.) : "coinEnHautADroite() failed";
    }
    private static void testHauteur(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.hauteur() == 1.) : "hauteur() failed";
    }
    private static void testLargeur(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.largeur() == 1.) : "largeur() failed";
    }
    private static void testSurface(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.surface() == 1.) : "surface() failed";
    }
    private static void testCollision(){
        Iceberg2D i1, i2;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        // cas les deux icebergs se touchent
        i2 = new Iceberg2D(new Point(0.5, 0.5), new Point(1.5, 1.5));
        assert (i1.collision(i2)) : "collision() failed";
        // cas les deux icebergs ne se touchent pas
        i2 = new Iceberg2D(new Point(1.5, 1.5), new Point(2.5, 2.5));
        assert (!i1.collision(i2)) : "collision() failed";
        // cas les deux icebergs se touchent par un coin
        i2 = new Iceberg2D(new Point(1., 1.), new Point(2., 2.));
        assert (i1.collision(i2) == true) : "collision() failed";
        // cas les deux icebergs se touchent par un bord
        i2 = new Iceberg2D(new Point(1., 0.), new Point(2., 1.));
        assert (i1.collision(i2) == true) : "collision() failed";
        
    }
    private static void testToString(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.toString().equals("Point en bas a gauche : <0.0,0.0>\nPoint en haut a droite : <1.0,1.0>\nHauteur : 1.0\nLargeur : 1.0\nSurface : 1.0\n"));
    }
    private static void testCentre(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        assert (i1.centre().getAbscisse() == 0.5 && i1.centre().getOrdonnee() == 0.5) : "milieu() failed";
    }
    private static void testFondre(){
        // cas positif
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        i1.fondre(0.5);
        assert (i1.hauteur() == 0.5 && i1.largeur() == 0.5) : "fondre() failed";
        // coord négatives
        i1 = new Iceberg2D(new Point(-1., -1.), new Point(1., 1.));
        i1.fondre(0.5);
        assert (i1.hauteur() == 1. && i1.largeur() == 1.) : "fondre() failed";

    }
    private static void testCasserDroite(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        i1.casserDroite(0.5);
        assert (i1.coinEnBasAGauche().getAbscisse() == 0. && i1.largeur() == 0.5) : "casserDroite() failed";
    }
    private static void testCasserGauche(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        i1.casserGauche(0.5);
        assert (i1.coinEnHautADroite().getAbscisse() == 1. && i1.largeur() == 0.5) : "casserGauche() failed";
    }
    private static void testCasserHaut(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        i1.casserHaut(0.5);
        assert (i1.hauteur() == 0.5 && i1.coinEnBasAGauche().getOrdonnee() == 0.) : "casserHaut() failed";
    }
    private static void testCasserBas(){
        Iceberg2D i1;
        i1 = new Iceberg2D(new Point(0., 0.), new Point(1., 1.));
        i1.casserBas(0.5);
        assert (i1.hauteur() == 0.5 && i1.coinEnHautADroite().getOrdonnee() == 1.) : "casserBas() failed";
    }
}
