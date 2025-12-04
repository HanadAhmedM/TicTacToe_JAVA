// Player.java
import java.util.Scanner;

public interface Player {
    // return a 1-based position (1..size*size)
    int getMove(Board board, Scanner scanner);
    char getMark();
    String getName();
}
