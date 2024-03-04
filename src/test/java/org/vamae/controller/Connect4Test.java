package org.vamae.controller;

import org.junit.Before;
import org.junit.Test;
import org.vamae.entity.GameBoard;
import org.vamae.enums.Piece;
import org.vamae.exceptions.PieceOutOfBoardException;

import static org.junit.jupiter.api.Assertions.*;

public class Connect4Test {
    Connect4 game;
    GameBoardController gameBoardController;
    @Before
    public void setUp() {
        int columns = 7;
        int rows = 6;
        GameBoard gameBoard = new GameBoard(columns, rows);
        gameBoardController = new GameBoardController(gameBoard);
        game = new Connect4(gameBoardController);
    }
    @Test
    public void testMoveVertical() {
        /*
         * | n n n n n n n |
         * | n n n n n n n |
         * | x n n n n n n |
         * | x n n n n n n |
         * | x n n n n n n |
         * | x n n n n n n |
         * */
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertTrue(game.move(0, Piece.PLAYER_1));

        gameBoardController.getGameBoard().getColumns().get(0).clear();

        /*
         * | n n n n n n n |
         * | x n n n n n n |
         * | x n n n n n n |
         * | x n n n n n n |
         * | x n n n n n n |
         * | o n n n n n n |
         * */
        assertFalse(game.move(0, Piece.PLAYER_2));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertTrue(game.move(0, Piece.PLAYER_1));
    }

    @Test
    public void testMoveHorizontal() {
        /*
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | x x x x n n n |
         * */
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(1, Piece.PLAYER_1));
        assertFalse(game.move(2, Piece.PLAYER_1));
        assertTrue(game.move(3, Piece.PLAYER_1));
        gameBoardController.getGameBoard().getColumns().get(0).clear();
        gameBoardController.getGameBoard().getColumns().get(1).clear();
        gameBoardController.getGameBoard().getColumns().get(2).clear();
        gameBoardController.getGameBoard().getColumns().get(3).clear();

        /*
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | o x x x x n n |
         * */
        assertFalse(game.move(0, Piece.PLAYER_2));
        assertFalse(game.move(1, Piece.PLAYER_1));
        assertFalse(game.move(2, Piece.PLAYER_1));
        assertFalse(game.move(3, Piece.PLAYER_1));
        assertTrue(game.move(4, Piece.PLAYER_1));

        gameBoardController.getGameBoard().getColumns().get(0).clear();
        gameBoardController.getGameBoard().getColumns().get(1).clear();
        gameBoardController.getGameBoard().getColumns().get(2).clear();
        gameBoardController.getGameBoard().getColumns().get(3).clear();
        gameBoardController.getGameBoard().getColumns().get(4).clear();

        /*
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | n n n n n n n |
         * | x x x x n n n |
         * | o o o x n n n |
         * */
        assertFalse(game.move(0, Piece.PLAYER_2));
        assertFalse(game.move(1, Piece.PLAYER_2));
        assertFalse(game.move(2, Piece.PLAYER_2));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(1, Piece.PLAYER_1));
        assertFalse(game.move(2, Piece.PLAYER_1));
        assertFalse(game.move(3, Piece.PLAYER_1));
        assertTrue(game.move(3, Piece.PLAYER_1));
    }

    @Test
    public void testMoveLeadingDiagonal() {
        /*
        * | n n n n n n n |
        * | n n n n n n n |
        * | n n n x n n n |
        * | n n x o n n n |
        * | n x o o n n n |
        * | x o o o n n n |
        * */
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(1, Piece.PLAYER_2));
        assertFalse(game.move(1, Piece.PLAYER_1));
        assertFalse(game.move(2, Piece.PLAYER_2));
        assertFalse(game.move(2, Piece.PLAYER_2));
        assertFalse(game.move(2, Piece.PLAYER_1));
        assertFalse(game.move(3, Piece.PLAYER_2));
        assertFalse(game.move(3, Piece.PLAYER_2));
        assertFalse(game.move(3, Piece.PLAYER_2));
        assertTrue(game.move(3, Piece.PLAYER_1));
    }

    @Test
    public void testMoveTrailingDiagonal() {
        /*
         * | n n n n n n n |
         * | n n n n n n n |
         * | x n n n n n n |
         * | o x n n n n n |
         * | o o x n n n n |
         * | o o o x n n n |
         * */
        assertFalse(game.move(0, Piece.PLAYER_2));
        assertFalse(game.move(0, Piece.PLAYER_2));
        assertFalse(game.move(0, Piece.PLAYER_2));
        assertFalse(game.move(0, Piece.PLAYER_1));
        assertFalse(game.move(1, Piece.PLAYER_2));
        assertFalse(game.move(1, Piece.PLAYER_2));
        assertFalse(game.move(1, Piece.PLAYER_1));
        assertFalse(game.move(2, Piece.PLAYER_2));
        assertFalse(game.move(2, Piece.PLAYER_1));
        assertTrue(game.move(3, Piece.PLAYER_1));
    }

    @Test
    public void testMoveInvalidCoordinates() {
        assertThrows(PieceOutOfBoardException.class, () -> game.move(10, Piece.PLAYER_1));
        assertThrows(PieceOutOfBoardException.class, () -> game.move(-1, Piece.PLAYER_1));

        game.move(0, Piece.PLAYER_1);
        game.move(0, Piece.PLAYER_1);
        game.move(0, Piece.PLAYER_1);
        game.move(0, Piece.PLAYER_1);
        game.move(0, Piece.PLAYER_1);
        game.move(0, Piece.PLAYER_1);
        assertThrows(IllegalArgumentException.class, () -> game.move(0, Piece.PLAYER_1));
    }
}