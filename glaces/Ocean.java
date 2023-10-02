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

        this.icebergs = new Iceberg2D[6];

        int largeurIceberg, hauteurIceberg, xIceberg, yIceberg;
        for (int i = 0; i < this.icebergs.length ; i++)
        {
            largeurIceberg = new Random().nextInt(20) + 20; // on genere un nombre entre 20 et 40
            hauteurIceberg = new Random().nextInt(20) + 20;
            xIceberg = new Random().nextInt(this.width - largeurIceberg);
            yIceberg = new Random().nextInt(this.height - hauteurIceberg);
            this.icebergs[i] = new Iceberg2D(new Point(xIceberg, yIceberg), new Point(xIceberg + largeurIceberg, yIceberg + hauteurIceberg));
        }
        // this.icebergs[0] = new Iceberg2D(new Point(50, 50), new Point(100, 100));
        // this.icebergs[1] = new Iceberg2D(new Point(150, 150), new Point(200, 200));
    }

    public void removeIceberg(int i) {
        this.icebergs[i] = null;
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