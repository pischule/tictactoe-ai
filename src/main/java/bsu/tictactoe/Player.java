package bsu.tictactoe;

interface Player {
    void reward(double value, Board board);

    int pickMove(Board board);
}
