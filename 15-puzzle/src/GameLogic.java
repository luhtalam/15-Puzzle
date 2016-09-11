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

    public static boolean isReady(Game game) {
        int[][] table = game.getTable();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (j == 4 && i == 3 && table[j][i] != 0) {
                    return false;
                }
                if (table[j][i] != (j * 4) + i + 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
