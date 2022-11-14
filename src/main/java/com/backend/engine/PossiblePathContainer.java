package com.backend.engine;

import java.util.ArrayList;
import java.util.List;

public class PossiblePathContainer {
    private List<Path> paths;

    public PossiblePathContainer() {
        this.paths = new ArrayList<>();
    }

    public void addPath(Path path) {
        this.paths.add(path);
    }

    @Override
    public String toString() {
        return this.paths.toString();
    }

    public List<Path> getPaths() {
        if (this.paths == null) {
            return new ArrayList<>();
        }
        return this.paths;
    }
}
