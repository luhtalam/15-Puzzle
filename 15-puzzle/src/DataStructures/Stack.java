package DataStructures;

import Entity.Game;

public class Stack {
    
    private Game[] stack;
    private int stackSize;
    
    public Stack() {
        this.stack = new Game[150];
        this.stackSize = 0;
    }
    
    public void push(Game game) {
        if (stackSize == stack.length) {
            doubleSize();
        }
        this.stack[stackSize] = game;
        this.stackSize++;
    }
    
    public Game pop() {
        if (stackSize <= 0) {
            return null;
        } else {
            stackSize--;
            return this.stack[stackSize];
        }        
    }
    
    public boolean empty() {
        if (stackSize <= 0) {
            return true;
        } else {
            return false;
        }
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
