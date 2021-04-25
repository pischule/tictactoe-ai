package bsu.tictactoe;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class CliPlayer implements Player {
    private final Scanner scanner;

    @Override
    public void reward(double value, Board board) {
        if (value == 1) {
            System.out.println("You win!");
        } else if (value == -1) {
            System.out.println("You lose!");
        }

        if (value == 1 || value == -1 || board.isFull()) {
            System.out.println(board);
        }
    }

    @Override
    public int pickMove(Board board) {
        System.out.println("Pick move: ");
        System.out.println(board);
        System.out.println();
        int userKey = scanner.nextInt();
        return List.of(7, 8, 9, 4, 5, 6, 1, 2, 3).indexOf(userKey);
    }
}
