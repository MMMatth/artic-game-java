package glaces;

public class Pingouin {
    private int x;
    private int y;
    private int taille;

    public Pingouin(int x, int y, int taille) {
        this.x = x;
        this.y = y;
        this.taille = taille;
    }

    public void deplacer(int dx, int dy) {
        x += dx;
        y += dy;
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
}