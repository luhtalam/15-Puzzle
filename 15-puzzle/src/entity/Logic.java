package Entity;

import java.util.Arrays;

/**
 * Luokka peliin liittyvää laskentaa ja siirtelyä varten.
 */
public class Logic {

    private static int multiplier = 2;

    /**
     * Staattinen metodi Manhattan Distancen laskentaan. Tässä tapauksessa
     * painotettu sellainen.
     *
     * @param table pelilauta, josta MD-lasketaan
     * @return pelitilanteen MD-arvo
     */
    public static int countManhattan(int[][] table) {
        int value = 0;
        int curr;
        int numb;
        int n = table.length;
        int m = table[0].length;
        int mod;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                numb = table[j][i];
                if (numb == n * n) {
                    continue;
                }
                curr = (int) Math.abs((long) Math.ceil(numb / (double) n) - j - 1);
                mod = numb % n;
                if (mod == 0) {
                    mod = n;
                }
                curr += Math.abs(mod - i - 1);
                value += multiplier * curr;
            }
        }
        return value;
    }

    /**
     *Laskee uudelle pelitilanteelle uuden Manhattan distancen optimaallisemmin.
     * @param oldTable Vanha pelitilanne
     * @param x tyhjän laatan x-koordinaatti
     * @param y tyhjän laatan y-koordinaatti
     * @param direction tyhjän laatan siirtosuunta
     * @return
     */
    public static int countManhattanDistanceDifference(int[][] oldTable, int x, int y, Direction direction) {
        int n = oldTable.length;
        int mod, numb;
        int old = 0, nEw = 0;
        switch (direction) {
            case UP:
                numb = oldTable[y - 1][x];
                old = (int) Math.abs((long) Math.ceil(numb / (double) n) - (y-1) - 1);
                nEw = (int) Math.abs((long) Math.ceil(numb / (double) n) - y - 1);
                break;
            case DOWN:
                numb = oldTable[y + 1][x];
                old = (int) Math.abs((long) Math.ceil(numb / (double) n) - (y+1) - 1);
                nEw = (int) Math.abs((long) Math.ceil(numb / (double) n) - y - 1);
                break;
            case LEFT:
                numb = oldTable[y][x - 1];
                mod = numb % n;
                if (mod == 0) {
                    mod = n;
                }
                old = Math.abs(mod - (x-1) - 1);
                nEw = Math.abs(mod - x - 1);
                break;
            case RIGHT:
                numb = oldTable[y][x + 1];
                mod = numb % n;
                if (mod == 0) {
                    mod = n;
                }
                old = Math.abs(mod - (x+1) - 1);
                nEw = Math.abs(mod - x - 1);
                break;
        }
        return multiplier* (nEw - old);
    }

    /**
     * Konstruoi uuden pelilaudan ja siirtää tyhjää ruutua.
     *
     * @param a pelilauta
     * @param x tyhjän laatan x-koordinaatti
     * @param y tyhjän laatan y-koordinaatti
     * @param direction siirtosuunta
     * @return uusi pelilauta, jossa tyhjää ruutua on siirretty
     */
    public static int[][] moveBlock(int[][] a, int x, int y, Direction direction) {
        int n = a.length;
        int[][] t = new int[n][n];
        for (int k = 0; k < n; k++) {
            t[k] = Arrays.copyOf(a[k], a[k].length);
        }
        switch (direction) {
            case UP:
                moveUp(t, x, y);
                break;
            case RIGHT:
                moveRight(t, x, y);
                break;
            case DOWN:
                moveDown(t, x, y);
                break;
            case LEFT:
                moveLeft(t, x, y);
                break;
        }
        return t;
    }

    /**
     *Päivittää 
     * @param oldY
     * @param d
     * @return
     */
    public static int updateY(int oldY, Direction d) {
        if (d == Direction.UP) {
            oldY--;
        } else if (d == Direction.DOWN) {
            oldY++;
        }
        return oldY;
    }

    /**
     *
     * @param oldX
     * @param d
     * @return
     */
    public static int updateX(int oldX, Direction d) {
        if (d == Direction.LEFT) {
            oldX--;
        } else if (d == Direction.RIGHT) {
            oldX++;
        }
        return oldX;
    }

    private static void moveUp(int[][] t, int x, int y) {
        int helper = t[y - 1][x];
        t[y - 1][x] = t[y][x];
        t[y][x] = helper;
    }

    private static void moveRight(int[][] t, int x, int y) {
        int helper = t[y][x + 1];
        t[y][x + 1] = t[y][x];
        t[y][x] = helper;

    }

    private static void moveDown(int[][] t, int x, int y) {
        int helper = t[y + 1][x];
        t[y + 1][x] = t[y][x];
        t[y][x] = helper;

    }

    private static void moveLeft(int[][] t, int x, int y) {
        int helper = t[y][x - 1];
        t[y][x - 1] = t[y][x];
        t[y][x] = helper;

    }

}
