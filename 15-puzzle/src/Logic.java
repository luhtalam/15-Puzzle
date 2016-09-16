
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luhtalam
 */
public class Logic { 

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
                if (numb == n*n) {
                    continue;
                }
                curr = (int) Math.abs((long) Math.ceil(numb / (double) n) - j - 1);
                mod = numb %  n;
                if (mod == 0) {
                    mod = n;
                }
                curr += Math.abs(mod - i - 1);
                value += curr; //optimaallisempi tulos mutta paljon hitaampi, toimii painotettua 
                                    //paremmin "helpoilla" syötteillä
//                value += curr * ((n - i) +(n -j)); //ei anna kovin optimaallista vastausta, 
                                                    //mutta ratkaisee "haastavat" tehokkaasti

            }
        }
        return value;
    }

    public static int countNewManhattan(int[][] t, int old, int j, int i, Direction d) {
        int numb = t[j][i];
        int value, mod;
        double div = (double) t.length;
        switch (d) {
            case UP:
                value = old - (int) Math.abs(Math.ceil(numb / div) - (j - 1) - 1);
                value += (int) Math.abs(Math.ceil(numb / div) - j - 1);
                return value;
            case DOWN:
                value = old - (int) Math.abs(Math.ceil(numb / div) - (j + 1) - 1);
                value += (int) Math.abs(Math.ceil(numb / div) - j - 1);
                return value;
            case LEFT:
                mod = numb % (int)div;
                if (mod == 0) {
                    mod = (int) div;
                }
                value = old - Math.abs(mod - (i -1) - 1);
                value += Math.abs(mod - i - 1);
                return value;
            case RIGHT:
                mod = numb % (int) div;
                if (mod == 0) {
                    mod = (int) div;
                }
                value = old - Math.abs(mod - (i +1) - 1);
                value += Math.abs(mod - i - 1);
                return value;
        }
        return 0;
    }

    public static int countMisplacedTiles(int[][] table) {
        int value = 0;
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                if (table[j][i] != j * 3 + i + 1) {
                    value++;
                }
            }
        }
        return value;
    }

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