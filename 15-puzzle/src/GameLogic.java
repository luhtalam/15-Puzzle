/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luhtalam
 */
public class GameLogic {

    public static int countValue(int[][] table) {
        int value = 0;
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                
            }
        }
        return value;
    }
    
    public static int[][] moveBlock(Game game, Direction d) {
        int[][] t = game.getTable();
        int j = game.getY();
        int i = game.getY();
        int helper;
        switch(d) {
            case UP:
                helper = t[j -1][i];
                t[j-1][i] = t[j][i];
                t[j][i] = helper;
                break;
            case RIGHT:
                helper = t[j][i +1];
                t[j][i+1] = t[j][i];
                t[j][i] = helper;
                break;
            case DOWN:
                helper = t[j +1][i];
                t[j+1][i] = t[j][i];
                t[j][i] = helper;
                break;
            case LEFT:
                helper = t[j][i -1];
                t[j][i-1] = t[j][i];
                t[j][i] = helper;
                break;
        }
    }

}
