
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

    public static int countManhattan(int[][] table) {
        int value = 0;
        int numb;
        int mod;
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                numb = table[j][i];
                if (numb == 9) {
                    continue;
                }
                value += Math.abs((long) Math.ceil(numb / 3.0) - j - 1);
                mod = numb % 3;
                if (mod == 0) {
                    mod = 3;
                }
                value += Math.abs(mod - i - 1);

            }
        }
        return value;
    }

    public static int countNewManhattan(int[][] t, int old, int j, int i, Direction d) {
        int numb = t[j][i];
        int value, mod;
        switch (d) {
            case UP:
                value = old - (int) Math.abs(Math.ceil(numb / 3.0) - (j - 1) - 1);
                value += (int) Math.abs(Math.ceil(numb / 3.0) - j - 1);
                return value;
            case DOWN:
                value = old - (int) Math.abs(Math.ceil(numb / 3.0) - (j + 1) - 1);
                value += (int) Math.abs(Math.ceil(numb / 3.0) - j - 1);
                return value;
            case LEFT:
                mod = numb % 3;
                if (mod == 0) {
                    mod = 3;
                }
                value = old - Math.abs(mod - (i -1) - 1);
                value += Math.abs(mod - i - 1);
                return value;
            case RIGHT:
                mod = numb % 3;
                if (mod == 0) {
                    mod = 3;
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
        int[][] t = new int[3][3];
        for (int k = 0; k < 3; k++) {
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
