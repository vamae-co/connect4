package org.vamae.controller;

import lombok.AllArgsConstructor;
import org.vamae.enums.Piece;

@AllArgsConstructor
public class Game {
    private GameBoardController gameBoardController;
    private int betSum;

    public boolean move(int x, Piece player) {
        return checkWin(x, gameBoardController.getGameBoard().getColumnsCount() - 1, player);
    }

    private boolean checkLine(int startX, int startY, int endX, int endY, Piece player) {
        for(int i = 0; i < (gameBoardController.getGameBoard().getColumnsCount() + 1) / 2; i++) {
            int checkedX = startX + (endX * i);
            int checkedY = startY + (endY * i);

            if(!gameBoardController.isInBoard(checkedX, checkedY)) {
                return false;
            }
            else if(player != gameBoardController.getCell(checkedX, checkedY)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWin(int x, int y, Piece player) {
        int piecesForWinCount = (gameBoardController.getGameBoard().getColumnsCount() + 1) / 2;
        if (checkLine(x, y, 0, 1, player)) {
            return true;
        }

        for(int offset = 0; offset < piecesForWinCount; offset++) {
            if(checkLine(x - (piecesForWinCount - 1) + offset, y, 1, 0, player)) {
                return true;
            }

            if(checkLine(x - (piecesForWinCount - 1) + offset, y + (piecesForWinCount - 1) - offset, 1, -1, player)) {
                return true;
            }

            if(checkLine(x - (piecesForWinCount - 1) + offset, y - (piecesForWinCount - 1) + offset, 1, 1, player)) {
                return true;
            }
        }
        return false;
    }
}
