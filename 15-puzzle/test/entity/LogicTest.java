package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.Direction;
import Entity.Logic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luhtalam
 */
public class LogicTest {
    
    int multiplier = 4;
    
    @Test
    public void testCountManhattanWorks1() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int numb = Logic.countManhattan(table);
        assertEquals(0, numb);
    }
    
    @Test
    public void testCountManhattanWorks2() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 16, 15}};
        int numb = Logic.countManhattan(table);
        assertEquals(multiplier * 1, numb);
    }
    
    @Test
    public void testCountManhattanWorks3() {
        int[][] table = {{1, 4, 2, 3}, {6, 7, 5, 8}, {10, 11, 9, 12}, {13, 15, 14, 16}};
        int numb = Logic.countManhattan(table);
        assertEquals(multiplier * 14 , numb);
    }
    
    @Test
    public void testCountManhattanWorks4() {
        int[][] table = {{16, 15, 12, 7}, {8, 3, 10, 14}, {2, 11, 13, 6}, {9, 4, 5, 1}};
        int numb = Logic.countManhattan(table);
        assertEquals(multiplier * 46 , numb);
    }
    
    @Test
    public void testMoveBlockToUpWorks() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int y = 3;
        int x = 3;
        table = Logic.moveBlock(table, x, y, Direction.UP);
        int[][] t = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 16}, {13, 14, 15, 12}};
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t.length; i++) {

                assertEquals(table[j][i], t[j][i]);
            }
        }
    }

    @Test
    public void testMoveBlocToDownWorks() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 16}, {13, 14, 15, 12}};
        int y = 2;
        int x = 3;
        table = Logic.moveBlock(table, x, y, Direction.DOWN);
        int[][] t = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t.length; i++) {
                assertEquals(table[j][i], t[j][i]);
            }
        }
    }

    @Test
    public void testMoveBlockToLeftWorks() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int y = 3;
        int x = 3;
        table = Logic.moveBlock(table, x, y, Direction.LEFT);
        int[][] t = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 16, 15}};
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t.length; i++) {
                assertEquals(table[j][i], t[j][i]);
            }
        }
    }
    
    @Test
    public void testMoveBlockToRightWorks() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 16, 15}};
        int y = 3;
        int x = 2;
        table = Logic.moveBlock(table, x, y, Direction.RIGHT);
        int[][] t = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t.length; i++) {
                assertEquals(table[j][i], t[j][i]);
            }
        }
    }
}
