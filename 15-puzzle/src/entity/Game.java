package entity;


import java.util.Random;

/**
 * Luokka pelitilanteiden ylläpitoa varten. Peli-luokka pitää yllä tietoa
 * nykyisen pelilaudan palikoiden järjestyksestä, tyhjän ruuden sijainnista ja
 * pelitilanteen arvosta.
 */
public class Game implements Comparable<Game> {

    private int[][] table; //peliruudukko
    private int x; //tyhjän ruudun x-koordinaatti
    private int y; //tyhjän ruudun y-koordinaatti
    private int value; //pelitilanteen arvo
    private Direction d; // suunta josta tilanteeseen on tultu
    private int moves; //siirtomäärä, jolla kyseiseen tilanteeseen ollaan päästy
    private Game parent; //peli, josta tilanteeseen on tultu. Ratkaisun tulostamista varten

    /**
     * Konstruktori joka luo uuden peliolion annettujen parametrien perusteella.
     * @param table Peliruudukko
     * @param x Tyhjän ruudun x-koordinaatti
     * @param y Tyhjän ruudun y-koordinaatti
     * @param d Suunta, johon tyhjää on siirretty viimeksi.
     * @param moves Siirtojen lukumäärä
     */
    public Game(int[][] table, int x, int y, int moves, Game parent, Direction d) {
        this.table = table;
        this.x = x;
        this.y = y;
        this.d = d;
        this.moves = moves;
        this.value = Logic.countManhattan(table) + moves;
        this.parent = parent;
    }

    /**
     *Konstruktori, joka luo uuden satunnaisen pelin aloitustilanteen.
     * @param size pelineliön sivunpituus
     */
    public Game(int size) {
        this.table = initTable(size);
        int[] xy = findXY(table);
        this.x = xy[0];
        this.y = xy[1];
        this.d = null;
        this.value = Logic.countManhattan(this.table);
        this.moves = 0;
        this.parent = null;
    }

    private int[] findXY(int[][] table) { //etsii "tyhjän" pelilaatan sijainnin 
        int[] xy = new int[2];
        int number = table.length * table[0].length;
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                if (table[j][i] == number) {
                    xy[0] = i;
                    xy[1] = j;
                    break;
                }
            }
        }
        return xy;
    }

    private int[][] initTable(int size) { // alustaa uuden pelin
        int[][] table = new int[size][size];
        int number = 1;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                table[j][i] = number;
                number++;
            }
        }
        table = mixTable(table);
        return table;
    }

    private int[][] mixTable(int[][] table) { //sekoittaa pelilaudan
        Direction[] values = Direction.values();
        Random random = new Random();
        int y = table.length - 1;
        int x = table[0].length - 1;
        int count = 0;
        Direction d;
        while (count < 1000) {
            d = values[random.nextInt(values.length)];
            switch (d) {
                case UP:
                    if (y - 1 >= 0) {
                        table = Logic.moveBlock(table, x, y, d);
                        y--;
                    }
                    break;
                case DOWN:
                    if (y + 1 < table.length) {
                        table = Logic.moveBlock(table, x, y, d);
                        y++;
                    }
                    break;
                case LEFT:
                    if (x - 1 >= 0) {
                        table = Logic.moveBlock(table, x, y, d);
                        x--;
                    }
                    break;
                case RIGHT:
                    if (x + 1 < table.length) {
                        table = Logic.moveBlock(table, x, y, d);
                        x++;
                    }
                    break;
            }
            count++;
        }
        return table;
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
     * @return
     */
    public int getMoves() {
        return this.moves;
    }

    /**
     *
     * @return
     */
    public Direction getDirection() {
        return this.d;
    }

    @Override
    public int compareTo(Game o) {
        return this.value - o.value;
    }
}
