package tictactoe;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * let's start the game
 */
public class Game {
    private final Board board;
    private final List<Player> players;
    private int currentTurn;
    private final int n;

    public Game(int n, List<Player> players) {
        this.board = new Board(n);
        this.players = players;
        this.n = n;
        this.currentTurn = 0;
    }

    public void playGame() {
        int moves = 0;
        int maxMoves = board.getSize() * board.getSize();
        Scanner scn = new Scanner(System.in);
        while (true) {
            Player current = players.get(currentTurn);
            System.out.println(current.getName() + "'s turn");
            System.out.println("pls select row and col");
            int row = scn.nextInt();
            int col = scn.nextInt();
            boolean canWe = board.isValidMove(row, col);
            if (!canWe) {
                System.out.println("Invalid move, try again.");
                continue; // don’t end game, just let same player try again
            }
            board.makeMove(row, col, current.getSymbol());
            board.printBoard();
            if (checkWinner(row, col, current)) {
                board.printBoard();
                System.out.println(current.getName() + " wins!");
                break;
            }
            moves++;
            if (moves == maxMoves) {
                board.printBoard();
                System.out.println("Game Draw!");
                break;
            }
            currentTurn = (currentTurn + 1) % players.size(); // so that thing will work for n players
        }
    }

    private boolean checkWinner(int row, int col, Player current) {
        String symbol = current.getSymbol();
        String name = current.getName();
        int n = board.getSize();
        boolean winRow = true;
        // checking row here
        for (int j = 0; j < n; j++) {
            if (!Objects.equals(board.getCells()[row][j].getSymbol(), symbol)) {
                winRow = false;
                break;
            }
        }
        if (winRow) {
            System.out.println(name + " wins");
            return true;
        }
        // checking column here
        boolean winCol = true;
        for (int i = 0; i < n; i++) {
            if (!Objects.equals(board.getCells()[i][col].getSymbol(), symbol)) {
                winCol = false;
                break;
            }
        }
        if (winCol) {
            System.out.println(name + " wins");
            return true;
        }
        // checking diagonal here
        if (row == col) {
            boolean winDiag = true;
            for (int i = 0; i < n; i++) {
                if (!Objects.equals(board.getCells()[i][i].getSymbol(), symbol)) {
                    winDiag = false;
                    break;
                }
            }
            if (winDiag) {
                System.out.println(name + " wins");
                return true;
            }
        }
        // anti diagonal
        if (row + col == n - 1) {
            boolean winAntiDiag = true;
            for (int i = 0; i < n; i++) {
                if (!Objects.equals(board.getCells()[i][n - 1 - i].getSymbol(), symbol)) {
                    winAntiDiag = false;
                    break;
                }
            }
            if (winAntiDiag) {
                System.out.println(name + " wins");
                return true;
            }
        }
        return false;

    }

}
