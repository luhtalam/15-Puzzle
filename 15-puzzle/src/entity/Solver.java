package Entity;

import DataStructures.MinHeap;
import DataStructures.Stack;
import java.util.PriorityQueue;

/**
 * Luokka 15-pelin ratkaisijaa varten.
 */
public class Solver {

//    private PriorityQueue<Game> q; //myöhemmin omatoteutus prioriteettijonolle, jossa konsturoidut pelitilanteet ovat
    private MinHeap q;

    /**
     * Konstruktori, joka alustaa uuden prioriteettijonon.
     */
    public Solver() {
//        this.q = new PriorityQueue<Game>();
        this.q = new MinHeap();
    }

    /**
     * Metodi pelin ratkaisemiseen.
     *
     * @param game pelitilanne, joka ratkaistaan
     * @return
     */
    public Game solve(Game game) {
        q.add(game);
        while (true) {
            game = q.poll();
            if (game.getValue() - game.getMoves() == 0) {
                return game;
            }
            addNewGame(game, Direction.UP);
            addNewGame(game, Direction.DOWN);
            addNewGame(game, Direction.LEFT);
            addNewGame(game, Direction.RIGHT);
        }
    }

    private boolean canMove(Game game, Direction d) {
        int n = game.getTable().length;
        switch (d) {
            case UP:
                return (game.getY() - 1 >= 0 && game.getDirection() != Direction.DOWN);
            case DOWN:
                return (game.getY() + 1 < n && game.getDirection() != Direction.UP);
            case LEFT:
                return (game.getX() - 1 >= 0 && game.getDirection() != Direction.RIGHT);
            case RIGHT:
                return (game.getX() + 1 < n && game.getDirection() != Direction.LEFT);
        }
        return true;
    }

//    /**
//     *
//     * @param size
//     */
//    public void analyze(int size) {
//        int i = 0;
//        int n = 1000;
//        long raices = 0;
//        long timeSum = 0;
//        long start, end;
//        Game g;
//        while (i < n) {
//            q = new MinHeap();
//            g = new Game(size);
//            timeSum += solve(g);
//            i++;
//        }
//        System.out.println("Keskimääräinen ratkaisuaika: " + timeSum / n);
//    }
    /**
     *
     * @param game
     */
    public void printAnswer(Game game) {
        Stack stack = new Stack();
        while (game != null) {
            stack.push(game);
            game = game.getParent();
        }
        System.out.println("\nRatkaisussa on " + (stack.getSize() - 1) + " siirtoa. "
                + "Ratkaisuun päästiin seuraavilla siirroilla:");
        System.out.println("");
        int counter = 1;
        Game game1, game2;
        game1 = stack.pop();
        while (!stack.empty()) {
            System.out.println(counter + ". siirto:\n");
            game2 = stack.pop();
            printMove(game1, game2);
            game1 = game2;
            System.out.println("");
            counter++;
        }
    }
    
    private void printMove(Game game1, Game game2) {
        int n = game1.getTable().length;
        int[][] t1 = game1.getTable();
        int[][] t2 = game2.getTable();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%2d ",t1[j][i]);
            }
            if (j == 1) {
                System.out.print(" -> ");
            } else {
                System.out.print("    ");
            }
            for (int i = 0; i < n; i++) {
                System.out.printf("%2d ",t2[j][i]);
            }
            System.out.println("");
        }
    }

    private void addNewGame(Game game, Direction d) { //konsturoi ja lisää uuden pelitilanteen prioriteettijonoon
        if (!canMove(game, d)) {
            return;
        }
        switch (d) {
            case UP:
                q.add(new Game(game, d));
                break;
            case DOWN:
                q.add(new Game(game, d));
                break;
            case LEFT:
                q.add(new Game(game, d));
                break;
            case RIGHT:
                q.add(new Game(game, d));
                break;
        }
    }
}
