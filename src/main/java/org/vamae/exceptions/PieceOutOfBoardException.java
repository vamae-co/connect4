package org.vamae.exceptions;

public class PieceOutOfBoardException extends ArrayIndexOutOfBoundsException{
    public PieceOutOfBoardException(String message) {
        super(message);
    }
}
