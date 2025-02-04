package LLD.Tic_Tac_Toe;

public interface Board {
    void displayBoard();

    boolean makeMove(int row, int col, PlayerSymbol playerSymbol);

    boolean isFull();

    PlayerSymbol[][] getBoard();
}
