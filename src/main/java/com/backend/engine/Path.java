package com.backend.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregation of Position objects that is used for storing a path to a word.
 * @author Hassan El-Sheikha
 */
public class Path {
    List<Position> positions;

    /**
     * Creates a new Path object from an initial position.
     * @param firstPosition Initial position
     */
    public Path(Position firstPosition) {
        positions = new ArrayList<>();
        positions.add(firstPosition);
    }

    /**
     * Construct a new Path object from an existing Path object and an additional Position.
     * @param old Exisitng Path object.
     * @param additional Additional Position.
     */
    public Path(Path old, Position additional) {
        positions = new ArrayList<>(old.getPositions());
        positions.add(additional);
    }

    /**
     * Checks if the path contains a certain position.
     * @return true if the position is contained in the path, false otherwise
     */
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

    /**
     * Returns all positions in the path.
     * @return all positions in the path
     */
    public List<Position> getPositions() {
        return this.positions;
    }

    @Override
    public String toString() {
        return positions.toString();
    }

}
