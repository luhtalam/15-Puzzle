/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    int[][] table;
    int i;
    int j;

    @Before
    public void setUp() {
        int[][] t = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        this.table = t;
        i = 3;
        j = 3;
    }

    @Test
    public void testMoveBlockUpMovesBlock() {
        int[][] t = Logic.moveBlock(table, j, i, Direction.UP);
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t.length; i++) {
                if (this.i == i && (this.j == j || j == this.j - 1)) {
                    continue;
                } else {
                    assertEquals(table[j][i], t[j][i]);
                }
            }

        }
        assertEquals(table[j - 1][i], t[j][i]);
        assertEquals(table[j][i], t[j - 1][i]);
    }

    @Test
    public void testMoveBlocDownMovesBlock() {
        int[][] t = Logic.moveBlock(table, j, i, Direction.UP);
        t = Logic.moveBlock(t, j-1, i, Direction.DOWN);
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t.length; i++) {

                assertEquals(table[j][i], t[j][i]);

            }

        }
    }
}
