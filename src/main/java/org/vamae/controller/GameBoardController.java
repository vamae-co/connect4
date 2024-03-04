package org.vamae.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.vamae.entity.GameBoard;
import org.vamae.enums.Piece;
import org.vamae.exceptions.PieceOutOfBoardException;

import java.util.List;

@AllArgsConstructor
public class GameBoardController {
    @Getter
    private GameBoard gameBoard;

    public boolean isInBoard(int x, int y) {
        return (x >= 0 && x < gameBoard.getColumnsCount()) && (y >= 0 && y < gameBoard.getRows());
    }

    public Piece getCell(int x, int y) {
        if (isInBoard(x, y)) {
            List<Piece> column = gameBoard.getColumns().get(x);

            if (column.size() > y) {
                return column.get(y);
            } else {
                return null;
            }
        }
        else {
            throw new PieceOutOfBoardException("Piece is out of board!");
        }
    }
}
