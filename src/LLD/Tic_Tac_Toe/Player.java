package LLD.Tic_Tac_Toe;

public class Player {
    String name;

    public Player(String name, PlayerSymbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    PlayerSymbol symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(PlayerSymbol symbol) {
        this.symbol = symbol;
    }
}
