package com.backend.dice;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BoardLetterGenerator {
    private Die[] dice;

    BoardLetterGenerator(Die[] dice) {
        this.dice = dice;
    }

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
