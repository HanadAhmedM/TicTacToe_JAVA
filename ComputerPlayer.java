// ComputerPlayer.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer implements Player {
    private final String name;
    private final char mark;
    private final Random rng = new Random();

    public ComputerPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public int getMove(Board board, Scanner scanner) {
        // choose random empty cell
        int size = board.getSize();
        List<Integer> empties = new ArrayList<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board.isCellEmpty(r, c)) {
                    int pos = r * size + c + 1;
                    empties.add(pos);
                }
            }
        }
        // tiny delay for UX
        System.out.printf("%s (%c) is thinking...%n", name, mark);
        try { Thread.sleep(400); } catch (InterruptedException ignored) {}
        int choice = empties.get(rng.nextInt(empties.size()));
        System.out.printf("%s chooses %d%n", name, choice);
        return choice;
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
