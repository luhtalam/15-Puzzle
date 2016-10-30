package Entity;

import DataStructures.MinHeap;
import DataStructures.Stack;
import java.util.PriorityQueue;

/**
 * Luokka 15-pelin ratkaisijaa varten.
 */
public class Solver {

    private MinHeap q;

    /**
     * Konstruktori.
     */
    public Solver() {
    }

    /**
     * Metodi pelin ratkaisemiseen.
     *
     * @param game pelitilanne, joka ratkaistaan
     * @return ratkaisu peli
     */
    public Game solve(Game game) {
        this.q = new MinHeap();
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

    /**
     * Metodi algoritmin suorituskykytestausta varten.
     *
     * @param gameSize analysoitavan pelin sivunpituus
     */
    public void analyze(int gameSize) { //vielä hieman kesken
        int n = 100;
        int counter = 0;
        Game[] games = new Game[10000];
        int[] times = new int[10000];
        int[] moves = new int[10000];
        int[] heapSizes = new int[10000];
        long start, end;
        long sum = 0;
        long moveSum = 0;
        long heapSize = 0;
        Game solution;
        while (counter < n) {
            Game game = new Game(gameSize);
            games[counter] = game;

            start = System.currentTimeMillis();
            solution = solve(game);
            end = System.currentTimeMillis();

            times[counter] = (int) (end - start);
            sum += end - start;
            moves[counter] = solution.getMoves();
            moveSum += moves[counter];
            heapSizes[counter] = q.getHeapSize();
            heapSize += heapSizes[counter];

            counter++;
        }
        System.out.println("Times(ms):");
        for (int i = 0; i < 100; i++) {
            System.out.println(times[i]);
        }
        System.out.println("siirrot:");
        for (int i = 0; i < 100; i++) {
            System.out.println(moves[i]);
        }
        System.out.println("prioriteettijono:");
        for (int i = 0; i < 100; i++) {
            System.out.println(heapSizes[i]);
        }
//        System.out.println("");
//        System.out.println("Keskimääräinen ratkaisuaika: " + (sum/n));
//        System.out.println("Siirtoja keskimäärin: " + moveSum/n);
//        System.out.println("keskimääräinen keon koko: " + heapSize/n);
    }

    /**
     * Tulostaa ratkaisuun vaadittavat siirrot.
     *
     * @param game ratkaistu peli
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
                System.out.printf("%2d ", t1[j][i]);
            }
            if (j == 1) {
                System.out.print(" -> ");
            } else {
                System.out.print("    ");
            }
            for (int i = 0; i < n; i++) {
                System.out.printf("%2d ", t2[j][i]);
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
