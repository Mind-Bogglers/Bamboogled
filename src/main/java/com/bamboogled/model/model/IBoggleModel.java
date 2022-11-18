package com.bamboogled.model.model;

import com.bamboogled.model.grid.BoggleGrid;
import com.bamboogled.model.path.NoPathException;
import com.bamboogled.model.path.Path;
import com.bamboogled.model.player.Player;
import com.bamboogled.model.stats.BoggleStats;

import java.util.List;
import java.util.Set;

public interface IBoggleModel {
    public void newGame(int dimensionsOfGrid, List<Player> players) throws IllegalArgumentException;

    public void startGame(Player player) throws IllegalArgumentException;

    void endGame();

    public void addLetterToCurrentWord(char letter) throws NoPathException;
    public boolean submitCurrentWord();
    public Path getPathToWord() throws IllegalStateException;
    public BoggleGrid getCurrentGrid();
}
