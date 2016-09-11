/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luhtalam
 */
public class Game {
    private int[][] table;
    private int x; //tyhjän ruudun x-koordinaatti
    private int y; //tyhjän ruudun y-koordinaatti
    
    public Game(int x, int y) {
        this.table = new int[4][4];
        this.x = x;
        this.y = y;
    }

    public int[][] getTable() {
        return table;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }  
}
