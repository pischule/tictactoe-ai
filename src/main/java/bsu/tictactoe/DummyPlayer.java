package bsu.tictactoe;

import java.util.Random;

public class DummyPlayer implements Player {
    private static final Random random = new Random();

    @Override
    public void reward(double value, Board board) {
    }

    @Override
    public int pickMove(Board board) {
        var freeCells = board.availablePositions();
        return freeCells.get(random.nextInt(freeCells.size()));
    }
}
