package test;

import main.Board;
import org.junit.Assert;
import org.junit.Test;

public class BoardSpecs {
    @Test
    public void should_validate_the_players_move_and_return_false_if_move_is_out_of_bound(){
        Board board = new Board();
        boolean isValid = board.validate(1,4);

        Assert.assertEquals(isValid,false);

    }

    @Test
    public void should_validate_the_players_move_and_return_false_if_position_is_already_occupied(){
        Board board =  new Board();
        board.gameBoard[1][2] = "Player";
       boolean isValid =  board.validate(1,2);
       Assert.assertEquals(isValid,false);
    }

    @Test
    public void should_return_the_winner(){
        Board board = new Board();
        board.gameBoard[0][0] = "Batman";
        board.gameBoard[1][1] = "Batman";
        board.gameBoard[2][2] = "Batman";
        board.gameBoard[2][1] = "Robin";
        board.gameBoard[2][0] = "Robin";

        String winner = board.winner("Batman");

        Assert.assertEquals(winner,"Batman");

    }

}
