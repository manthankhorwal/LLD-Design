package LLD.Tic_Tac_Toe;

public interface WinningStrategy {
    boolean checkWin(PlayerSymbol[][] board, PlayerSymbol symbol);
}
