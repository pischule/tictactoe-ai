package bsu.tictactoe;

import java.util.List;

public class Game {
    private final List<Player> players;
    CellState currentSymbol;
    private Board board;

    Game(Player playerA, Player playerB) {
        players = List.of(playerA, playerB);
        currentSymbol = CellState.X;
        board = new Board();
    }

    Player currentPlayer() {
        return players.get(currentSymbol.getPlayerIndex());
    }

    Player oppositePlayer() {
        return players.get(currentSymbol.getPlayerIndex() ^ 1);
    }

    private void flipPlayer() {
        currentSymbol = currentSymbol == CellState.X ? CellState.O : CellState.X;
    }

    /**
     * @return true if game is not over yet
     */
    boolean gameMove() {
        int playerMove = currentPlayer().pickMove(board);
        board.updateBoard(playerMove, currentSymbol);

        if (board.playerWins(currentSymbol)) {
            currentPlayer().reward(1, board);
            oppositePlayer().reward(-1, board);
            return false;
        }
        if (board.isFull()) {
            currentPlayer().reward(.5, board);
            oppositePlayer().reward(.5, board);
            return false;
        }
        flipPlayer();
        return true;
    }

    void reset() {
        board = new Board();
    }

    public void playOneGame() {
        while (gameMove()) {
        }
    }

    public void playNGames(int n) {
        for (int i = 0; i < n; ++i) {
            playOneGame();
            reset();
        }
    }

}
