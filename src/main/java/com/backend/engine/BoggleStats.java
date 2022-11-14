package com.backend.engine;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The BoggleStats class for the first Assignment in CSC207, Fall 2022
 * The BoggleStats will contain statsitics related to game play Boggle 
 */
public class BoggleStats {

    /**
     * set of words the player finds in a given round 
     */  
    private Set<String> playerWords = new HashSet<String>();  
    /**
     * set of words the computer finds in a given round 
     */  
    private Set<String> computerWords = new HashSet<String>();  
    /**
     * the player's score for the current round
     */  
    private int pScore; 
    /**
     * the computer's score for the current round
     */  
    private int cScore; 
    /**
     * the player's total score across every round
     */  
    private int pScoreTotal; 
    /**
     * the computer's total score across every round
     */  
    private int cScoreTotal; 
    /**
     * the average number of words, per round, found by the player
     */  
    private double pAverageWords; 
    /**
     * the average number of words, per round, found by the computer
     */  
    private double cAverageWords; 
    /**
     * the current round being played
     */  
    private int round; 

    /**
     * enumarable types of players (human or computer)
     */  
    public enum Player {
        Human("Human"),
        Computer("Computer");
        private final String player;
        Player(final String player) {
            this.player = player;
        }
    }

    /* BoggleStats constructor
     * ----------------------
     * Sets round, totals and averages to 0.
     * Initializes word lists (which are sets) for computer and human players.
     */
    public BoggleStats() {
        this.round = 0;
        this.pScore = 0;
        this.pAverageWords = 0;
        this.pScoreTotal = 0;
        this.cScore = 0;
        this.cAverageWords = 0;
        this.cScoreTotal = 0;
    }

    /* 
     * Add a word to a given player's word list for the current round.
     * You will also want to increment the player's score, as words are added.
     *
     * @param word     The word to be added to the list
     * @param player  The player to whom the word was awarded
     */
    public void addWord(String word, Player player) {
        if (Objects.equals(player.player, "Human")) {
            this.playerWords.add(word);
            this.pScore += 1 + word.length() - 4;
        } else {
            this.computerWords.add(word);
            this.cScore += 1 + word.length() - 4;
        }
    }

    /* 
     * End a given round.
     * This will clear out the human and computer word lists, so we can begin again.
     * The function will also update each player's total scores, average scores, and
     * reset the current scores for each player to zero.
     * Finally, increment the current round number by 1.
     */
    public void endRound() {


        this.pScoreTotal += this.pScore;
        this.cScoreTotal += this.cScore;

        this.pAverageWords = (this.pAverageWords * this.round + this.playerWords.size()) / (this.round + 1);
        this.cAverageWords = (this.cAverageWords * this.round + this.computerWords.size()) / (this.round + 1);

        this.playerWords = new HashSet<String>();
        this.computerWords = new HashSet<String>();

        this.pScore = 0;
        this.cScore = 0;

        this.round++;
    }

    /* 
     * Summarize one round of boggle.  Print out:
     * The words each player found this round.
     * Each number of words each player found this round.
     * Each player's score this round.
     */
    public void summarizeRound() {
        System.out.println("*****ROUND SUMMARY*****");
        System.out.println("YOU FOUND " + playerWords.size() + " VALID WORDS. THE WORDS YOU FOUND ARE: ");
        for (String s: playerWords) {
            System.out.println("- " + s);
        }
        System.out.println("I FOUND " + computerWords.size() + " VALID WORDS. THE WORDS I FOUND ARE: ");
        for (String s: computerWords) {
            System.out.println("- " + s);
        }
        System.out.println("YOUR SCORE THIS ROUND WAS: " + this.pScore + ".");
        System.out.println("MY SCORE THIS ROUND WAS: " + this.cScore + ".");
    }

    /* 
     * Summarize the entire boggle game.  Print out:
     * The total number of rounds played.
     * The total score for either player.
     * The average number of words found by each player per round.
     */
    public void summarizeGame() {
        System.out.println("*****GAME SUMMARY*****");
        System.out.println("WE PLAYED " + round + " ROUNDS.");
        System.out.println("YOU SCORED " + pScoreTotal + " TOTAL POINTS.");
        System.out.println("I SCORED " + cScoreTotal + " TOTAL POINTS.");
        System.out.println("YOU FOUND AN AVERAGE OF " + pAverageWords + " WORDS EVERY ROUND.");
        System.out.println("I FOUND AN AVERAGE OF " + cAverageWords + " WORDS EVERY ROUND.");
        System.out.println("GOOD GAME! IT WAS NICE PLAYING WITH YOU!");
    }

    /* 
     * @return Set<String> The player's word list
     */
    public Set<String> getPlayerWords() {
        return this.playerWords;
    }

    /*
     * @return int The number of rounds played
     */
    public int getRound() { return this.round; }

    /*
    * @return int The current player score
    */
    public int getScore() {
        return this.pScore;
    }

}
