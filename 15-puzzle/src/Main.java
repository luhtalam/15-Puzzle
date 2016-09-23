
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Main luokka, pelitilanteen syöttämistä ja ratkaisemista varten. Vielä kesken
 * ja sisältää metodeja, joita pitää eriyttää omiin luokkiin.
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
        Game g = new Game(t, 2, 1, Logic.countManhattan(t),null, 0);
        System.out.println("value: " + g.getValue());
        System.out.println("j: " + g.getY());
        System.out.println("i: " + g.getX());
        Solver solver = new Solver();
        solver.print(g.getTable());
        solver.solve(g);

    }
}
