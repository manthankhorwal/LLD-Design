package LLD.Tic_Tac_Toe;

public class TicTacToeBoard implements Board {
    int size;
    PlayerSymbol[][] board;

    public TicTacToeBoard(int size) {
        this.size = size;
        this.board = new PlayerSymbol[size][size];
    }

    @Override
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == null ? "-" : board[i][j] );
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean makeMove(int row, int col, PlayerSymbol playerSymbol) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != null) {
            return false;
        }
        board[row][col] = playerSymbol;
        return true;
    }

    @Override
    public boolean isFull() {
        for (PlayerSymbol[] row : board) {
            for (PlayerSymbol cell : row) {
                if (cell == null) return false;
            }
        }
        return true;
    }

    @Override
    public PlayerSymbol[][] getBoard() {
        return board;
    }
}
