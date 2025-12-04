// Board.java
public class Board {
    private final int size;
    private final char[][] grid;
    private final char EMPTY = ' ';

    public Board(int size) {
        if (size < 3) size = 3;
        this.size = size;
        grid = new char[size][size];
        clear();
    }

    public void clear() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = EMPTY;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == EMPTY;
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        if (!isCellEmpty(row, col)) return false;
        grid[row][col] = mark;
        return true;
    }

    public boolean isFull() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c] == EMPTY) return false;
            }
        }
        return true;
    }

    // Check if `mark` has won (N in a row)
    public boolean hasWon(char mark) {
        // check rows
        for (int r = 0; r < size; r++) {
            boolean rowWin = true;
            for (int c = 0; c < size; c++) {
                if (grid[r][c] != mark) { rowWin = false; break; }
            }
            if (rowWin) return true;
        }

        // check cols
        for (int c = 0; c < size; c++) {
            boolean colWin = true;
            for (int r = 0; r < size; r++) {
                if (grid[r][c] != mark) { colWin = false; break; }
            }
            if (colWin) return true;
        }

        // main diagonal
        boolean diag1 = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != mark) { diag1 = false; break; }
        }
        if (diag1) return true;

        // anti-diagonal
        boolean diag2 = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][size - 1 - i] != mark) { diag2 = false; break; }
        }
        return diag2;
    }

    public void display() {
        // show numbers for empty cells to make picking easy
        int total = size * size;
        System.out.println();
        for (int r = 0; r < size; r++) {
            StringBuilder line = new StringBuilder();
            for (int c = 0; c < size; c++) {
                char ch = grid[r][c];
                if (ch == EMPTY) {
                    int label = r * size + c + 1;
                    line.append(String.format(" %2d ", label));
                } else {
                    line.append("  " + ch + " ");
                }
                if (c < size - 1) line.append("|");
            }
            System.out.println(line.toString());
            if (r < size - 1) {
                StringBuilder sep = new StringBuilder();
                for (int c = 0; c < size; c++) {
                    sep.append("---");
                    if (c < size - 1) sep.append("+");
                }
                System.out.println(sep.toString());
            }
        }
        System.out.println();
    }
}
