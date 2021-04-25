package bsu.tictactoe;

import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EqualsAndHashCode
class Board {
    private static final List<List<Integer>> WIN_POSITIONS = List.of(List.of(0, 1, 2),
            List.of(3, 4, 5),
            List.of(6, 7, 8),
            List.of(0, 3, 6),
            List.of(1, 4, 7),
            List.of(2, 5, 8),
            List.of(0, 4, 8),
            List.of(2, 4, 6)
    );
    private final List<CellState> board;

    public Board() {
        board = new ArrayList<>(Collections.nCopies(9, null));
    }

    public List<Integer> availablePositions() {
        return IntStream.range(0, board.size())
                .filter(x -> board.get(x) == null)
                .boxed()
                .collect(Collectors.toList());
    }

    public void updateBoard(int position, CellState symbol) {
        if (!availablePositions().contains(position)) throw new RuntimeException("Illegal move");
        board.set(position, symbol);
    }

    public boolean playerWins(CellState player) {
        return WIN_POSITIONS.stream()
                .anyMatch(x -> x.stream()
                        .allMatch(y -> board.get(y) == player));
    }

    public boolean isFull() {
        return board.stream().allMatch(Objects::nonNull);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.size(); ++i) {
            if (i % 3 == 0 && i != 0) {
                sb.append("\n");
            }
            String cellSymbol = Optional.ofNullable(board.get(i)).map(CellState::toString).orElse("_");
            sb.append(cellSymbol);

        }

        return sb.toString();
    }
}
