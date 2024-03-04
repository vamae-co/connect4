package org.vamae.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vamae.entity.GameBoard;
import org.vamae.enums.Piece;
import org.vamae.exceptions.PieceOutOfBoardException;

class GameBoardControllerTest {
        private GameBoardController gameBoardController;
        private GameBoard gameBoard;
        @BeforeEach
        public void setUp() {
            gameBoard = new GameBoard(7, 6);
            gameBoardController = new GameBoardController(gameBoard);
        }

        @Test
        public void isInBoardValidCoordinates() {
            assertTrue(gameBoardController.isInBoard(2, 3));
        }

        @Test
        public void isInBoardInvalidCoordinates() {
            assertFalse(gameBoardController.isInBoard(-1, 3));
            assertFalse(gameBoardController.isInBoard(2, -5));
            assertFalse(gameBoardController.isInBoard(5, 9));
        }

        @Test
        public void getCellEmpty() {
            assertNull(gameBoardController.getCell(0,0));
            gameBoardController.getGameBoard().getColumns().get(0).add(Piece.PLAYER_1);
            assertNotNull(gameBoardController.getCell(0,0));
        }

        @Test
        public void getCellInvalidCoordinates() {
            assertThrows(PieceOutOfBoardException.class, () -> gameBoardController.getCell(-1, 4));
            assertThrows(PieceOutOfBoardException.class, () -> gameBoardController.getCell(3, -1));
            assertThrows(PieceOutOfBoardException.class, () -> gameBoardController.getCell(5, 8));
        }

}