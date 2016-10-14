package DataStructures;

import Entity.Game;

/**
 *Pino-tietorakenne pelin ratkaisuun vaadittujen siirtojen tulostamista varten.
 */
public class Stack {
    
    private Game[] stack;
    private int stackSize;
    
    /**
     *Konstruktori.
     */
    public Stack() {
        this.stack = new Game[150];
        this.stackSize = 0;
    }
    
    /**
     *Lisää pinon päälimmäiseksi uuden pelitilanteen.
     * @param game lisättävä pelitilanne.
     */
    public void push(Game game) {
        if (stackSize == stack.length) {
            doubleSize();
        }
        this.stack[stackSize] = game;
        this.stackSize++;
    }
    
    /**
     *Poistaa pinosta päällimmäisen pelitilanteen.
     * @return päälimmäinen pelitilanne
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
     *Tarkistaa onko pino tyhjä.
     * @return totuusarvo siitä, onko pino tyhjä vai ei.
     */
    public boolean empty() {
        if (stackSize <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return pinon sen hetkinen koko.
     */
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
