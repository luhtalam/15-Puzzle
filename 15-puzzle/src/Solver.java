
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
public class Solver {

    private PriorityQueue<Game> q;

    public Solver() {
        this.q = new PriorityQueue<Game>();
    }

    public void solve(Game game) {
        int value = game.getValue();
        System.out.println("Manhattan: " + value);
        q.add(game);
        int n = game.getTable().length;
        int[][] a;
        int i = 1;
        int numb;
        long start = System.currentTimeMillis();
        while (true) {
            game = q.poll();

            if (game.getValue() - game.moves == 0) {
                System.out.println("ratkaisu löytyi");
                System.out.println("nostoja keosta: " + i);
                System.out.println("siirtoja: " + game.moves);
                System.out.println("Käytetty aika: " + (System.currentTimeMillis() - start) + " ms");
                print(game.getTable());
                break;
            }

            if (game.getY() - 1 >= 0 && game.getDirection() != Direction.DOWN) {
                addNewGame(game, Direction.UP);
            }
            if (game.getY() + 1 < n && game.getDirection() != Direction.UP) {
                addNewGame(game, Direction.DOWN);
            }
            if (game.getX() - 1 >= 0 && game.getDirection() != Direction.RIGHT) {
                addNewGame(game, Direction.LEFT);
            }
            if (game.getX() + 1 < n && game.getDirection() != Direction.LEFT) {
                addNewGame(game, Direction.RIGHT);
            }

            i++;

        }
    }

    private void addNewGame(Game game, Direction d) {
        int[][] table = Logic.moveBlock(game.getTable(), game.getY(), game.getX(), d);
        int MD = Logic.countManhattan(table);
        switch (d) {
            case UP:
                q.add(new Game(table, game.getX(), game.getY() - 1, MD + game.moves + 1, Direction.UP, game.moves + 1));
                break;
            case DOWN:
                q.add(new Game(table, game.getX(), game.getY() + 1, MD + game.moves + 1, Direction.DOWN, game.moves + 1));
                break;
            case LEFT:
                q.add(new Game(table, game.getX() - 1, game.getY(), MD + game.moves + 1, Direction.LEFT, game.moves + 1));
                break;
            case RIGHT:
                q.add(new Game(table, game.getX() + 1, game.getY(), MD + game.moves + 1, Direction.RIGHT, game.moves + 1));
                break;
        }
    }

    public void print(int[][] t) {
        for (int j = 0; j < t.length; j++) {
            for (int i = 0; i < t[0].length; i++) {
                System.out.printf("%2d ", t[j][i]);
            }
            System.out.println("");
        }
    }
}
