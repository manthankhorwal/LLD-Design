package LLD.Tic_Tac_Toe;

public class Client {
    public static void main(String[] args) {
    Player player1=new Player("Manthan",PlayerSymbol.O);
    Player player2=new Player("Tanay",PlayerSymbol.X);

    WinningStrategy winningStrategy=new ClassicWinningStrategy();
    TicTacToeGame game=new TicTacToeGame(3,player1,player2,winningStrategy);
    game.startGame();

    }

}
