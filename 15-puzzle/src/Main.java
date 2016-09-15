
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
        int[][] t = {{9, 1, 5}, {4, 2, 3}, {7, 8, 6}};
        print(t);
        System.out.println(Logic.countManhattan(t));
        System.out.println(Logic.countMisplacedTiles(t));    
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
