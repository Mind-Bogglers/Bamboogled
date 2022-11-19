package com.bamboogled.model.model;

import com.bamboogled.exceptions.*;
import com.bamboogled.model.grid.BoggleGrid;
import com.bamboogled.model.path.Path;
import com.bamboogled.model.player.Player;

import java.util.List;

public interface IBoggleModel {
    public void newGame(int dimensionsOfGrid, List<Player> players) throws IllegalArgumentException;
    public void startGameForNextPlayer() throws NoMorePlayersException, GameAlreadyInProgressException, PlayerAlreadyPlayedException;
    public void startGame(Player player) throws GameAlreadyInProgressException, PlayerAlreadyPlayedException;
    public void endGame();
    public void addLetterToCurrentWord(char letter) throws NoPathException;
    public boolean submitCurrentWord();
    public Path getPathToWord() throws EmptyWordException;
    public BoggleGrid getCurrentGrid();
    public Player getCurrentPlayer();
    public String getCurrentWord();
}
