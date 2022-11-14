package com.backend.dice;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

//This class is used to generate a string of random letters, which is used to initialize a BoggleGrid.
public abstract class BoardLetterGenerator {
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
        HashSet<Integer> available = new HashSet<>(); // The indices of the dice that have not been used yet.
        for (int i = 0; i < dice.length; i++) {
            available.add(i);
        }
        for (int i = 0; i < dice.length; i++) {
            randomIndex = ThreadLocalRandom.current().nextInt(0, available.size()); // Generate a random index.
            ans += dice[randomIndex].roll(); // Roll the die at the random index and add the letter on the face to ans.
            available.remove(randomIndex); // Remove the index from the set of available indices.
        }
        return ans;
    }
}
