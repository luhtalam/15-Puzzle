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
    private int value;

    /**
     *
     */
    public int Manhattan;

    /**
     *
     */
    public Direction d; // suunta josta tilanteeseen on tultu

    /**
     *
     */
    public int moves;
    
    /**
     *
     * @param table
     * @param x
     * @param y
     * @param manhattan
     * @param value
     * @param d
     * @param moves
     */
    public Game(int[][] table, int x, int y,int manhattan, int value, Direction d, int moves) {
        this.table = table;
        this.x = x;
        this.y = y;
        this.d = d;
        this.Manhattan = manhattan;
        this.value = value;
        this.moves = moves;
    }

    /**
     *
     * @return
     */
    public int[][] getTable() {
        return table;
    }
    
    /**
     *
     * @param t
     */
    public void setTable(int[][] t) {
        this.table = t;
    }
    
    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }  

    @Override
    public int compareTo(Game o) {
//        return this.Manhattan - o.Manhattan;
        return this.value- o.value;
    }
}
