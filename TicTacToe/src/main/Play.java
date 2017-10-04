package main;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {

        System.out.println("Enter player one name:");
        Scanner scanner = new Scanner(System.in);
        String playerOneName = scanner.nextLine();

        System.out.println("Enter player two name:");
        String playerTwoName=  scanner.nextLine();

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

        Board board = new Board();
        Controller controller = new Controller(playerOne,playerTwo,board);

        controller.startGame();
    }
}
