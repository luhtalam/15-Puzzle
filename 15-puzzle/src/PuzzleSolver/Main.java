package PuzzleSolver;


import entity.Solver;
import entity.Game;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Main luokka, pelitilanteen syöttämistä ja ratkaisemista varten.
 */
public class Main {

    static int[][] h1 = {{16, 12, 9, 13}, {15, 11, 10, 14}, {3, 7, 6, 2}, {4, 8, 5, 1}};
    static int[][] h2 = {{16, 12, 9, 13}, {15, 11, 10, 14}, {7, 8, 5, 6}, {4, 3, 2, 1}};
    static int[][] h0 = {{7, 16, 3, 15}, {5, 12, 13, 6}, {9, 4, 10, 2}, {1, 14, 11, 8}}; //osoittautui hankalaksi nykyisellä heuristiikalla
    static int[][] t = {{6, 4, 7}, {8, 5, 9}, {3, 2, 1}};
    static int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Game g = new Game(h0, 1, 0, 0, null);
        Game g = new Game(4);
        Solver solver = new Solver();
//        solver.solve(g);
        solver.analyze(4);

    }
}
