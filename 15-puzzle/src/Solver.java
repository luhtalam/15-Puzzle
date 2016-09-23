
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luhtalam
 */
public class Solver {
    
    
    public void solve(Game game) {
        PriorityQueue<Game> q = new PriorityQueue<Game>();
        int value = game.getValue();
        System.out.println("Manhattan: " + value);
        q.add(game);
        int n = game.getTable().length;
        int[][] a;
        int i = 1;
        int numb;
        long start = System.currentTimeMillis();
        while (true) {
            Game g = q.poll();

            if (g.getValue() - g.moves == 0) {
                System.out.println("ratkaisu löytyi");
                System.out.println("nostoja keosta: " + i);
                System.out.println("siirtoja: " + g.moves);
                System.out.println("Käytetty aika: " + (System.currentTimeMillis() - start) + " ms");
                print(g.getTable());
                break;
            }

            if (g.getY() - 1 >= 0 && g.d != Direction.DOWN) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.UP);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX(), g.getY() - 1, value + g.moves + 1, Direction.UP, g.moves + 1));
            }
            if (g.getY() + 1 < n && g.d != Direction.UP) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.DOWN);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX(), g.getY() + 1, value + g.moves + 1, Direction.DOWN, g.moves + 1));
            }
            if (g.getX() - 1 >= 0 && g.d != Direction.RIGHT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.LEFT);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX() - 1, g.getY(), value + g.moves + 1, Direction.LEFT, g.moves + 1));
            }
            if (g.getX() + 1 < n && g.d != Direction.LEFT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.RIGHT);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX() + 1, g.getY(), value + g.moves + 1, Direction.RIGHT, g.moves + 1));
            }

            i++;

        }
    }
    
     public void print(int[][] t) {
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t[0].length; i++) {
                System.out.printf("%2d ", t[j][i]);
            }
            System.out.println("");
        }
    }
}
