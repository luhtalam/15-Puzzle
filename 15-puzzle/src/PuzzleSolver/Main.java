package PuzzleSolver;


import Entity.Direction;
import Entity.Solver;
import Entity.Game;
import Entity.Logic;
import UI.TextUI;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Main luokka, pelitilanteen syöttämistä ja ratkaisemista varten.
 */
public class Main {

    /**
     * Avaa lopullisessa versiossa uuden tekstikäyttöliittymän.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextUI ui = new TextUI();
        ui.start();
    }
}
