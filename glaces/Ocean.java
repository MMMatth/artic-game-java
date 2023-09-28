package glaces;
import geometrie.Point;
import java.util.Random;
import glaces.Iceberg2D;


public class Ocean {
    private int width;
    private int height;
    private Iceberg2D[] icebergs;

    public Ocean() {
        this.width = 300;
        this.height = 300;
        this.icebergs = new Iceberg2D[2];
        this.icebergs[0] = new Iceberg2D(new Point(50, 50), new Point(100, 100));
        this.icebergs[1] = new Iceberg2D(new Point(150, 150), new Point(200, 200));
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Iceberg2D[] getIcebergs() {
        return this.icebergs;
    }
}