package com.bamboogled.model.player;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final String name;
    private int score;
    private Set<String> foundWords;
    boolean played;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.foundWords = new HashSet<>();
        this.played = false;
    }

    public void addWord(String word) {
        this.foundWords.add(word);
        this.score += word.length() - 3;
    }

    public String getName() {
        return this.name;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public Set<String> getFoundWords() {
        return this.foundWords;
    }

    public void clearFoundWords() {
        this.foundWords.clear();
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public boolean hasPlayed() {
        return this.played;
    }
}
