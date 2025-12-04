// HumanPlayer.java
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String name;
    private final char mark;

    public HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public int getMove(Board board, Scanner scanner) {
        int size = board.getSize();
        int max = size * size;
        while (true) {
            System.out.printf("%s (%c), choose a cell (1-%d):%n> ", name, mark, max);
            String input = scanner.nextLine().trim();
            // robust parsing
            try {
                int pos = Integer.parseInt(input);
                if (pos < 1 || pos > max) {
                    System.out.printf("Please enter a number between 1 and %d.%n", max);
                    continue;
                }
                int row = (pos - 1) / size;
                int col = (pos - 1) % size;
                if (!board.isCellEmpty(row, col)) {
                    System.out.println("That cell is already taken. Choose another one.");
                    continue;
                }
                return pos;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Enter the cell number (e.g. 5).");
            }
        }
    }

    @Override
    public char getMark() {
        return mark;
    }

    @Override
    public String getName() {
        return name;
    }
}
