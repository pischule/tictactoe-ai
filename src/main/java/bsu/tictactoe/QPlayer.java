package bsu.tictactoe;

import java.util.Map;

public class QPlayer implements Player {
    Map<BoardDirection, Double> qTable;

    @Override
    public void reward(double value, Board board) {

    }

    @Override
    public int pickMove(Board board) {
        return 0;
    }
}
