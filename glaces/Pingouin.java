package glaces;


public class Pingouin {
    private int x;
    private int y;
    private int couleur;
    private int taille;
    private int fatigue;
    private int vitesse, vitesseFatigue, vitesseRepos;

    public Pingouin(int x, int y, int taille, int vitesse) {
        this.x = x;
        this.y = y;
        this.taille = taille;
        this.couleur = 3;
        this.fatigue = 0;
        this.vitesse = vitesse;
        this.vitesseFatigue = vitesse / 2;
        this.vitesseRepos = vitesse;
    }

    public void estFatigue(){
        System.out.println(fatigue);
        if (fatigue == 8){
            couleur = 2;
            vitesse = vitesseFatigue;
        }
    }

    public boolean estSurIceberg(Iceberg2D iceberg){
        if (iceberg.coinEnBasAGauche().getAbscisse() < x + taille && iceberg.coinEnHautADroite().getAbscisse() > x
            && iceberg.coinEnBasAGauche().getOrdonnee() < y + taille
            && iceberg.coinEnHautADroite().getOrdonnee() > y) 
        {
            return true;
        }else{
            return false;
        }
    }

    public void estRepose(){
        fatigue = 0;
        couleur = 3;
        vitesse = vitesseRepos;
    }

    public void deplacer(int dx, int dy) {
        x += dx * vitesse;
        y += dy * vitesse;
        fatigue++;
    }

    public int getCouleur() {
        return couleur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTaille() {
        return taille;
    }

    public int getVitesse() {
        return vitesse;
    }
}