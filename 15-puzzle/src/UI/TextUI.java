package UI;

import Entity.Solver;
import Entity.Game;
import java.util.Scanner;

/**
 *Tekstikäyttöliittymäluokka.
 */
public class TextUI {

    private Scanner scanner;
    private Solver solver;

    /**
     *Konstruktori.
     */
    public TextUI() {
        this.scanner = new Scanner(System.in);
        this.solver = new Solver();
    }

    /**
     *Käynnistää tekstikäyttöliittymän.
     */
    public void start() {
        while (true) {
            int gameSize = chooseGameSize();
            Game game = drawNewGame(gameSize);
            if (game == null) {
                System.out.println("");
                continue;
            }
            game = solveGame(game);
            printAnswer(game);
        }
    }

    private int chooseGameSize() { //kysyy käyttäjältä ratkaistavan pelilaudan sivunpituutta
        System.out.println("Tervetuloa N-pelin ratkojaan!");
        System.out.println("Aloita syöttämällä ratkaistavan pelin sivunpituus. Käytettävissä olevat komennot:");
        System.out.println("    3) 8-peli, ratkaistavissa erittäin nopeasti.");
        System.out.println("    4) Klassinen 15-peli, ratkaisuaika korkeintaan 10 sekuntti, keskimäärin 0,15 s.");
        System.out.println("    x) Sulje ohjelma.");
        System.out.println("");
        System.out.print("Komento: ");

        String command;
        while (true) {
            command = scanner.nextLine();
            switch (command) {
                case "x":
                    System.exit(0);
                case "3":
                    return 3;
                case "4":
                    return 4;
                default:
                    System.out.print("Tunnistamaton komento. Syötä uusi komento: ");
            }
        }
    }

    private Game drawNewGame(int gameSize) { //arvoo uuden pelinaloitustilanteen
        System.out.println("\nValitsit " + (gameSize * gameSize - 1) + "-pelin.");
        System.out.println("Arvotaan seuraavaksi pelin aloitustilanne...");
        Game game;
        String command;
        while (true) {
            game = new Game(gameSize);
            System.out.println("\nAloitustilanteeksi arvottiin:\n");
            game.print();
            System.out.println("\nValitse toiminto:");
            System.out.println("    1) Ratkaise peli.");
            System.out.println("    2) Arvo uusi alkutilanne.");
            System.out.println("    3) Valitse toinen sivunpituus.");
            System.out.println("    x) Sulje ohjelma.");
            System.out.print("\nToiminto: ");
            boolean swtch = true;
            while (swtch) {
                command = scanner.nextLine();
                switch (command) {
                    case "x":
                        System.exit(0);
                    case "1":
                        return game;
                    case "2":
                        swtch = false;
                        break;
                    case "3":
                        return null;
                    default:
                        System.out.print("Tunnistamaton toiminto. Syötä uusi toiminto: ");
                }
            }
        }
    }
    
    private Game solveGame(Game game) { //ratkaisee annetus pelin
        System.out.println("\nRatkaistaan seuraava peli:\n");
        game.print();
        System.out.println("");
        return this.solver.solve(game);
    }
    
    private void printAnswer(Game game) { //tulostaa ratkaisun
        System.out.println("Ratkaisu löytyi! Valitse jokin seuraavista toiminnoista:");
        System.out.println("    1) Tulosta löydetyn ratkaisun siirrot.");
        System.out.println("    2) Palaa päävalikkoon.");
        System.out.println("    3) Sulje ohjelma.");
        System.out.println("");
        System.out.print("Toiminto: ");
        
        String command;
        while(true) {
            command = scanner.nextLine();
            switch(command) {
                case "x":
                    System.exit(0);
                case "1":
                    solver.printAnswer(game);
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Tunnistamaton toiminto. Syötä uusi toiminto: ");
            }
        }
    }
}
