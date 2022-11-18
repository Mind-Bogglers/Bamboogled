package com.bamboogled.model.model;

import com.bamboogled.exceptions.*;
import com.bamboogled.model.grid.BoggleGrid;
import com.bamboogled.model.path.Path;
import com.bamboogled.model.player.Player;

import java.util.List;

public interface IBoggleModel {
    void newGame(int dimensionsOfGrid, List<Player> players) throws IllegalArgumentException;
    void startGameForNextPlayer() throws NoMorePlayersException, GameAlreadyInProgressException, PlayerAlreadyPlayedException;
    void startGame(Player player) throws GameAlreadyInProgressException, PlayerAlreadyPlayedException;
    void endGame() throws GameNotInProgressException;
    void addLetterToCurrentWord(char letter) throws NoPathException;
    boolean submitCurrentWord();
    Path getPathToWord() throws EmptyWordException;
    BoggleGrid getCurrentGrid();
    Player getCurrentPlayer();
    String getCurrentWord();
}
