package org.vamae.entity;

import lombok.Getter;
import org.vamae.enums.Piece;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameBoard {
    private final List<List<Piece>> columns;
    private final int rows;

    public GameBoard(int columns, int rows) {
        this.columns = new ArrayList<>();
        for(int i = 0; i < columns; i++) {
            this.columns.add(new ArrayList<>());
        }
        this.rows = rows;
    }

    public int getColumnsCount() {
        return columns.size();
    }
}
