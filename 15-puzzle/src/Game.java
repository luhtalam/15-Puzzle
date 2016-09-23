
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

    /**
     * Siirtojen lukumäärä, jolla kyseiseen pelitilanteeseen on tultu.
     */
    public int moves;

    /**
     * Konstruktori
     *
     * @param table Peliruudukko
     * @param x Tyhjän ruudun x-koordinaatti
     * @param y Tyhjän ruudun y-koordinaatti
     * @param value Pelitilanteen arvo (MD + moves so far)
     * @param d Suunta, johon tyhjää on siirretty viimeksi.
     * @param moves Siirtojen lukumäärä
     */
    public Game(int[][] table, int x, int y, int value, Direction d, int moves) {
        this.table = table;
        this.x = x;
        this.y = y;
        this.d = d;
        this.value = value;
        this.moves = moves;
    }

    public Game(int size) {
        this.table = initTable(size);
        int[] xy = findXY(table);
        this.x = xy[0];
        this.y = xy[1];
        this.d = null;
        this.value = Logic.countManhattan(this.table);
        this.moves = 0;
    }

    private int[] findXY(int[][] table) {
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

    private int[][] initTable(int size) {
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

    private int[][] mixTable(int[][] table) {
        Direction[] values = Direction.values();
        Random random = new Random();
        int j = table.length - 1;
        int i = table[0].length - 1;
        int count = 0;
        Direction d;
        while (count < 1000) {
            d = values[random.nextInt(values.length)];
            switch (d) {
                case UP:
                    if (j - 1 >= 0) {
                        table = Logic.moveBlock(table, j, i, d);
                        j--;
                    }
                    break;
                case DOWN:
                    if (j + 1 < table.length) {
                        table = Logic.moveBlock(table, j, i, d);
                        j++;
                    }
                    break;
                case LEFT:
                    if (i - 1 >= 0) {
                        table = Logic.moveBlock(table, j, i, d);
                        i--;
                    }
                    break;
                case RIGHT:
                    if (i + 1 < table.length) {
                        table = Logic.moveBlock(table, j, i, d);
                        i++;
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
    
    public Direction getDirection() {
        return this.d;
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
