package test;

import main.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PlayerSpecs {
    @Test
    public void should_be_able_to_create_player(){
        String playerOneName = "Batman";

        Player player = new Player(playerOneName);

        Assert.assertEquals(player.getPlayerName(),playerOneName);
    }

    @Test
    public void player_should_be_able_to_play_chance(){

        Player playerOne =  new Player("Robin");
        String input = "1 2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int[] moves = playerOne.playChance();
        Assert.assertEquals(moves[0],1);
        Assert.assertEquals(moves[1],2);

    }
}
