
import java.util.PriorityQueue;

/**
 * Luokka 15-pelin ratkaisijaa varten.
 */
public class Solver {

    private PriorityQueue<Game> q; //myöhemmin omatoteutus prioriteettijonolle, jossa konsturoidut pelitilanteet ovat

    /**
     * Konstruktori, joka alustaa uuden prioriteettijonon.
     */
    public Solver() {
        this.q = new PriorityQueue<Game>();
    }

    /**
     *Metodi pelin ratkaisemiseen.
     * @param game pelitilanne, joka ratkaistaan
     */
    public void solve(Game game) {
        print(game.getTable());
        System.out.println("Manhattan: " + (game.getValue() - game.getMoves()));
        System.out.println("y: " + game.getY());
        System.out.println("x: " + game.getX());
        System.out.println("");

        q.add(game);
        int n = game.getTable().length;
        int i = 1;
        long start = System.currentTimeMillis();
        while (true) {
            game = q.poll();

            if (game.getValue() - game.getMoves() == 0) {
                System.out.println("ratkaisu löytyi");
                System.out.println("nostoja keosta: " + i);
                System.out.println("siirtoja: " + game.getMoves());
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

    private void addNewGame(Game game, Direction d) { //konsturoi ja lisää uuden pelitilanteen prioriteettijonoon
        int[][] table = Logic.moveBlock(game.getTable(), game.getX(), game.getY(), d);
        int MD = Logic.countManhattan(table);
        switch (d) {
            case UP:
                q.add(new Game(table, game.getX(), game.getY() - 1, game.getMoves() + 1, Direction.UP));
                break;
            case DOWN:
                q.add(new Game(table, game.getX(), game.getY() + 1, game.getMoves() + 1, Direction.DOWN));
                break;
            case LEFT:
                q.add(new Game(table, game.getX() - 1, game.getY(), game.getMoves() + 1, Direction.LEFT));
                break;
            case RIGHT:
                q.add(new Game(table, game.getX() + 1, game.getY(), game.getMoves() + 1, Direction.RIGHT));
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
