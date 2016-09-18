
/**
 *Luokka pelitilanteiden ylläpitoa varten. Peli-luokka pitää yllä tietoa nykyisen
 * pelilaudan palikoiden järjestyksestä, tyhjän ruuden sijainnista ja pelitilanteen
 * arvosta.
 */
public class Game implements Comparable<Game> {

    private int[][] table; //peliruudukko
    private int x; //tyhjän ruudun x-koordinaatti
    private int y; //tyhjän ruudun y-koordinaatti
    private int value; //pelitilanteen arvo

    /**
     * Manhattan distancen -arvo.
     */
    public int Manhattan;

    /**
     * Viimeisin tyhjän ruudun suunta.
     */
    public Direction d; // suunta josta tilanteeseen on tultu

    /**
     * Siirtojen lukumäärä, jolla kyseiseen pelitilanteeseen on tultu.
     */
    public int moves;

    /**
     *Konstruktori
     * @param table Peliruudukko
     * @param x Tyhjän ruudun x-koordinaatti
     * @param y Tyhjän ruudun y-koordinaatti
     * @param manhattan Manhattan distancen arvo
     * @param value Pelitilanteen arvo
     * @param d Suunta, johon tyhjää on siirretty viimeksi.
     * @param moves Siirtojen lukumäärä
     */
    public Game(int[][] table, int x, int y, int manhattan, int value, Direction d, int moves) {
        this.table = table;
        this.x = x;
        this.y = y;
        this.d = d;
        this.Manhattan = manhattan;
        this.value = value;
        this.moves = moves;
    }

    /**
     *
     * @return
     */
    public int[][] getTable() {
        return table;
    }

    /**
     *
     * @param t
     */
    public void setTable(int[][] t) {
        this.table = t;
    }

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Game o) {
//        return this.Manhattan - o.Manhattan;
        return this.value - o.value;
    }
}
