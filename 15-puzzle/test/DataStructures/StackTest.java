/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import DataStructures.Stack;
import Entity.Game;

public class StackTest {

    @Test
    public void testPopReturnNullWhenEmpty() {
        Stack stack = new Stack();
        assertNull(stack.pop());
    }

    @Test
    public void testEmptyReturnTrueWhenEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.empty());
    }

    @Test
    public void testEmptyReturnFalseWhenNotEmpty() {
        Stack stack = new Stack();
        stack.push(new Game(4));
        assertFalse(stack.empty());
    }

    @Test
    public void testPushOnePopSame() {
        Stack stack = new Stack();
        Game game = new Game(4);
        stack.push(game);
        assertEquals(game, stack.pop());
    }

    @Test
    public void testAddThreeReturnRightOrder() {
        Stack stack = new Stack();
        Game game1 = new Game(4);
        Game game2 = new Game(4);
        Game game3 = new Game(4);
        stack.push(game3);
        stack.push(game1);
        stack.push(game2);
        assertEquals(game2, stack.pop());
        assertEquals(game1, stack.pop());
        assertEquals(game3, stack.pop());
    }
    
    @Test
    public void testCannotReturnMoreElementsThanHaveAdded() {
        Stack stack = new Stack();
        Game game1 = new Game(4);
        Game game2 = new Game(4);
        Game game3 = new Game(4);
        stack.push(game3);
        stack.push(game1);
        stack.push(game2);
        stack.pop();
        stack.pop();
        stack.pop();
        assertNull(stack.pop());
    }
    
    @Test
    public void testGetSizeReturnZeroWhenEmpty1() {
        Stack stack = new Stack();
        assertEquals(0, stack.getSize());
    }
    
    @Test
    public void testGetSizeReturnZeroWhenEmptyAgain1() {
        Stack stack = new Stack();
        stack.push(new Game(4));
        stack.pop();
        assertEquals(0, stack.getSize());
    }
    
    @Test
    public void testGetSizeReturnZeroWhenEmptyAgain2() {
        Stack stack = new Stack();
        stack.push(new Game(4));
        stack.pop();
        assertEquals(0, stack.getSize());
        stack.push(new Game(4));
        stack.push(new Game(4));
        stack.pop();
        stack.pop();
        assertEquals(0, stack.getSize());      
    }
    
    @Test
    public void testGetSizeReturnRightWhenNotEmpty1() {
        Stack stack = new Stack();
        stack.push(new Game(4));
        assertEquals(1, stack.getSize());
    }
    
    @Test
    public void testGetSizeReturnRightWhenNotEmpty2() {
        Stack stack = new Stack();
        stack.push(new Game(4));
        stack.push(new Game(4));
        assertEquals(2, stack.getSize());
    }
    
    @Test
    public void testGetSizeReturnRightWhenNotEmpty3() {
        Stack stack = new Stack();
        stack.push(new Game(4));
        stack.push(new Game(4));
        stack.pop();
        stack.push(new Game(4));
        stack.push(new Game(4));
        stack.pop();
        stack.push(new Game(4));
        assertEquals(3, stack.getSize());
    }

}
