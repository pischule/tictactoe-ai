package bsu.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class GameTest {
    @Test
    @Timeout(1)
    public void gameIsFinite() {
        Player player1 = new DummyPlayer();
        Player player2 = new DummyPlayer();
        Game game = new Game(player1, player2);
        game.playOneGame();
    }

    @Test
    @Timeout(1)
    public void nGamesAreFinite() {
        Player player1 = new DummyPlayer();
        Player player2 = new DummyPlayer();
        Game game = new Game(player1, player2);
        game.playNGames(10);
    }
}