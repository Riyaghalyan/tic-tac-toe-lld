package tictactoe;

/**
 * @author riyaghalyan
 * represents the symbol at particular cell
 */
public class Cell {

    private final int row;
    private final int col;
    private String symbol;


    public Cell(int row, int col, String symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
}
