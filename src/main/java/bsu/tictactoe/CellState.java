package bsu.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum CellState {
    X(0), O(1);
    int playerIndex;

    @Override
    public String toString() {
        return this == CellState.X ? "X" : "O";
    }
}
