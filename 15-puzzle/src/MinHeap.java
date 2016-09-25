

/**
 *
 * @author luhtalam
 */
public class MinHeap {

    Game[] gameHeap;
    int heapSize;
    int tableLength;

    /**
     *
     */
    public MinHeap() {
        this.gameHeap = new Game[201];
        this.tableLength = 200;
        this.heapSize = 0;
    }
    
    /**
     *
     * @param game
     */
    public void add(Game game) {
        
    }
    
    /**
     *
     */
    public void deleteMin() {
        
    }
    
    private void heapify(int idx) {
        
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

}
