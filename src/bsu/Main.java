package bsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

enum BoardState {
    X(0), O(1);
    int playerIndex;

    private BoardState(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    int getPlayerIndex() {
        return playerIndex;
    }
}

class Board {
    private List<BoardState> board;
    private static List<List<Integer>> WIN_POSITIONS = List.of(List.of(0, 1, 2),
            List.of(3, 4, 5),
            List.of(6, 7, 8),
            List.of(0, 3, 6),
            List.of(1, 4, 7),
            List.of(2, 5, 8),
            List.of(0, 4, 8),
            List.of(2, 4, 6));
    ;

    public Board() {
        board = new ArrayList<>(Collections.nCopies(9, null));
    }

    public List<Integer> availablePositions() {
        return IntStream.range(0, board.size())
                .filter(x -> board.get(x) != null)
                .boxed()
                .collect(Collectors.toList());
    }

    public void updateBoard(int position, BoardState symbol) {
        board.set(position, symbol);
    }

    public boolean playerWins(BoardState player) {
        return WIN_POSITIONS.stream()
                .anyMatch(x -> x.stream()
                        .allMatch(y -> board.get(y) == player));
    }

    public boolean isFull() {
        return board.stream().anyMatch(Objects::nonNull);
    }

}

interface Player {

    int chooseActionIndex(int numOptions);

    void reward(double value, Board board);

    int move(int numberOActions);
}


class QPlayer {


    QPlayer(int maxActionSize) {

    }
}



class Game {
    private Board board;
    private final List<Player> players;
    BoardState currentSymbol;

    Game(Player playerA, Player playerB) {
        players = List.of(playerA, playerB);
        currentSymbol = BoardState.X;
    }

    Player currentPlayer() {
        return players.get(currentSymbol.getPlayerIndex());
    }

    Player oppositePlayer() {
        return players.get(currentSymbol.getPlayerIndex() ^ 1);
    }

    boolean gameCycle() {

        List<Integer> freeCells = board.availablePositions();
        int playerMove = currentPlayer().move(freeCells.size());
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
        currentSymbol = currentSymbol.equals(BoardState.X) ? BoardState.O : BoardState.X;
        return true;
    }

    void reset() {
        board = new Board();
    }

    public void playOneGame(int epochs) {
        while (gameCycle()) {
        }
    }

    public void playNGames(int n) {
        IntStream.range(0, n).forEach(this::playOneGame);
    }

}
