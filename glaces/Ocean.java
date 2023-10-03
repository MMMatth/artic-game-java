package glaces;
import geometrie.Point;
import java.util.Random;
import glaces.Iceberg2D;


public class Ocean {
    private int width;
    private int height;
    private Iceberg2D[] icebergs;


    /**
     * Constructeur avec parametres
     * @param width largeur de l'ocean
     * @param height hauteur de l'ocean
     * @param icebergs liste des icebergs
     */
    public Ocean(int width, int height, Iceberg2D[] icebergs) {
        this.width = width;
        this.height = height;
        this.icebergs = icebergs;
    }

    /**
     * Constructeur sans parametres
     * Genere un ocean de 300x300 avec 2 icebergs
     * Les icebergs sont de taille aleatoire
     */
    public Ocean() {
        
        this.width = 600;
        this.height = 600;

        this.icebergs = new Iceberg2D[10];

        int largeurIceberg, hauteurIceberg, xIceberg, yIceberg;
        for (int i = 0; i < this.icebergs.length ; i++)
        {
            largeurIceberg = new Random().nextInt(50) + 20; // entre 20 et 70
            hauteurIceberg = new Random().nextInt(50) + 20;
            xIceberg = new Random().nextInt(this.width - largeurIceberg);
            yIceberg = new Random().nextInt(this.height - hauteurIceberg);
            this.icebergs[i] = new Iceberg2D(new Point(xIceberg, yIceberg), new Point(xIceberg + largeurIceberg, yIceberg + hauteurIceberg));
        }
    }

    /**
     * 
     * @param coeffFondre : coefficient de fonte entre ]0,1]
     */
    public void fondreOcean(double coeffFondre) {
        for (Iceberg2D Iceberg : icebergs) { 
            Iceberg.fondre(coeffFondre);
        }
    }

    /**
     * recuperer la liste des icebergs
     * @return liste des icebergs
     */
    public Iceberg2D[] getIcebergs() {
        return this.icebergs;
    }

    /**
     * recuperer un iceberg
     * @param i : indice de l'iceberg
     * @return iceberg
     */
    public Iceberg2D getIceberg(int i){
        return this.icebergs[i];
    } 

    /**
     * recuper la largeur de l'ocean
     * @return
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * recuper la hauteur de l'ocean
     * @return
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * fonction toString
     * @return string
     */
    public String toString() {
        String str = "Ocean de largeur " + this.width + " et de hauteur " + this.height + "\n";
        for (Iceberg2D Iceberg : icebergs) {
            str += Iceberg.toString() + "\n";
        }
        return str;
    }
}