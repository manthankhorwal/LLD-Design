package LLD.Tic_Tac_Toe;

public class ClassicWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(PlayerSymbol[][] board, PlayerSymbol symbol) {
        return checkRow(board, symbol) || checkColumn(board, symbol) || checkDiagonal(board, symbol);
    }

    private boolean checkDiagonal(PlayerSymbol[][] board, PlayerSymbol symbol) {
        boolean diag1 = true, diag2 = true;
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) diag1 = false;
            if (board[i][size - i - 1] != symbol) diag2 = false;
        }
        return diag1 || diag2;
    }

    private boolean checkRow(PlayerSymbol[][] board, PlayerSymbol symbol) {
        int n = board.length;
        int i, j;
        for (i = 0; i < n; i++) {  //row
            for (j = 0; j < n; j++) {
                if (board[i][j] != symbol) {
                    break;
                }
            }
            if (j == n)
                return true;
        }
        return false;
    }

    private boolean checkColumn(PlayerSymbol[][] board, PlayerSymbol symbol) {
        int n = board.length;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (board[j][i] != symbol) {
                    break;
                }
            }
            if (j == n)
                return true;
        }
        return false;
    }
}
