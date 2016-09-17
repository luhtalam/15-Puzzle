
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
        int[][] h1 = {{16,12,9,13},{15,11,10,14},{3,7,6,2},{4,8,5,1}};
        int[][] h2 = {{16,12,9,13}, {15,11,10,14}, {7,8,5,6}, {4,3,2,1}};
        int[][] b = {{4,13,7,2},{1,16,8,12},{3,9,5,14},{11,6,10,15}};
        int[][] a = {{2, 1, 5, 4}, {11, 6, 3, 7}, {10, 13, 15, 12}, {9, 14, 8, 16}};
        int[][] t = {{6, 4, 7}, {8, 5, 9}, {3, 2, 1}};
        System.out.println("");
        solve(h1, 0, 0);

    }

    static void solve(int[][] t, int x, int y) { 
        PriorityQueue<Game> q = new PriorityQueue<Game>();
        int value = Logic.countManhattan(t);
        System.out.println("Manhattan: " + value);
        q.add(new Game(t, x, y, value, value, null, 0));
        int minV;
        int n = t.length;
        int[][] a;
        int i = 1;
        int numb;
        long start = System.currentTimeMillis();
        while (true) {
            Game g = q.poll();
            minV = Integer.MAX_VALUE;
            if (g.getY() - 1 >= 0 && g.d != Direction.DOWN) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.UP);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.UP);
                q.add(new Game(a, g.getX(), g.getY() - 1, value, value + g.moves + 1, Direction.UP, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (g.getY() + 1 < n && g.d != Direction.UP) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.DOWN);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.DOWN);
                q.add(new Game(a, g.getX(), g.getY() + 1, value, value + g.moves + 1, Direction.DOWN, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (g.getX() - 1 >= 0 && g.d != Direction.RIGHT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.LEFT);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.LEFT);
                q.add(new Game(a, g.getX() - 1, g.getY(), value, value + g.moves + 1, Direction.LEFT, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (g.getX() + 1 < n && g.d != Direction.LEFT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.RIGHT);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.RIGHT);
                q.add(new Game(a, g.getX() + 1, g.getY(), value, value  + g.moves + 1, Direction.RIGHT, g.moves + 1));
                minV = Math.min(value, minV);
            }
            if (minV == 0) {
                System.out.println("ratkaisu löytyi");
                System.out.println("nostoja keosta: " + i);
                System.out.println("siirtoja: " + (g.moves + 1));
                System.out.println("Käytetty aika: " +(System.currentTimeMillis() - start));
                print(g.getTable());
                break;
            }

            i++;

        }
    }

    static void print(int[][] t) {
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t[0].length; i++) {
                System.out.printf("%2d ", t[j][i]);
            }
            System.out.println("");
        }
    }

}
