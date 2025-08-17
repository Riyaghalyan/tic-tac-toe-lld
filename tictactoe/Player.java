package tictactoe;

import java.util.UUID;

/**
 * @author riyaghalyan
 *  player class
 */
public class Player {

    private final String id;
    private final String name;
    private final String symbol;

    public Player(String name, String symbol) {
        this.id = UUID.randomUUID().toString().replace("-", "");;
        this.name = name;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
