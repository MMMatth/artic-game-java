package glaces;

public class Poisson {
    private int x;
    private int y;
    private int largeur;
    private int hauteur;
    private int direction; // 0 pour horizontal, 1 pour vertical

    public Poisson(int x, int y, int largeur, int hauteur, int direction) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.direction = direction;
    }

    public void deplacer(int dx, int dy, int largeurOcean, int hauteurOcean) {
        if (direction == 0) {
            x = (x + dx + largeurOcean) % largeurOcean;
        } else {
            y = (y + dy + hauteurOcean) % hauteurOcean;
        }
    }

    public boolean estMange(Pingouin pingouin) {
        return (pingouin.getX() >= x && pingouin.getX() < x + largeur &&
                pingouin.getY() >= y && pingouin.getY() < y + hauteur);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getDirection() {
        return direction;
    }
}