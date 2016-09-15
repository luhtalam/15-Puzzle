
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
        int[][] t = {{6, 4, 7}, {8, 5, 9}, {3, 2, 1}};
        q.add(new Game(t, 0, 1, Logic.countManhattan(t), null, 0));
        int minV;
        int value;
        int[][] a;
        int i = 1;
        while (true) {
            Game g = q.poll();
//            System.out.println("g:");
//            print(g.getTable());
//            System.out.println(g.getValue() + "\n");
            minV = Integer.MAX_VALUE;
            if (g.getY() - 1 >= 0 && g.d != Direction.DOWN) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.UP);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX(), g.getY() - 1, value + g.moves +1, Direction.UP, g.moves +1));
                minV = Math.min(value, minV);
//                print(a);
//                System.out.println(value + "\n");
            }
            if (g.getY() + 1 < 3 && g.d != Direction.UP) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.DOWN);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX(), g.getY() + 1, value + g.moves +1, Direction.DOWN, g.moves +1));
                minV = Math.min(value, minV);
//                print(a);
//                System.out.println(value + "\n");
            }
            if (g.getX() - 1 >= 0 && g.d != Direction.RIGHT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.LEFT);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX() - 1, g.getY(), value + g.moves +1, Direction.LEFT, g.moves +1));
                minV = Math.min(value, minV);
//                print(a);
//                System.out.println(value + "\n");
            }
            if (g.getX() + 1 < 3 && g.d != Direction.LEFT) {
                a = Logic.moveBlock(g.getTable(), g.getY(), g.getX(), Direction.RIGHT);
                value = Logic.countManhattan(a);
                q.add(new Game(a, g.getX() + 1, g.getY(), value + g.moves +1, Direction.RIGHT, g.moves +1));
                minV = Math.min(value, minV);
//                print(a);
//                System.out.println(value + "\n");
            }
            if (minV == 0) {
                System.out.println("ratkaisu");
                System.out.println(i);
                System.out.println(g.moves +1);
                break;
            }
            i++;

        }
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
