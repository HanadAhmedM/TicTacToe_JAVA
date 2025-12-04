// TicTacToeApp.java
import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        int boardSize = 3;
        // optional: ask for board size (flexibility extra requirement)
        System.out.print("Use standard 3x3 board? (y) or enter custom size (>=3) : ");
        String sizeInput = scanner.nextLine().trim();
        if (!sizeInput.isEmpty() && !sizeInput.equalsIgnoreCase("y")) {
            try {
                int s = Integer.parseInt(sizeInput);
                if (s >= 3) boardSize = s;
                else System.out.println("Invalid size, using 3.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, using 3.");
            }
        }

        // ask for player names
        System.out.print("Enter name for Player X: ");
        String nameX = scanner.nextLine().trim();
        if (nameX.isEmpty()) nameX = "Player X";

        System.out.print("Play against (1) Human or (2) Computer? Enter 1 or 2: ");
        String opp = scanner.nextLine().trim();
        Player playerO;
        Player playerX = new HumanPlayer(nameX, 'X');

        if (opp.equals("2")) {
            String botName = "Computer";
            System.out.print("Enter name for Computer (or press Enter for 'Computer'): ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) botName = input;
            playerO = new ComputerPlayer(botName, 'O');
        } else {
            System.out.print("Enter name for Player O: ");
            String nameO = scanner.nextLine().trim();
            if (nameO.isEmpty()) nameO = "Player O";
            playerO = new HumanPlayer(nameO, 'O');
        }

        Game game = new Game(boardSize, playerX, playerO, scanner);
        game.playSeries();

        scanner.close();
    }
}
