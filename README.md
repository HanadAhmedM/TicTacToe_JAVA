# Tic-Tac-Toe (Java, Text-Based)

This project is a text-based Tic-Tac-Toe game written in Java.  
It is played in the terminal and supports two human players or one human vs. a computer player.  
The game is fully object-oriented and follows the requirements of the school assignment.

---

## 🎮 Features

- Two-player game (human vs human)
- Optional computer opponent (random AI)
- Fully text-based board visualization
- Validates user input (no crashes from wrong input)
- Detects wins (row, column, diagonal)
- Detects draw when the board is full
- Keeps track of how many games each player has won
- Automatically restarts after each finished game
- Optional custom board size (3x3 default)
- Clear and modular OOP structure

---

## 🧱 Object-Oriented Structure

The program is divided into several classes, each with a clear responsibility:

### **`TicTacToeApp`**
- Contains the `main` method.
- Starts the game.
- Asks for player names.
- Lets the user choose human or computer opponent.
- Creates and starts a `Game` object.

### **`Game`**
- Controls the overall match flow:
  - Whose turn it is
  - Reading moves from players
  - Updating the board
  - Win/draw detection
  - Score counting
  - Asking if players want to play again
- Uses `Player` objects (either human or computer).

### **`Board`**
- Stores the game grid as a 2D array.
- Places marks (X or O) on the board.
- Checks if a cell is empty.
- Checks for win conditions (row, column, diagonals).
- Checks if the board is full.
- Prints the board to the terminal.
- Supports any board size (3x3 by default).

### **`Player` Interface**
- A simple interface defining what every player must have:
  - `getMove()`
  - `getName()`
  - `getMark()`
- Makes it easy to switch between human and computer players.

### **`HumanPlayer`**
- Reads input from the user.
- Validates the input:
  - Must be a number.
  - Must be within the allowed range.
  - Must be an empty cell.

### **`ComputerPlayer`**
- Simple computer opponent.
- Picks a random empty cell.
- Compatible with the `Player` interface, so no special handling is needed.

---

## ▶️ Running the Program

- javac *.java.
- java TicTacToeApp.


