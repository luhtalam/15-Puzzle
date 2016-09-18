
import java.util.PriorityQueue;
import java.util.Random;

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
        int[][] h1 = {{16, 12, 9, 13}, {15, 11, 10, 14}, {3, 7, 6, 2}, {4, 8, 5, 1}};
        int[][] h2 = {{16, 12, 9, 13}, {15, 11, 10, 14}, {7, 8, 5, 6}, {4, 3, 2, 1}};
        int[][] t = {{6, 4, 7}, {8, 5, 9}, {3, 2, 1}};
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Game g = new Game(a, 3, 3, 0, 0, null, 0);
        g = initGame(g);
        print(g.getTable());
        System.out.println("value: " + g.getValue());
        System.out.println("j: " + g.getY());
        System.out.println("i: " + g.getX());
        solve(g.getTable(), g.getX(), g.getY());

    }

    static void solve(int[][] t, int x, int y) {
        PriorityQueue<Game> q = new PriorityQueue<Game>();
        int value = Logic.countManhattan(t);
        System.out.println("Manhattan: " + value);
        q.add(new Game(t, x, y, value, value, null, 0));
        int n = t.length;
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
                System.out.println("Käytetty aika: " + (System.currentTimeMillis() - start));
                print(g.getTable());
                break;
            }
            
            if (g.getY() - 1 >= 0 && g.d != Direction.DOWN) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.UP);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.UP);
                q.add(new Game(a, g.getX(), g.getY() - 1, value, value + g.moves + 1, Direction.UP, g.moves + 1));
            }
            if (g.getY() + 1 < n && g.d != Direction.UP) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.DOWN);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.DOWN);
                q.add(new Game(a, g.getX(), g.getY() + 1, value, value + g.moves + 1, Direction.DOWN, g.moves + 1));
            }
            if (g.getX() - 1 >= 0 && g.d != Direction.RIGHT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.LEFT);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.LEFT);
                q.add(new Game(a, g.getX() - 1, g.getY(), value, value + g.moves + 1, Direction.LEFT, g.moves + 1));
            }
            if (g.getX() + 1 < n && g.d != Direction.LEFT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.RIGHT);
                value = Logic.countManhattan(a);
//                value = Logic.countNewManhattan(a, g.Manhattan, g.getY(), g.getX(), Direction.RIGHT);
                q.add(new Game(a, g.getX() + 1, g.getY(), value, value + g.moves + 1, Direction.RIGHT, g.moves + 1));
            }
            

            i++;

        }
    }

    static Game initGame(Game g) {
        Direction[] values = Direction.values();
        Random random = new Random();
        int[][] t = g.getTable();
        int j = g.getY();
        int i = g.getX();
        int count = 1;
        Direction d;
        while (count < 1000) {
            d = values[random.nextInt(values.length)];
            switch (d) {
                case UP:
                    if (j - 1 >= 0) {
                        t = Logic.moveBlock(t, j, i, d);
                        j--;
                    }
                    break;
                case DOWN:
                    if (j + 1 < t.length) {
                        t = Logic.moveBlock(t, j, i, d);
                        j++;
                    }
                    break;
                case LEFT:
                    if (i - 1 >= 0) {
                        t = Logic.moveBlock(t, j, i, d);
                        i--;
                    }
                    break;
                case RIGHT:
                    if (i + 1 < t.length) {
                        t = Logic.moveBlock(t, j, i, d);
                        i++;
                    }
                    break;
            }
            count++;
        }
        g.setX(i);
        g.setY(j);
        g.setTable(t);
        g.setValue(Logic.countManhattan(t));
        return g;
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
