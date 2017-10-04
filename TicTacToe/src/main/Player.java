package main;

import java.util.Scanner;

public class Player {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int[] playChance() {
        Scanner scanner = new Scanner(System.in);
        int moveOne = scanner.nextInt();
        int moveTwo = scanner.nextInt();
        int [] movesArray = {moveOne,moveTwo};
        return movesArray;
    }
}
