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
                    value += Math.abs((long) Math.ceil(numb / 3.0) -j -1);
                    mod = numb % 3;
                    if (mod == 0) {
                        value += Math.abs(2 - i);
                    } else {
                        value += Math.abs(mod - i - 1);
                    }
            }
        }
        return value;
    }
    
    public static int countMisplacedTiles(int[][] table) {
        int value = 0;
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                if (table[j][i] != j*3 + i+1) {
                    value ++;
                }
            }
        }
        return value;
    }
    
    public static int[][] moveBlock(Game game, Direction d) {
        int[][] t = game.getTable();
        int j = game.getY();
        int i = game.getX();
        switch (d) {
            case UP: // lisää if-rakenne tarkistamaan voiko siirtää.
                if (j - i >= 0) {
                    moveUp(game);
                }
                break;
            case RIGHT:
                if (i + 1 < t[0].length) {
                    moveRight(game);
                }
                break;
            case DOWN:
                if (j + 1 < t.length) {
                    moveDown(game);
                }
                break;
            case LEFT:
                if (i - 1 >= 0) {
                    moveLeft(game);
                }
                break;
        }
        return t;
    }
    
    private static void moveUp(Game game) {
        int[][] t = game.getTable();
        int j = game.getY();
        int i = game.getX();
        int helper = t[j - 1][i];
        t[j - 1][i] = t[j][i];
        t[j][i] = helper;
        game.setY(j - 1);
    }
    
    private static void moveRight(Game game) {
        int[][] t = game.getTable();
        int j = game.getY();
        int i = game.getX();
        int helper = t[j][i + 1];
        t[j][i + 1] = t[j][i];
        t[j][i] = helper;
        game.setX(i + 1);
    }
    
    private static void moveDown(Game game) {
        int[][] t = game.getTable();
        int j = game.getY();
        int i = game.getX();
        int helper = t[j + 1][i];
        t[j + 1][i] = t[j][i];
        t[j][i] = helper;
        game.setY(j + 1);
    }
    
    private static void moveLeft(Game game) {
        int[][] t = game.getTable();
        int j = game.getY();
        int i = game.getX();
        int helper = t[j][i - 1];
        t[j][i - 1] = t[j][i];
        t[j][i] = helper;
        game.setX(i - 1);
    }

    // Lisää metodit moveUp, moveDown....
}
