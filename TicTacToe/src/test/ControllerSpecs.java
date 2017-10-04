package test;

import main.Board;
import main.Controller;
import main.Player;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ControllerSpecs {
    @Test
    public void should_know_the_next_player(){
        Player playerOne = new Player("Batman");
        Player playerTwo = new Player("Robin");
        Board board = new Board();
        Controller controller = new Controller(playerOne,playerTwo,board);
        Player currentPlayer = controller.nextPlayer();
        Assert.assertEquals(currentPlayer.getPlayerName(),"Robin");
    }


    @Test
    public void should_prompt_user_to_play_again_if_move_is_invalid(){
        String [] [] gameBoard = new String[3][3];
        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        Board board = Mockito.mock(Board.class);
        board.gameBoard = gameBoard;
        Controller controller = new Controller(playerOne,playerTwo,board);
        board.gameBoard[0][0] = "Batman";
        board.gameBoard[1][1] = "Robin";
        Player currentPlayer =  controller.nextPlayer();
        int[] tempArrayOne = {1,1};
        int[] tempArrayTwo = {2,2};
        Mockito.when(currentPlayer.playChance()).thenReturn(tempArrayOne,tempArrayTwo);
        Mockito.when(board.validate(2,2)).thenReturn(false, true);
        Mockito.when(board.winner(playerOne.getPlayerName())).thenReturn("Batman");
        controller.startGame();
        Mockito.verify(playerOne).playChance();
    }

    @Test
    public void should_give_chance_to_next_player_to_make_a_move(){
        String [] [] gameBoard = new String[3][3];
        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        Board board = Mockito.mock(Board.class);
        board.gameBoard = gameBoard;
        Controller controller = new Controller(playerOne,playerTwo,board);
        board.gameBoard[0][0] = "Batman";
        board.gameBoard[1][1] = "Robin";
        int[] tempArray = {1,1};
        Mockito.when(playerOne.playChance()).thenReturn(tempArray);
        Mockito.when(board.validate(1,1)).thenReturn(true);
        Mockito.when(board.winner(playerOne.getPlayerName())).thenReturn("Batman");
        controller.startGame();
        Mockito.verify(playerOne).playChance();

    }

}
