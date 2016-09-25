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
public class GameTest {
    
    @Test
    public void testRandomConstructorSetsTableDimensionsRight1() {
        Game g = new Game(4);
        assertEquals(4,g.getTable().length);
        assertEquals(4, g.getTable()[0].length);
    }
    
    @Test
    public void testRandomConstructorSetsTableDimensionsRight2() {
        Game g = new Game(3);
        assertEquals(3,g.getTable().length);
        assertEquals(3, g.getTable()[0].length);
    }
    
    @Test
    public void testRandomConstructorSetsCoordinatesRight1() {
        Game g = new Game(4);
        int x = g.getX();
        int y = g.getY();
        assertEquals(16, g.getTable()[y][x]);
    }
    
    @Test
    public void testRandomConstructorSetsCoordinatesRight2() {
        Game g = new Game(3);
        int x = g.getX();
        int y = g.getY();
        assertEquals(9, g.getTable()[y][x]);
    }
}
