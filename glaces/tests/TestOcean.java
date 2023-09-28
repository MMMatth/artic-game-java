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
    }

    static private void testCreator() {
        Ocean ocean = new Ocean();
        assert (ocean.getWidth() == 300) : "testCreator: Width should be 300";
        assert (ocean.getHeight() == 300) : "testCreator: Height should be 300";
        assert (ocean.getIcebergs().length == 2) : "testCreator: There should be 2 icebergs";
    }

    static private void testGetWidth() {
        Ocean ocean = new Ocean(200, 200);
        assert ocean.getWidth() == 200 : "testGetWidth: Width should be 200";
    }

    static private void testGetHeight() {
        Ocean ocean = new Ocean(200, 200);
        assert ocean.getHeight() == 200 : "testGetHeight: Height should be 200";
    }

    static private void testGetIcebergs() {
        Ocean ocean = new Ocean(200, 200);
        assert ocean.getIcebergs().length == 2 : "testGetIcebergs: There should be 2 icebergs";
    }

}
