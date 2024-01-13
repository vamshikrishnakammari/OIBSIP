// Importing necessary packages for the GUI and event handling  (12,34,)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


// Main class representing the modified Number Guessing Game as a JFrame

public class NumberGuessingGame extends JFrame {

    private final Random random = new Random(); // Random number generator
    private int targetNumber; // The number to be guessed
    private final int maxAttempts = 10; // Maximum number of attempts allowed
    private int attempts = 0; // Current number of attempts
    private int totalScore = 0; // Accumulated score across rounds
    private int roundsPlayed = 0; // Number of rounds played
    private int correctGuessesInRound = 0; // Number of correct guesses in the current round


    // GUI components

    private JTextField guessTextField; // Input field for user's guess
    private JLabel resultLabel; // Label to display game results
    private JLabel scoreLabel; // Label to display the score
    private JLabel attemptsLabel; // Label to display remaining attempts
    private JLabel emojiLabel; // Label to display emojis based on game state


    // Constructor for the main game class

    public NumberGuessingGame() {

        setTitle("Number Guessing Game"); // Set the title of the JFrame
        setSize(400, 300); // Set the size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation

        initializeComponents(); // Initialize GUI components
        generateNewNumber(); // Generate a new random number to start the game

        setLayout(new BorderLayout()); // Set the layout for the JFrame
        add(createTopPanel(), BorderLayout.NORTH); // Add the top panel
        add(createCenterPanel(), BorderLayout.CENTER); // Add the center panel
        add(createBottomPanel(), BorderLayout.SOUTH); // Add the bottom panel

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible

    }


    // Method to initialize GUI components

    private void initializeComponents() {

        guessTextField = new JTextField(10); // Input field for user's guess
        guessTextField.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size
        resultLabel = new JLabel("Take a guess!"); // Label to display game results
        scoreLabel = new JLabel("Score: 0"); // Label to display the score
        attemptsLabel = new JLabel("Guesses Left: " + (maxAttempts - attempts)); // Label to display remaining attempts
        emojiLabel = new JLabel("😊"); // Label to display emojis

        // Font style for labels
        Font labelFont = new Font("Arial", Font.BOLD, 16);

        // Add ActionListener to the guessTextField
        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess(); // Handle user's guess
            }
        });
    }


    // Method to create the top panel of the GUI

    private JPanel createTopPanel() {

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.YELLOW);
        topPanel.add(new JLabel("Guess the number between 1 and 100:"));
        return topPanel;
    }


    // Method to create the center panel of the GUI

    private JPanel createCenterPanel() {

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBackground(Color.CYAN);

        centerPanel.add(guessTextField); // Add the guess input field

        return centerPanel;
    }



    // Method to create the bottom panel of the GUI

    private JPanel createBottomPanel() {

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 1));
        bottomPanel.setBackground(Color.PINK);


        // Creating buttons panel with "Submit Guess" and "New Round" buttons

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("Submit Guess");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess(); // Handle user's guess
            }
        });


        JButton newRoundButton = new JButton("New Round");
        newRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewRound(); // Start a new round
            }
        });


        // New Restart Game button and its ActionListener

        JButton restartButton = new JButton("Restart Game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame(); // Restart the entire game
            }
        });


        buttonsPanel.add(submitButton);
        buttonsPanel.add(newRoundButton);
        buttonsPanel.add(restartButton); // Added Restart Game button



        // Creating information panel with score and attempts labels
        JPanel infoPanel = new JPanel(new GridLayout(1, 2));
        infoPanel.add(scoreLabel);
        infoPanel.add(attemptsLabel);



        // Creating result panel with emoji and result labels
        JPanel resultPanel = new JPanel(new FlowLayout());
        resultPanel.add(emojiLabel);
        resultPanel.add(resultLabel);

        bottomPanel.add(infoPanel);
        bottomPanel.add(resultPanel);
        bottomPanel.add(buttonsPanel);

        return bottomPanel;
    }



    // Method to generate a new random number for the user to guess
    private void generateNewNumber() {
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;
        resultLabel.setText("Take a guess!");
        guessTextField.setText("");
        correctGuessesInRound = 0;
        updateScoreLabel();
        updateAttemptsLabel();
        updateEmojiLabel("😊");
    }



    // Method to start a new round of the game

    private void startNewRound() {

        if (roundsPlayed == 1) {
            generateNewNumber();
            roundsPlayed++;
        } else {
            resultLabel.setText("Game Over! Total Score: " + totalScore + " | Correct Number: " + targetNumber);
            updateEmojiLabel("🎉");
        }
    }



    // Method to update the score label based on the current round's performance

    private void updateScoreLabel() {

        scoreLabel.setText("Round " + roundsPlayed + " Score: " + correctGuessesInRound);
    }


    // Method to update the attempts label based on the remaining attempts
    private void updateAttemptsLabel() {
        attemptsLabel.setText("Guesses Left: " + (maxAttempts - attempts));
    }


    // Method to update the emoji label with the specified emoji
    private void updateEmojiLabel(String emoji) {
        emojiLabel.setText(emoji);
    }


    // Method to handle the user's guess and check it against the target number

    private void checkGuess() {

        try {
            int userGuess = Integer.parseInt(guessTextField.getText());
            attempts++;

            // Check if the user's guess is correct
            if (userGuess == targetNumber) {
                resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                correctGuessesInRound++;
                totalScore += calculateScore();
                updateScoreLabel();
                startNewRound();
                updateEmojiLabel("🎉");
            } else if (userGuess < targetNumber) {
                resultLabel.setText("Too low. Try again!");
                updateEmojiLabel("🔽");
            } else {
                resultLabel.setText("Too high. Try again!");
                updateEmojiLabel("🔼");
            }


            // Check if the maximum number of attempts is reached
            if (attempts == maxAttempts) {
                resultLabel.setText("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                startNewRound();
                updateEmojiLabel("😢");
            }



            // Update attempts label and clear user input

            updateAttemptsLabel();
            guessTextField.setText(""); // Clear user input after each guess
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }



    // Method to calculate the score based on the user's performance
    private int calculateScore() {
        // You can customize the scoring logic based on attempts, time taken, etc.
        return maxAttempts - attempts + 1;
    }



    // Method to restart the entire game

    private void restartGame() {
        roundsPlayed = 0;
        totalScore = 0;
        generateNewNumber();
        resultLabel.setText("Take a guess!");
        updateScoreLabel();
        updateAttemptsLabel();
        updateEmojiLabel("😊");
    }



    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame();
            }
        });
    }
}
