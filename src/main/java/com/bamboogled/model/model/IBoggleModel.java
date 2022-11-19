package com.bamboogled.model.model;

import com.bamboogled.exceptions.*;
import com.bamboogled.model.grid.BoggleGrid;
import com.bamboogled.model.path.Path;
import com.bamboogled.model.player.Player;

import java.util.List;
import java.util.Set;

public interface IBoggleModel {
    void newGame(int dimensionsOfGrid, List<Player> players) throws IllegalArgumentException;
    void startGameForNextPlayer() throws NoMorePlayersException, GameAlreadyInProgressException, PlayerAlreadyPlayedException;
    void endGame() throws GameNotInProgressException;
    void addLetterToCurrentWord(char letter) throws NoPathException;
    boolean submitCurrentWord();
    Path getPathToWord() throws EmptyWordException;
    BoggleGrid getCurrentGrid();
    Player getCurrentPlayer();
    List<Player> getPlayers();
    String getCurrentWord();
    Set<String> getAllWordsOnGrid();
}
