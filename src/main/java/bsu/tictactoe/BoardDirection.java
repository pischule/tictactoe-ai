package bsu.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDirection {
    private Board board;
    private Integer move;
}
