package DataStructures;

import Entity.Game;

/**
 *
 * @author luhtalam
 */
public class Stack {
    
    private Game[] stack;
    private int stackSize;
    
    /**
     *
     */
    public Stack() {
        this.stack = new Game[150];
        this.stackSize = 0;
    }
    
    /**
     *
     * @param game
     */
    public void push(Game game) {
        if (stackSize == stack.length) {
            doubleSize();
        }
        this.stack[stackSize] = game;
        this.stackSize++;
    }
    
    /**
     *
     * @return
     */
    public Game pop() {
        if (stackSize <= 0) {
            return null;
        } else {
            stackSize--;
            return this.stack[stackSize];
        }        
    }
    
    /**
     *
     * @return
     */
    public boolean empty() {
        if (stackSize <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getSize() {
        return this.stackSize;
    }
    
    private void doubleSize() {
        int n = stack.length;
        Game[] newStack = new Game[2*n];
        for(int i = 0; i < n; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }
}
