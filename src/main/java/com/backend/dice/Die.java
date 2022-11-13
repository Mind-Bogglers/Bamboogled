package com.backend.dice;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private final String faces;

    public Die(String faces) {
        this.faces = faces;
    }
    public char roll() {
        return faces.charAt(ThreadLocalRandom.current().nextInt(0, faces.length()));
    }
}
