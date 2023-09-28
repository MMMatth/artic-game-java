package glaces.tests;
import glaces.ArcticImage;
import geometrie.Point;
import glaces.Iceberg2D;
import glaces.Ocean;

public class TestArticImage {
    static public void main(String[] args){
        testAfficherLignePaire();
        testAfficherOcean();
    }

    static private void testAfficherOcean(){
        Ocean ocean = new Ocean();
        int[][] colors = new int[ocean.getWidth()][ocean.getHeight()];
        for (int i = 0; i < ocean.getWidth(); i++) {
            for (int j = 0; j < ocean.getHeight(); j++) {
                boolean isIceberg = false;
                for (Iceberg2D iceberg : ocean.getIcebergs()) {
                    if (iceberg.coinEnBasAGauche().getAbscisse() < i
                        && iceberg.coinEnBasAGauche().getOrdonnee() < j
                        && iceberg.coinEnHautADroite().getAbscisse() > i
                        && iceberg.coinEnHautADroite().getOrdonnee() > j) {
                        isIceberg = true;
                        break;
                    }
                }
                colors[i][j] = isIceberg ? 1 : 0;
            }
        }
        ArcticImage image = new ArcticImage(ocean.getWidth(), ocean.getHeight());
        image.setColors(colors);
    }

    static private void testAfficherLignePaire(){
        int[][] colors = new int[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                if (i % 2 == 0) {
                    colors[i][j] = 0;
                } else {
                    colors[i][j] = 1;
                }
            }
        }
        ArcticImage image = new ArcticImage(300, 300);
        image.setColors(colors);
    }
}
