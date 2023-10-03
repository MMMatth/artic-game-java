package glaces.tests;
import glaces.Ocean;
import geometrie.Point;
import glaces.Iceberg2D;

public class TestOcean {
    static public void main(String[] args) {
        testCreator();
        testGetWidth();
        testGetHeight();
        testGetIcebergs();
        testGetIceberg();
        testFondreOcean();

    }

    static private void testCreator() {
        Iceberg2D iceberg1 = new Iceberg2D(new Point(0, 0), new Point(100, 100));
        Iceberg2D iceberg2 = new Iceberg2D(new Point(200, 200), new Point(300, 300));
        Iceberg2D[] icebergs = {iceberg1, iceberg2};
        Ocean ocean = new Ocean(300, 300, icebergs);
        assert (ocean.getWidth() == 300) : "testCreator: La largeur devrait être de 300";
        assert (ocean.getHeight() == 300) : "testCreator: La hauteur devrait être de 300";
        assert (ocean.getIcebergs().length == 2) : "testCreator: Il devrait y avoir 2 icebergs";
    }

    static private void testGetWidth() {
        Ocean ocean = new Ocean(200, 200, new Iceberg2D[2]);
        assert (ocean.getWidth() == 200) : "testGetWidth: La largeur devrait être de 200";
    }

    static private void testGetHeight() {
        Ocean ocean = new Ocean(200, 200, new Iceberg2D[2]);
        assert (ocean.getHeight() == 200) : "testGetHeight: La hauteur devrait être de 200";
    }

    static private void testGetIcebergs() {
        Iceberg2D iceberg1 = new Iceberg2D(new Point(0, 0), new Point(100, 100));
        Iceberg2D iceberg2 = new Iceberg2D(new Point(200, 200), new Point(300, 300));
        Iceberg2D[] icebergs = {iceberg1, iceberg2};
        Ocean ocean = new Ocean(300, 300, icebergs);
        assert (ocean.getIcebergs().length == 2) : "testGetIcebergs: Il devrait y avoir 2 icebergs";
    }
    static private void testGetIceberg(){
        Iceberg2D iceberg1 = new Iceberg2D(new Point(0, 0), new Point(100, 100));
        Iceberg2D iceberg2 = new Iceberg2D(new Point(200, 200), new Point(300, 300));
        Iceberg2D[] icebergs = {iceberg1, iceberg2};
        Ocean ocean = new Ocean(300, 300, icebergs);
        assert (ocean.getIceberg(0) == iceberg1) : "testGetIceberg: iceberg1 devrait être à l'index 0";
        assert (ocean.getIceberg(1) == iceberg2) : "testGetIceberg: iceberg2 devrait être à l'index 1";
    }

    static private void testFondreOcean() {
        Iceberg2D iceberg1 = new Iceberg2D(new Point(0, 0), new Point(100, 100));
        Iceberg2D iceberg2 = new Iceberg2D(new Point(200, 200), new Point(300, 300));
        Iceberg2D[] icebergs = {iceberg1, iceberg2};
        Ocean ocean = new Ocean(300, 300, icebergs);
        ocean.fondreOcean(0.5);
        assert (ocean.getIceberg(0).coinEnBasAGauche().getAbscisse() == 25
            && ocean.getIceberg(0).coinEnBasAGauche().getOrdonnee() == 25
            && ocean.getIceberg(0).coinEnHautADroite().getAbscisse() == 75 
            && ocean.getIceberg(0).coinEnHautADroite().getOrdonnee() == 75) : "testFondreOcean: Problème avec iceberg1";
        assert (ocean.getIceberg(1).coinEnBasAGauche().getAbscisse() == 225
            && ocean.getIceberg(1).coinEnBasAGauche().getOrdonnee() == 225
            && ocean.getIceberg(1).coinEnHautADroite().getAbscisse() == 275
            && ocean.getIceberg(1).coinEnHautADroite().getOrdonnee() == 275) : "testFondreOcean: Problème avec iceberg2";
    }

}