package bsu.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testAvailablePositions() {
        Board board = new Board();
        assertEquals(9, board.availablePositions().size());
        board.updateBoard(0, CellState.X);
        assertEquals(8, board.availablePositions().size());
    }

    @Test
    public void testIsFullMethod() {
        Board board = new Board();
        assertFalse(board.isFull());
        board.availablePositions().forEach(it -> board.updateBoard(it, CellState.X));
        assertTrue(board.isFull());
    }

    @Test
    public void testDetectWinner() {
        Board board = new Board();
        assertFalse(board.playerWins(CellState.X));
        List.of(0, 1, 2).forEach(it -> board.updateBoard(it, CellState.X));
        assertTrue(board.playerWins(CellState.X));
        assertFalse(board.playerWins(CellState.O));
        Board board2 = new Board();
        List.of(0, 4, 8).forEach(it -> board2.updateBoard(it, CellState.O));
        assertTrue(board2.playerWins(CellState.O));
        assertFalse(board2.playerWins(CellState.X));
    }

    @Test
    public void testVerticalWinner() {
        Board board = new Board();
        List.of(7, 4, 1).forEach(it -> board.updateBoard(it, CellState.X));
        assertTrue(board.playerWins(CellState.X));
    }

    @Test
    public void testDetectIllegalMove() {
        Board board = new Board();
        board.updateBoard(0, CellState.X);
        assertThrows(RuntimeException.class, () -> board.updateBoard(0, CellState.O));
        assertThrows(RuntimeException.class, () -> board.updateBoard(10, CellState.X));
    }

}