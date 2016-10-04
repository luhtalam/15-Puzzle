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
        assertEquals(multiplier * 14, numb);
    }

    @Test
    public void testCountManhattanWorks4() {
        int[][] table = {{16, 15, 12, 7}, {8, 3, 10, 14}, {2, 11, 13, 6}, {9, 4, 5, 1}};
        int numb = Logic.countManhattan(table);
        assertEquals(multiplier * 46, numb);
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

    @Test
    public void testUpdateYUp() {
        int y = 2;
        int newY = Logic.updateY(y, Direction.UP);
        assertEquals(y - 1, newY);
    }

    @Test
    public void testUpdateYDown() {
        int y = 2;
        int newY = Logic.updateY(y, Direction.DOWN);
        assertEquals(y + 1, newY);
    }

    @Test
    public void testUpdateYLeft() {
        int y = 2;
        int newY = Logic.updateY(y, Direction.LEFT);
        assertEquals(y, newY);
    }

    @Test
    public void testUpdateYRight() {
        int y = 2;
        int newY = Logic.updateY(y, Direction.RIGHT);
        assertEquals(y, newY);
    }

    @Test
    public void testUpdateXLeft() {
        int x = 2;
        int newX = Logic.updateX(x, Direction.LEFT);
        assertEquals(x - 1, newX);
    }

    @Test
    public void testUpdateXRight() {
        int x = 2;
        int newX = Logic.updateX(x, Direction.RIGHT);
        assertEquals(x + 1, newX);
    }

    @Test
    public void testUpdateXUp() {
        int x = 2;
        int newX = Logic.updateX(x, Direction.UP);
        assertEquals(x, newX);
    }

    @Test
    public void testUpdateXDown() {
        int x = 2;
        int newX = Logic.updateX(x, Direction.DOWN);
        assertEquals(x, newX);
    }

    @Test
    public void testCountManhattanDifferenceUp1() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 16, 12}, {13, 14, 15, 11}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.UP);
        assertEquals(4, difference);
    }

    @Test
    public void testCountManhattanDifferenceDown1() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 16, 12}, {13, 14, 15, 11}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.DOWN);
        assertEquals(4, difference);
    }

    @Test
    public void testCountManhattanDifferenceLeft1() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 16, 12}, {13, 14, 15, 11}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.LEFT);
        assertEquals(4, difference);
    }

    @Test
    public void testCountManhattanDifferenceRight1() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 16, 12}, {13, 14, 15, 11}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.RIGHT);
        assertEquals(4, difference);
    }
    
    @Test
    public void testCountManhattanDifferenceUp2() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 11, 8}, {9, 10, 16, 12}, {13, 14, 15, 7}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.UP);
        assertEquals(-4, difference);
    }

    @Test
    public void testCountManhattanDifferenceDown2() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 16, 12}, {13, 14, 11, 15}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.DOWN);
        assertEquals(-4, difference);
    }

    @Test
    public void testCountManhattanDifferenceLeft2() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 11, 16, 12}, {13, 14, 15, 10}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.LEFT);
        assertEquals(-4, difference);
    }

    @Test
    public void testCountManhattanDifferenceRight2() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 16, 11}, {13, 14, 15, 12}};
        int difference = Logic.countManhattanDistanceDifference(table, 2, 2, Direction.RIGHT);
        assertEquals(-4, difference);
    }
}
