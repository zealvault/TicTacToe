package main;

public class Board {

    public String[][] gameBoard;

    public Board() {
        this.gameBoard = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = "";
            }
        }
    }

    public boolean validate(int moveOne, int moveTwo) {
        if ((moveOne >= 0 && moveOne <= 2) && (moveTwo >= 0 && moveTwo <= 2)) {
            return isOccupied(moveOne, moveTwo);
        } else {
            return false;
        }
    }

    public String winner(String playerName) {
        int[][] moves = getPlayerMoves(playerName);
        boolean isWinner = determineWinner(moves);
        if (isWinner) {
            return playerName;
        }
        return "";
    }

    private boolean isOccupied(int moveOne, int moveTwo) {

        return gameBoard[moveOne][moveTwo].isEmpty() ? true : false;
    }


    private boolean determineWinner(int[][] moves) {
        int countZero = 0, countOne = 0, countTwo = 0;
        for (int i = 0; i < moves.length; i++) {
            if (moves[i][0] == 0) {
                countZero++;
            } else if (moves[i][0] == 1) {
                countOne++;
            } else if (moves[i][0] == 2) {
                countTwo++;
            }
        }

        if (countOne == 3 || countTwo == 3 || countZero == 3) {
            return true;
        }

        countOne = 0;
        countZero = 0;
        countTwo = 0;

        for (int i = 0; i < moves.length; i++) {
            if (moves[i][1] == 0) {
                countZero++;
            } else if (moves[i][1] == 1) {
                countOne++;
            } else if (moves[i][1] == 2) {
                countTwo++;
            }
        }

        if (countOne == 3 || countTwo == 3 || countZero == 3) {
            return true;
        }

        int counter = 0;
        int counterSum = 0;


        for (int i = 0; i < moves.length; i++) {
            if (moves[i][1] == moves[i][0] && moves[i][0] != -1) {
                counter++;
            }
            if (moves[i][1] + moves[i][0] == 2) {
                counterSum++;
            }
        }

        if (counter == 3 || counterSum == 3)
            return true;
        else return false;

    }

    private int[][] getPlayerMoves(String playerName) {
        int x = 0, y = 0;
        int[][] moves = new int[5][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == playerName) {
                    moves[x][y++] = i;
                    moves[x++][y] = j;
                    y = 0;
                }
            }
        }
        while (x <= 4) {
            moves[x][0] = -1;
            moves[x][1] = -1;
            x++;
        }
        return moves;
    }
}
