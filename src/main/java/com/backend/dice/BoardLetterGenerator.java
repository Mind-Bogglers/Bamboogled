package com.backend.dice;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BoardLetterGenerator {
    // This class is used to generate a string of random letters, which is used for the board.

    private Die[] dice; // The dice used to generate the letters.

    /**
     * Constructor for the BoardLetterGenerator class.
     * @param dice The dice used to generate the letters.
     */
    BoardLetterGenerator(Die[] dice) {
        this.dice = dice;
    }

    /**
     * Generates a string of random letters, which is used for the board.
     * @return A string of random letters.
     */
    public String generateString() {
        int randomIndex;
        String ans = "";
        HashSet<Integer> available = new HashSet<>();
        for (int i = 0; i < dice.length; i++) {
            available.add(i);
        }
        for (int i = 0; i < dice.length; i++) {
            randomIndex = ThreadLocalRandom.current().nextInt(0, available.size());
            ans += dice[randomIndex].roll();
            available.remove(randomIndex);
        }
        return ans;
    }
}
