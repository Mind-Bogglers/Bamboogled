package com.backend.engine;

import com.backend.Position;

import java.util.ArrayList;
import java.util.List;

public class Path {
    List<Position> positions;

    public Path(Position firstPosition) {
        positions = new ArrayList<>();
        positions.add(firstPosition);
    }

    public Path(Path old, Position additional) {
        positions = new ArrayList<>(old.getPositions());
        positions.add(additional);
    }

    public boolean containsPosition(int row, int col) {
        boolean seenBefore = false;
        for (Position p : this.positions) {
            if (p.getRow() == row && p.getCol() == col) {
                seenBefore = true;
                break;
            }
        }
        return seenBefore;
    }

    public List<Position> getPositions() {
        return this.positions;
    }

    @Override
    public String toString() {
        return positions.toString();
    }

}
