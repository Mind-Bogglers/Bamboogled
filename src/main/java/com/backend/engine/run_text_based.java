package com.backend.engine;

import com.backend.BoggleGame;

public class run_text_based {
    /**
     * Main method.
     * @param args command line arguments.
     **/
    public static void main(String[] args) {
        BoggleGame b = new BoggleGame();
        b.giveInstructions();
        b.playGame();
    }


}
