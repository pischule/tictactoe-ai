package bsu.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player p1 = new DummyPlayer();
        Player p2 = new CliPlayer(new Scanner(System.in));
        Game game = new Game(p1, p2);
        game.playOneGame();
    }
}


