Number Guessing Game:
Welcome to the Number Guessing Game! This is a simple Java GUI application where the user tries to guess a randomly generated number between 1 and 100. The game provides feedback on each guess and keeps track of the score across rounds.

Getting Started
To run the game, simply compile and execute the NumberGuessingGame class. The GUI will appear, allowing you to input your guesses and play the game.

How to Play
Enter your guess in the input field.
Click "Submit Guess" to check your guess.
Start a new round or restart the entire game as needed.

Game Features
Maximum of 10 attempts per round.
Score is calculated based on the number of correct guesses.
Emoji feedback for each guess adds a fun element to the game.

GUI Components
Top Panel: Displays instructions for the game.
Center Panel: Input field for user guesses.
Bottom Panel: Includes buttons for submitting guesses, starting new rounds, and restarting the game. Also displays score, attempts left, and emoji feedback.

Main Methods
checkGuess(): Handles user guesses and updates game state.
generateNewNumber(): Generates a new random number for the user to guess.
startNewRound(): Initiates a new round of the game.
restartGame(): Restarts the entire game.
