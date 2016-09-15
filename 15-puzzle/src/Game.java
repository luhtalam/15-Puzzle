/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luhtalam
 */
public class Game implements Comparable<Game>{
    private int[][] table;
    private int x; //tyhjän ruudun x-koordinaatti
    private int y; //tyhjän ruudun y-koordinaatti
    private int value = Integer.MAX_VALUE;
    public Direction d; // suunta josta tilanteeseen on tultu
    public int moves;
    
    public Game(int[][] table, int x, int y, int value, Direction d, int moves) {
        this.table = table;
        this.x = x;
        this.y = y;
        this.d = d;
        this.value = value;
        this.moves = moves;
    }

    public int[][] getTable() {
        return table;
    }
    
    public int getValue() {
        return value;
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
    
    public void setValue(int value) {
        this.value = value;
    }

    public void setY(int y) {
        this.y = y;
    }  

    @Override
    public int compareTo(Game o) {
        if (this.value > o.value) return 1;
        if(this.value < o.value) return -1;
        return 0;
    }
}
