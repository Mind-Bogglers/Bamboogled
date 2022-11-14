package com.backend;


import com.backend.dice.BoardLetterGenerator;
import com.backend.dice.BoardLetterGeneratorBig;
import com.backend.dice.BoardLetterGeneratorSmall;
import com.backend.engine.PathContainerUtils;
import com.backend.engine.PossiblePathContainer;
import com.backend.engine.WordUtils;

import java.util.*;

public class BoggleGame {
    /**
     * scanner used to interact with the user via console
     */
    public Scanner scanner;
    /**
     * stores game statistics
     */
    private BoggleStats gameStats;


    /*
     * BoggleGame constructor
     */
    public BoggleGame() {
        this.scanner = new Scanner(System.in);
        this.gameStats = new BoggleStats();
    }

    /*
     * Provide instructions to the user, so they know how to play the game.
     */
    public void giveInstructions()
    {
        System.out.println("The Boggle board contains a grid of letters that are randomly placed.");
        System.out.println("We're both going to try to find words in this grid by joining the letters.");
        System.out.println("You can form a word by connecting adjoining letters on the grid.");
        System.out.println("Two letters adjoin if they are next to each other horizontally, ");
        System.out.println("vertically, or diagonally. The words you find must be at least 4 letters long, ");
        System.out.println("and you can't use a letter twice in any single word. Your points ");
        System.out.println("will be based on word length: a 4-letter word is worth 1 point, 5-letter");
        System.out.println("words earn 2 points, and so on. After you find as many words as you can,");
        System.out.println("I will find all the remaining words.");
        System.out.println("\nHit return when you're ready...");
    }


    /*
     * Gets information from the user to initialize a new Boggle game.
     * It will loop until the user indicates they are done playing.
     */
    public void playGame(){
        int boardSize;
        BoardLetterGenerator boardLetterGenerator;
        while(true){
            System.out.println("Enter 1 to play on a big (5x5) grid; 2 to play on a small (4x4) one:");
            String choiceGrid = scanner.nextLine();

            //get grid size preference
            if(choiceGrid == "") break; //end game if user inputs nothing
            while(!choiceGrid.equals("1") && !choiceGrid.equals("2")){
                System.out.println("Please try again.");
                System.out.println("Enter 1 to play on a big (5x5) grid; 2 to play on a small (4x4) one:");
                choiceGrid = scanner.nextLine();
            }
            if(choiceGrid.equals("1")) {
                boardLetterGenerator = new BoardLetterGeneratorBig();
                boardSize = 5;
            } else {
                boardLetterGenerator = new BoardLetterGeneratorSmall();
                boardSize = 4;
            }

            //get letter choice preference
            System.out.println("Enter 1 to randomly assign letters to the grid; 2 to provide your own.");
            String choiceLetters = scanner.nextLine();

            if(choiceLetters == "") break; //end game if user inputs nothing
            while(!choiceLetters.equals("1") && !choiceLetters.equals("2")){
                System.out.println("Please try again.");
                System.out.println("Enter 1 to randomly assign letters to the grid; 2 to provide your own.");
                choiceLetters = scanner.nextLine();
            }

            if(choiceLetters.equals("1")){
                playRound(boardSize, boardLetterGenerator.generateString());
            } else {
                System.out.println("Input a list of " + boardSize*boardSize + " letters:");
                choiceLetters = scanner.nextLine();
                while(!(choiceLetters.length() == boardSize*boardSize)){
                    System.out.println("Sorry, bad input. Please try again.");
                    System.out.println("Input a list of " + boardSize*boardSize + " letters:");
                    choiceLetters = scanner.nextLine();
                }
                playRound(boardSize,choiceLetters.toUpperCase());
            }

            //round is over! So, store the statistics, and end the round.
            this.gameStats.summarizeRound();
            this.gameStats.endRound();

            //Shall we repeat?
            System.out.println("Play again? Type 'Y' or 'N'");
            String choiceRepeat = scanner.nextLine().toUpperCase();

            if(choiceRepeat == "") break; //end game if user inputs nothing
            while(!choiceRepeat.equals("Y") && !choiceRepeat.equals("N")){
                System.out.println("Please try again.");
                System.out.println("Play again? Type 'Y' or 'N'");
                choiceRepeat = scanner.nextLine().toUpperCase();
            }

            if(choiceRepeat == "" || choiceRepeat.equals("N")) break; //end game if user inputs nothing

        }

        //we are done with the game! So, summarize all the play that has transpired and exit.
        this.gameStats.summarizeGame();
        System.out.println("Thanks for playing!");
    }

