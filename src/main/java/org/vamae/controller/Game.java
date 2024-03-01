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
        return true;
    }

    private boolean checkWin(int x, int y, Piece player) {
        return true;
    }
}
