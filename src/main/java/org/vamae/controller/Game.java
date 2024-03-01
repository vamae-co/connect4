package org.vamae.controller;

import lombok.AllArgsConstructor;
import org.vamae.enums.Piece;

@AllArgsConstructor
public class Game {
    private GameBoardController gameBoardController;
    private int betSum;

    public void move(int x, Piece player) {

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
        return true;
    }
}
