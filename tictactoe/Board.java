package tictactoe;

import java.util.Objects;

/**
 * tic-tac-toe board
 */
public class Board {

    private final int n;
    private final Cell[][] cells;

    public Board(int n) {
        this.n = n;
        this.cells = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell(i, j, " ");
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        if(row >= n || row < 0 || col >= n || col < 0 || !Objects.equals(cells[row][col].getSymbol(), " ")) {
            return false;
        }
        return true;
    }

    public void makeMove(int row, int col, String symbol) {
        cells[row][col].setSymbol(symbol);
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cells[i][j].getSymbol());
                if (j < n - 1) System.out.print(" | "); // separator
            }
            System.out.println();
            if (i < n - 1) {
                System.out.println("-".repeat(n * 4 - 3)); // row divider
            }
        }
    }

    public int getSize(){
        return n;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
