package org.vamae.entity;

import lombok.Getter;
import org.vamae.enums.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private final List<List<Piece>> columns;
    @Getter
    private final int rows;

    public GameBoard(int columns, int rows) {
        this.columns = new ArrayList<>();
        for(int i = 0; i < columns; i++) {
            this.columns.add(new ArrayList<>());
        }
        this.rows = rows;
    }

    public int getColumns() {
        return columns.size();
    }
}