    /*
     * Play a round of Boggle.
     * This initializes the main objects: the board, the dictionary, the map of all
     * words on the board, and the set of words found by the user. These objects are
     * passed by reference from here to many other functions.
     */
    public void playRound(int size, String letters){
        //step 1. initialize the grid
        BoggleGrid grid = new BoggleGrid(size);
        grid.initalizeBoard(letters);
        //step 2. initialize the dictionary of legal words
        Dictionary boggleDict = new Dictionary("src/main/java/com/backend/wordlist.txt"); //you may have to change the path to the wordlist, depending on where you place it.
        //step 3. find all legal words on the board, given the dictionary and grid arrangement.
        long theTime1 = System.nanoTime();
        double timeInSeconds1 = (double) theTime1 / 1_000_000_000;
        Set<String> allWords = WordUtils.findAllWords(boggleDict, grid);
        long theTime2 = System.nanoTime();
        double timeInSeconds2 = (double) theTime2 / 1_000_000_000;
        System.out.println("TIME: " + (timeInSeconds2 - timeInSeconds1));
        //step 4. allow the user to try to find some words on the grid
        humanMove(grid, allWords);
        //step 5. allow the computer to identify remaining words
        computerMove(allWords);
    }

    /*
     * Gets words from the user.  As words are input, check to see that they are valid.
     * If yes, add the word to the player's word list (in boggleStats) and increment
     * the player's score (in boggleStats).
     * End the turn once the user hits return (with no word).
     *
     * @param board The boggle board
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     */
    private void humanMove(BoggleGrid board, Set<String> allWords){
        PossiblePathContainer container;
        System.out.println("It's your turn to find some words!");
        while(true) {
            container = null;
            //You write code here!
            //step 1. Print the board for the user, so they can scan it for words
            //step 2. Get a input (a word) from the user via the console
            //step 3. Check to see if it is valid (note validity checks should be case-insensitive)
            //step 4. If it's valid, update the player's word list and score (stored in boggleStats)
            //step 5. Repeat step 1 - 4
            //step 6. End when the player hits return (with no word choice).
            System.out.println(board.toString());
            String word = scanner.nextLine().toUpperCase();
            if (Objects.equals(word, "")) {
                break;
            }
            System.out.println(allWords);
            for (char c: word.toCharArray()) {
                container = PathContainerUtils.fetchContainer(container, board, c);
                System.out.println(container);

            }
            if (allWords.contains(word) && container.getPaths().size() > 0 && !gameStats.getPlayerWords().contains(word)) {
                gameStats.addWord(word, BoggleStats.Player.Human);
                System.out.println("Nice! You earned " + (1 + word.length() - 4) + " point(s)!");
            } else {
                System.out.println("Sorry, that's not a valid word. Maybe you guessed it before, the length is less than 4, you can't find it on the board, or it's not in the word list.");
            }
        }
    }


    /*
     * Gets words from the computer.  The computer should find words that are
     * both valid and not in the player's word list.  For each word that the computer
     * finds, update the computer's word list and increment the
     * computer's score (stored in boggleStats).
     *
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     */
    private void computerMove(Set<String> all_words){
        Set<String> playerWords = gameStats.getPlayerWords();
        for (String word: all_words) {
            if (!playerWords.contains(word)) {
                gameStats.addWord(word, BoggleStats.Player.Computer);
            }
        }
    }
}
