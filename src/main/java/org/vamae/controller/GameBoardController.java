package org.vamae.controller;

import org.vamae.entity.GameBoard;
import org.vamae.enums.Piece;

import java.util.List;

public class GameBoardController {
    private GameBoard gameBoard;

    private boolean isInBoard(int x, int y) {
        return (x >= 0 && x < gameBoard.getColumnsCount()) && (y >= 0 && y < gameBoard.getRows());
    };

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
            return null; //TODO: implement exception throwing
        }
    }
}
