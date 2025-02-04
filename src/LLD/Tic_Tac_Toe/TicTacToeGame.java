package LLD.Tic_Tac_Toe;

import java.util.Scanner;

public class TicTacToeGame {
    Board board;
    Player[] players;
    int currPlayerIndex;
    WinningStrategy winningStrategy;

    public TicTacToeGame(int size, Player player1,Player player2, WinningStrategy winningStrategy) {
        this.board = new TicTacToeBoard(size);
        this.players = new Player[]{player1,player2};
        this.currPlayerIndex = 0;
        this.winningStrategy = winningStrategy;
    }

    void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.displayBoard();
            Player currentPlayer = players[currPlayerIndex];
            System.out.println(currentPlayer.getName()+ "'s turn");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!board.makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid Move");
                continue;
            }
            if (winningStrategy.checkWin(board.getBoard(), currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName()+ " having "+ currentPlayer.getSymbol() + " is the winner");
                break;
            }
            if (board.isFull()) {
                System.out.println("Board is full , please try new game");
                break;
            }
            currPlayerIndex = currPlayerIndex == 1 ? 0 : 1;
        }

    }
}
