package entity;


import java.util.Arrays;

/**
 * Luokka peliin liittyvää laskentaa ja siirtelyä varten. Eriytetään kadeksi
 * luokaksi Movement ja Counter myöhemmin.
 */
public class Logic {
    
    private static int multiplier = 4;

    /**
     * Staattinen metodi Manhattan Distancen laskentaan. Tässä tapauksessa
     * painotettu sellainen
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
                value += multiplier * curr; //optimaallisempi tulos mutta hitaampi, toimii painotettua 
                //paremmin "helpoilla" syötteillä, 2 kertominen nopeuttaa suunnattomasti
                //ja tarjoaa optimaalisen tuloksen - 1.2*optimi.
                //Hae kokeilemalla sopiva kerroin!!

//                value += curr * ((n - i) + (n - j)); //ei anna kovin optimaallista vastausta, 
                //mutta ratkaisee nopeasti
            }
        }
        return value;
    }

    /**
     * Konstruoi uuden pelilaudan ja siirtää tyhjää ruutua.
     *
     * @param a pelilauta
     * @param x
     * @param y
     * @param d siirtosuunta
     * @return uusi pelilauta, jossa tyhjää ruutua on siirretty
     */
    public static int[][] moveBlock(int[][] a, int x, int y, Direction d) {
        int n = a.length;
        int[][] t = new int[n][n];
        for (int k = 0; k < n; k++) {
            t[k] = Arrays.copyOf(a[k], a[k].length);
        }
        switch (d) {
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
