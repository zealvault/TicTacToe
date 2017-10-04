package main;

import static java.lang.System.exit;

public class Controller {
    private Player playerOne;
    private Player playerTwo;
    private Board board;
    private Player currentPlayer;

    public Controller(Player playerOne, Player playerTwo, Board board) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
        currentPlayer = playerOne;
    }

    public Player nextPlayer() {
        currentPlayer =  (currentPlayer == playerOne) ? playerTwo : playerOne;
        return currentPlayer;
    }

    public void startGame() {
        System.out.println(currentPlayer.getPlayerName()+" Move Your Chance:");
        int[] moves = currentPlayer.playChance();
        while (!board.validate(moves[0], moves[1])) {
            System.out.println("Try Again "+currentPlayer.getPlayerName());
            moves = currentPlayer.playChance();
        }

        board.gameBoard[moves[0]][moves[1]] = currentPlayer.getPlayerName();
        String winnerName = board.winner(currentPlayer.getPlayerName());
        if (winnerName.isEmpty()){
            nextPlayer();
            startGame();
        }
        else{
            System.out.println("Winner is : " + winnerName + "!!!");
            exit(0);
        }
    }
}
