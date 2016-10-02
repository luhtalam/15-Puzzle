/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import DataStructures.MinHeap;
import entity.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinHeapTest {
    
    @Test
    public void testEmptyHeapReturnNull() {
        MinHeap heap = new MinHeap();
        assertNull(heap.poll());
    }

    @Test
    public void testAddOneReturnSame() {
        Game g = new Game(4);
        MinHeap heap = new MinHeap();
        heap.add(g);
        assertEquals(g, heap.poll());
    }
    
    @Test
    public void testAfterAddingOneNotReturnNull() {
        Game g = new Game(4);
        MinHeap heap = new MinHeap();
        heap.add(g);
        assertNotNull(heap.poll());
    }
    
    @Test
    public void testHeapReturnNullWhenEmptyAgain() {
        MinHeap heap = new MinHeap();
        Game g = new Game(4);
        heap.add(g);
        heap.poll();
        assertNull(heap.poll());
    }

    @Test
    public void testAddTwoReturnGamesInRightOrder() {
        int[][] table1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 16, 15}};
        Game game1 = new Game(table1, 3, 3, 0, null);
        Game game2 = new Game(table2, 2, 3, 0, null);
        MinHeap heap = new MinHeap();
        heap.add(game2);
        heap.add(game1);
        assertEquals(game1, heap.poll());
        assertEquals(game2, heap.poll());
    }

    @Test
    public void testAddThreeReturnGamesInRightOrder() {
        int[][] table1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 16, 15}};
        int[][] table3 = {{16, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 1}};
        Game game1 = new Game(table1, 3, 3, 0, null);
        Game game2 = new Game(table2, 2, 3, 0, null);
        Game game3 = new Game(table3, 0, 0, 0, null);
        MinHeap heap = new MinHeap();
        heap.add(game2);
        heap.add(game1);
        heap.add(game3);
        assertEquals(game1, heap.poll());
        assertEquals(game2, heap.poll());
        assertEquals(game3,heap.poll());
    }
}
