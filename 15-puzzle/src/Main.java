
import java.util.HashSet;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue<Game> q = new PriorityQueue<Game>();
        int[][] t = {{7, 9, 3}, {1, 8, 5}, {2, 4, 6}};
        int value = Logic.countManhattan(t);
        q.add(new Game(t, 1, 0, value, value, null, 0));
        int minV;
        int[][] a;
        int i = 1;
        int numb;
        long start = System.currentTimeMillis();
        while (true) {
            Game g = q.poll();
            minV = Integer.MAX_VALUE;
            if (g.getY() - 1 >= 0 && g.d != Direction.DOWN) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.UP);
//                value = Logic.countManhattan(a);
                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.UP);
                q.add(new Game(a, g.getX(), g.getY() - 1, value, value + g.moves + 1, Direction.UP, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (g.getY() + 1 < 3 && g.d != Direction.UP) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.DOWN);
//                value = Logic.countManhattan(a);
                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.DOWN);
                q.add(new Game(a, g.getX(), g.getY() + 1, value, value + g.moves + 1, Direction.DOWN, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (g.getX() - 1 >= 0 && g.d != Direction.RIGHT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.LEFT);
//                value = Logic.countManhattan(a);
                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.LEFT);
                q.add(new Game(a, g.getX() - 1, g.getY(), value, value + g.moves + 1, Direction.LEFT, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (g.getX() + 1 < 3 && g.d != Direction.LEFT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.RIGHT);
//                value = Logic.countManhattan(a);
                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.RIGHT);
                q.add(new Game(a, g.getX() + 1, g.getY(), value, value + g.moves + 1, Direction.RIGHT, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (minV == 0) {
                System.out.println("ratkaisu löytyi");
                System.out.println(i);
                System.out.println(g.moves + 1);
                break;
            }

            i++;

        }
        System.out.println(System.currentTimeMillis() - start);
    }

    static void print(int[][] t) {
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t[0].length; i++) {
                System.out.print(t[j][i] + " ");
            }
            System.out.println("");
        }
    }

}
