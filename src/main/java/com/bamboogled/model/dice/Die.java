package com.bamboogled.model.dice;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private final String faces; // The faces of the die.

    /**
     * Constructor for the Die class.
     * @param faces The faces of the die.
     */
    public Die(String faces) {
        this.faces = faces;
    }

    /**
     * Rolls the die.
     * @return The face of the die that is facing up.
     */
    public char roll() {
        return faces.charAt(ThreadLocalRandom.current().nextInt(0, faces.length()));
    }
}
