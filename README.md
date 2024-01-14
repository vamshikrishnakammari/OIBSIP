
Number Guessing Game and ATM Interface Readme
Overview:
This repository contains the code for two distinct tasks as part of a Java Development Internship. The tasks are as follows:

Number Guessing Game:

A Java Swing-based GUI application where the user attempts to guess a randomly generated number.
The game allows a maximum of 10 attempts per round and provides feedback on each guess.
The score is calculated based on the number of correct guesses in a round, and the game includes features like starting a new round and restarting the entire game.
ATM Interface:

A console-based ATM interface implemented in Java.
Users can log in with a user ID and PIN, perform transactions such as viewing transaction history, withdrawing funds, depositing funds, transferring funds, and logging out.
The system maintains user credentials, account balances, and transaction history using HashMaps.
Technologies and Methodologies Used:
Number Guessing Game:
Java Swing:
The GUI components are built using Java Swing, providing a user-friendly interface.
Event Handling:
ActionListener is used to handle events like button clicks and user input.
Random Number Generation:
The Random class is employed to generate a random number for each round of the game.
ATM Interface:
Java:
The core language for implementing the ATM system.
HashMaps:
Utilized to store user credentials, account balances, and transaction history efficiently.
Object-Oriented Programming (OOP):
The code is structured using OOP principles, with classes for transaction history, withdrawal, deposit, and transfer.
Input Handling:
Scanner is used to capture user input for login and transaction processes.
How to Run:
Number Guessing Game:
Compile the Java file: javac NumberGuessingGame.java
Run the compiled class file: java NumberGuessingGame
ATM Interface:
Compile the Java file: javac ATMMain.java
Run the compiled class file: java ATMMain
Code Structure:
Number Guessing Game:
NumberGuessingGame.java:
Main class that extends JFrame and initializes the game components.
Methods for initializing components, creating GUI panels, generating a new number, handling user guesses, and managing rounds.
ATM Interface:
ATMMain.java:
Main class that includes the main method for running the ATM system.
Methods for user validation, displaying the menu, and handling different transaction types.
TransactionHistory.java, Withdrawal.java, Deposit.java, Transfer.java:
Helper classes containing methods for showing transaction history and performing withdrawal, deposit, and transfer transactions.
Task Completion and Additional Notes:
Number Guessing Game:

Tasks 2 and 3 have been successfully implemented.
The game provides an interactive and engaging user experience with feedback and scoring.
ATM Interface:

The tasks have been implemented, providing essential ATM functionalities.
The system maintains user information securely using HashMaps.
Future Improvements:
Number Guessing Game:

Implementing a more sophisticated scoring system or difficulty levels.
Enhancing the GUI with additional features or themes.
ATM Interface:

Implementing additional security features.
Adding error handling for user input.
