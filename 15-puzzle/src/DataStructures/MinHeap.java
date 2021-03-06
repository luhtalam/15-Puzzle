package DataStructures;

import Entity.Game;

/**
 * Minimikeko tietorakenne eri pelitilanteiden keskinäistä järjestämistä varten.
 * Keon päällimmäisenä sen hetkisistä pelitilanteista optimaallisin.
 */
public class MinHeap {

    private Game[] heap;
    private int heapSize;
    private int heapLength;

    /**
     * Konstruktori minimikekoa varten.
     */
    public MinHeap() {
        int n = 10000;
        this.heap = new Game[n + 1];
        this.heapLength = n;
        this.heapSize = 0;
    }

    /**
     * Metodi pelitilanteen lisäämiseksi kekoon.
     *
     * @param game Pelitilanne, joka lisätään kekoon
     */
    public void add(Game game) {
        int value = game.getValue();
        this.heapSize++;
        if (heapSize > this.heapLength) {
            doubleHeapLength();
        }
        int idx = this.heapSize;
        while (idx > 1 && value(parent(idx)) > value) {
            heap[idx] = heap[parent(idx)];
            idx = parent(idx);
        }
        heap[idx] = game;
    }

    /**
     * Metodi, joka palauttaa ja poistaa sillä hetkellä optimaallisimman
     * pelitilanteen keosta.
     *
     * @return keon päällimmäisenä oleva pelitilanne.
     */
    public Game poll() {
        if (this.heapSize == 0) {
            return null;
        }
        Game g = heap[1];
        heap[1] = heap[this.heapSize];
        this.heapSize--;
        heapify(1);
        return g;
    }
    
    /**
     * @return keon sen hetkinen koko
     */
    public int getHeapSize() {
        return this.heapSize;
    }

    private void heapify(int idx) {
        int r = right(idx);
        int l = left(idx);
        int smallest;
        if (r <= this.heapSize) {
            if (value(l) < value(r)) {
                smallest = l;
            } else {
                smallest = r;
            }
            if (value(idx) > value(smallest)) {
                change(idx, smallest);
                heapify(smallest);
            }
        } else if (l == this.heapSize && value(idx) > value(l)) {
            change(idx, l);
        }
    }

    private void change(int idx1, int idx2) {
        Game g = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = g;
    }

    private int value(int idx) {
        return this.heap[idx].getValue();
    }

    private int parent(int idx) {
        return idx / 2;
    }

    private int left(int idx) {
        return 2 * idx;
    }

    private int right(int idx) {
        return 2 * idx + 1;
    }

    private void doubleHeapLength() {
        Game[] newHeap = new Game[this.heapLength * 2 + 1];
        for (int i = 1; i <= this.heapLength; i++) {
            newHeap[i] = this.heap[i];
        }
        this.heap = newHeap;
        this.heapLength *= 2;
    }
}
