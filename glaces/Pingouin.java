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

    /**
     * Teste si le pingouin est fatigué et change sa couleur et sa vitesse si c'est le cas
     */
    public void estFatigue(){
        System.out.println(fatigue);
        if (fatigue == 8){
            couleur = 2;
            vitesse = vitesseFatigue;
        }
    }

    /**
     * Teste si le pingouin est sur un iceberg
     * @param iceberg
     * @return
     */
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

    /**
     * Remet le pingouin en état de repos
     */
    public void estRepose(){
        fatigue = 0;
        couleur = 3;
        vitesse = vitesseRepos;
    }

    /**
     * Deplace le pingouin en fonction de dx et dy
     * @param dx
     * @param dy
     */
    public void deplacer(int dx, int dy) {
        x += dx * vitesse;
        y += dy * vitesse;
        fatigue++;
    }

    /**
     * Retourne la couleur du pingouin
     * @return couleur
     */
    public int getCouleur() {
        return couleur;
    }

    /**
     * Retourne la position x du pingouin
     * @return position x du pingouin
     */
    public int getX() {
        return x;
    }

    /**
     * Retourne la position y du pingouin
     * @return position y du pingouin
     */
    public int getY() {
        return y;
    }

    /**
     * Retourne la taille du pingouin
     * @return taille du pingouin
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Retourne la vitesse du pingouin
     * @return vitesse du pingouin
     */
    public int getVitesse() {
        return vitesse;
    }
}