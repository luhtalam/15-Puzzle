package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entity.Game;
import Entity.Direction;
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

    int multiplier = 4;

    @Test
    public void testRandomConstructorSetsTableDimensionsRight1() {
        Game g = new Game(4);
        assertEquals(4, g.getTable().length);
        assertEquals(4, g.getTable()[0].length);
    }

    @Test
    public void testRandomConstructorSetsTableDimensionsRight2() {
        Game g = new Game(3);
        assertEquals(3, g.getTable().length);
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

    @Test
    public void testConstructorWithTableSetsCoordinatesRight() {
        int[][] table = {{1, 2, 4, 3}, {5, 7, 16, 8}, {9, 10, 11, 12}, {13, 14, 15, 6}};
        Game game = new Game(table);
        assertEquals(game.getX(), 2);
        assertEquals(game.getY(), 1);
    }

    @Test
    public void testConstructorWithTableCountValueRight() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 16, 15}};
        Game game = new Game(table);
        assertEquals(multiplier * 1, game.getValue());
    }

    @Test
    public void testConstructorWithGameCountsValueRight() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Game game1 = new Game(table);
        Game game2 = new Game(game1, Direction.UP);
        assertEquals(multiplier * 1 + 1, game2.getValue());
    }

    @Test
    public void testConstructorWithGameSetsMovesRight1() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Game game1 = new Game(table);
        Game game2 = new Game(game1, Direction.UP);
        assertEquals(1, game2.getMoves());
    }

    @Test
    public void testConstructorWithGameSetsMovesRight2() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Game game1 = new Game(table);
        Game game2 = new Game(game1, Direction.UP);
        Game game3 = new Game(game2, Direction.LEFT);
        assertEquals(2, game3.getMoves());
    }

    @Test
    public void testConstructorWithGameSetsParentRight() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Game game1 = new Game(table);
        Game game2 = new Game(game1, Direction.UP);
        assertEquals(game1, game2.getParent());
    }
}
