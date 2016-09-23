
import java.util.Arrays;

/**
 * Luokka peliin liittyvää laskentaa ja siirtelyä varten. Eriytetään kadeksi
 * luokaksi Movement ja Counter myöhemmin.
 */
public class Logic {

    /**
     * Staattinen metodi Manhattan Distancen laskentaan. Tässä tapauksessa
     * painotettu sellainen
     *
     * @param table pelilauta, josta MD-lasketaan
     * @return pelitilanteen MD-arvo
     */
    public static int countManhattan(int[][] table) { // Määritä raja milloin painotettu on parempi
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
                value += 2 * curr; //optimaallisempi tulos mutta paljon hitaampi, toimii painotettua 
                //paremmin "helpoilla" syötteillä, 2 kertominen nopeuttaa suunnattomasti
                //ja tarjoaa optimaalisen tulosen - 1.2*optimi
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
     * @param j tyhjän ruudun y-koordinaatti
     * @param i tyhjän ruudun x-koordinaatti
     * @param d siirtosuunta
     * @return uusi pelilauta, jossa tyhjää ruutua on siirretty
     */
    public static int[][] moveBlock(int[][] a, int j, int i, Direction d) {
        int n = a.length;
        int[][] t = new int[n][n];
        for (int k = 0; k < n; k++) {
            t[k] = Arrays.copyOf(a[k], a[k].length);
        }
        switch (d) {
            case UP: // lisää if-rakenne tarkistamaan voiko siirtää.
                if (j - 1 >= 0) {
                    moveUp(t, j, i);
                }
                break;
            case RIGHT:
                if (i + 1 < t[0].length) {
                    moveRight(t, j, i);
                }
                break;
            case DOWN:
                if (j + 1 < t.length) {
                    moveDown(t, j, i);
                }
                break;
            case LEFT:
                if (i - 1 >= 0) {
                    moveLeft(t, j, i);
                }
                break;
        }
        return t;
    }

    private static void moveUp(int[][] t, int j, int i) {
        int helper = t[j - 1][i];
        t[j - 1][i] = t[j][i];
        t[j][i] = helper;
    }

    private static void moveRight(int[][] t, int j, int i) {

        int helper = t[j][i + 1];
        t[j][i + 1] = t[j][i];
        t[j][i] = helper;

    }

    private static void moveDown(int[][] t, int j, int i) {

        int helper = t[j + 1][i];
        t[j + 1][i] = t[j][i];
        t[j][i] = helper;

    }

    private static void moveLeft(int[][] t, int j, int i) {

        int helper = t[j][i - 1];
        t[j][i - 1] = t[j][i];
        t[j][i] = helper;

    }

}
