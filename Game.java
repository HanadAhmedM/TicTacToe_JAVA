// Game.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private final Scanner scanner;
    private final Map<String, Integer> wins; // player name -> wins

    public Game(int boardSize, Player x, Player o, Scanner scanner) {
        this.board = new Board(boardSize);
        this.playerX = x;
        this.playerO = o;
        this.scanner = scanner;
        wins = new HashMap<>();
        wins.put(playerX.getName(), 0);
        wins.put(playerO.getName(), 0);
    }

    public void playSeries() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            playSingleGame();
            displayScores();
            keepPlaying = askPlayAgain();
        }
        System.out.println("Thanks for playing! Final scores:");
        displayScores();
    }

    private void playSingleGame() {
        board.clear();
        Player current = playerX;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.printf("Current board:%n");
            board.display();

            int pos = current.getMove(board, scanner);
            int size = board.getSize();
            int row = (pos - 1) / size;
            int col = (pos - 1) % size;
            boolean placed = board.placeMark(row, col, current.getMark());
            if (!placed) {
                System.out.println("Could not place mark — try again.");
                continue; // ask again
            }

            // Check win
            if (board.hasWon(current.getMark())) {
                board.display();
                System.out.printf("Player %s (%c) wins!%n", current.getName(), current.getMark());
                wins.put(current.getName(), wins.get(current.getName()) + 1);
                gameOver = true;
                break;
            }

            // Check draw
            if (board.isFull()) {
                board.display();
                System.out.println("The game is a draw!");
                gameOver = true;
                break;
            }

            // switch player
            current = (current == playerX) ? playerO : playerX;
        }
    }

    private void displayScores() {
        System.out.println("Scores:");
        for (Map.Entry<String, Integer> e : wins.entrySet()) {
            System.out.printf("%s : %d%n", e.getKey(), e.getValue());
        }
    }

    private boolean askPlayAgain() {
        while (true) {
            System.out.print("Play another game? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
            System.out.println("Please answer 'y' or 'n'.");
        }
    }
}
