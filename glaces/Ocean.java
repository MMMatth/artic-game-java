package glaces;
import geometrie.Point;
import java.util.Random;
import glaces.Iceberg2D;


public class Ocean {
    private int width;
    private int height;
    private Iceberg2D[] icebergs;


    public Ocean(int width, int height, Iceberg2D[] icebergs) {
        this.width = width;
        this.height = height;
        this.icebergs = icebergs;
    }

    public Ocean() {
        
        this.width = 300;
        this.height = 300;

        this.icebergs = new Iceberg2D[2];

        int largeurIceberg, hauteurIceberg, xIceberg, yIceberg;
        for (int i = 0; i < this.icebergs.length ; i++)
        {
            largeurIceberg = new Random().nextInt(50) + 20; // on genere un nombre entre 20 et 40
            hauteurIceberg = new Random().nextInt(50) + 20;
            xIceberg = new Random().nextInt(this.width - largeurIceberg);
            yIceberg = new Random().nextInt(this.height - hauteurIceberg);
            this.icebergs[i] = new Iceberg2D(new Point(xIceberg, yIceberg), new Point(xIceberg + largeurIceberg, yIceberg + hauteurIceberg));
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     * 
     * @param coeffFondre : coefficient de fonte entre 0 et 1 exclu
     */
    public void fondreOcean(double coeffFondre) {
        for (Iceberg2D Iceberg : icebergs) { 
            Iceberg.fondre(coeffFondre);
        }
    }

    public Iceberg2D[] getIcebergs() {
        return this.icebergs;
    }

    public Iceberg2D getIceberg(int i){
        return this.icebergs[i];
    } 
}