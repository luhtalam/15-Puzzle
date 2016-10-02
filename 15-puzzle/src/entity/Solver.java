package Entity;

import DataStructures.MinHeap;
import java.util.PriorityQueue;

/**
 * Luokka 15-pelin ratkaisijaa varten.
 */
public class Solver { //Oma toteutus tehokkaampi kuin javan priorityQueue. Tee vielä tarkempaa analysointia
    // miksi näin!

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
     */
    public long solve(Game game) {
        print(game.getTable());
        System.out.println("Manhattan: " + (game.getValue() - game.getMoves()));
        System.out.println("y: " + game.getY());
        System.out.println("x: " + game.getX());
        System.out.println("");

        q.add(game);
        int n = game.getTable().length;
        int i = 0;
        long start = System.currentTimeMillis();
        while (true) {
            game = q.poll();
            i++;
            if (game.getValue() - game.getMoves() == 0) {
                System.out.println("ratkaisu löytyi");
                System.out.println("nostoja keosta: " + i);
                System.out.println("siirtoja: " + game.getMoves());
                System.out.println("Käytetty aika: " + (System.currentTimeMillis() - start) + " ms");
                printAnswer(game);
                break;
            }

            addNewGame(game, Direction.UP);

            addNewGame(game, Direction.DOWN);

            addNewGame(game, Direction.LEFT);

            addNewGame(game, Direction.RIGHT);

        }
        return System.currentTimeMillis() - start;
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

    public void analyze(int size) {
        int i = 0;
        int n = 1000;
        long raices = 0;
        long timeSum = 0;
        long start, end;
        Game g;
        while (i < n) {
            q = new MinHeap();
            g = new Game(size);
            timeSum += solve(g);
            i++;
        }
        System.out.println("Keskimääräinen ratkaisuaika: " + timeSum / n);
    }
    
    public void printAnswer(Game game) {
        while(game != null) {
            print(game.getTable());
            System.out.println("");
            game = game.getParent();
        }
    }

    private void addNewGame(Game game, Direction d) { //konsturoi ja lisää uuden pelitilanteen prioriteettijonoon
        if (!canMove(game, d)) {
            return;
        }
        int[][] table = Logic.moveBlock(game.getTable(), game.getX(), game.getY(), d);
        int MD = Logic.countManhattan(table);
        switch (d) {
            case UP:
                q.add(new Game(table, game.getX(), game.getY() - 1, game.getMoves() + 1, game, Direction.UP));
                break;
            case DOWN:
                q.add(new Game(table, game.getX(), game.getY() + 1, game.getMoves() + 1, game, Direction.DOWN));
                break;
            case LEFT:
                q.add(new Game(table, game.getX() - 1, game.getY(), game.getMoves() + 1, game, Direction.LEFT));
                break;
            case RIGHT:
                q.add(new Game(table, game.getX() + 1, game.getY(), game.getMoves() + 1, game, Direction.RIGHT));
                break;
        }
    }

    private void print(int[][] t) { //tulostaa pelilaudan ruudulle. Numero 16 vastaa tyhjää pelilaattaa
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t[0].length; i++) {
                System.out.printf("%2d ", t[j][i]);
            }
            System.out.println("");
        }
    }
}
