import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    static boolean isPlayersTurn = true;
    static int wins = 0, loses = 0, ties = 0;

    public static void main(String[] args) {


        System.out.println("how many games would you like to play?");
        int numGames = input.nextInt();

        for (int i = 0; i < numGames; i++) {
            startGame();
        }

        System.out.println("you won " + wins + " times");
        System.out.println("you lost " + loses + " times");
        System.out.println("you tied " + ties + " times");

    }

    public static void startGame() {
        String[] board = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        int turns = 0;


        boolean noWinner = true;

        while (noWinner) {
            printBoard(board);
            playerTurn(board);
            turns++;
            noWinner = checkWinner(board, turns);
            if (!noWinner) break;
            smartComputerTurn(board);
            turns++;
            noWinner = checkWinner(board, turns);
        }


    }

    public static void printBoard(String[] board) {

        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);

        System.out.println();

    }

    public static void playerTurn(String[] board) {
        System.out.println("enter you move");
        int pos = input.nextInt();
        boolean validMove = false;

        while (!validMove) {


            if (board[pos].isBlank()) {
                board[pos] = "X";
                validMove = true;
            } else {
                System.out.println("invalid move. Please enter a valid move.");
                System.out.println();
                pos = input.nextInt();


            }

        }
        isPlayersTurn = true;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void dumbComputerTurn(String[] board) {
        Random rand = new Random();
        boolean validMove = false;
        int pos;


        while (!validMove) {
            pos = rand.nextInt(9);
            System.out.println();

            if (board[pos].isBlank()) {
                board[pos] = "O";
                validMove = true;
            }
        }

        isPlayersTurn = false;
    }

    public static void smartComputerTurn(String[] board) {
        Random rand = new Random();
        boolean validMove = false;
        int pos;


        for (int i = 0; i < board.length; i++) {
            if (smartMove(board, i)) {
                board[i] = "O";
                validMove = true;
            }
        }
        while (!validMove) {
            pos = rand.nextInt(9);
            System.out.println();
            if (board[pos].isBlank()) {
                board[pos] = "O";
                validMove = true;
            }
        }

        isPlayersTurn = false;
    }

    public static boolean smartMove(String[] board, int index) {
        boolean isSmartMove = false;

        //check for horizontal wins
        for (int i = 0; i < board.length; i++) {

            if (i % 3 == 0 && (board[index + 1].isBlank() && (board[index + 1].equals(board[index + 2])))) {
                isSmartMove = true;
            } else if (i % 3 == 1 && (board[index + 1].isBlank() && (board[index + 1].equals(board[index - 1])))) {
                isSmartMove = true;
            } else if (i % 3 == 2 && (board[index - 1].isBlank() && (board[index - 1].equals(board[index - 2])))) {
                isSmartMove = true;
            }
        }
        //check for vertical wins
        for (int i = 0; i < board.length; i++) {

            if (i % 3 == 0 && (board[index + 3].isBlank() && (board[index + 3].equals(board[index + 6])))) {
                isSmartMove = true;
            } else if (i % 3 == 1 && (board[index + 3].isBlank() && (board[index + 3].equals(board[index - 3])))) {
                isSmartMove = true;
            } else if (i % 3 == 2 && (board[index - 3].isBlank() && (board[index - 3].equals(board[index - 6])))) {
                isSmartMove = true;
            }
        }

        //check for diagonal wins
        if (index == 0 && !board[index + 4].isBlank() && board[index + 4].equals(board[index + 8])) {
            isSmartMove = true;
        } else if (index == 2 && !board[index + 2].isBlank() && board[index + 2].equals(board[index + 4])) {
            isSmartMove = true;
        } else if (index == 6 && !board[index - 2].isBlank() && board[index - 2].equals(board[index - 4])) {
            isSmartMove = true;
        } else if (index == 8 && !board[index - 4].isBlank() && board[index - 4].equals(board[index - 8])) {
            isSmartMove = true;
        } else if (index == 4 && (!board[index - 4].isBlank() || !board[index - 2].isBlank()) &&
                (board[index - 4].equals(board[index + 4]) || (board[index - 2].equals(board[index + 2])))) {
            isSmartMove = true;
        }

        return isSmartMove;
    }

    public static boolean checkWinner(String[] board, int turns) {
        boolean contGame = true;

        if (board[0].equals(board[1]) && board[1].equals(board[2]) &&
                !board[0].isBlank() && !board[1].isBlank() && !board[2].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        } else if (board[3].equals(board[4]) && board[4].equals(board[5]) &&
                !board[3].isBlank() && !board[4].isBlank() && !board[5].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        } else if (board[6].equals(board[7]) && board[7].equals(board[8]) &&
                !board[6].isBlank() && !board[7].isBlank() && !board[8].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        }


        //vertical checks
        else if (board[0].equals(board[3]) && board[3].equals(board[6]) &&
                !board[0].isBlank() && !board[3].isBlank() && !board[6].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        } else if (board[1].equals(board[4]) && board[4].equals(board[7]) &&
                !board[1].isBlank() && !board[4].isBlank() && !board[7].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        } else if (board[2].equals(board[5]) && board[5].equals(board[8]) &&
                !board[2].isBlank() && !board[5].isBlank() && !board[8].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        }


        //Diagonal checks
        else if (board[0].equals(board[4]) && board[4].equals(board[8]) &&
                !board[0].isBlank() && !board[4].isBlank() && !board[8].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        } else if (board[2].equals(board[4]) && board[4].equals(board[6]) &&
                !board[2].isBlank() && !board[4].isBlank() && !board[6].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) {
                System.out.println("you win!");
                wins++;
            } else {
                System.out.println("you lose!");
                loses++;
            }
            contGame = false;

        } else if (turns == 9) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("its a tie!");
            contGame = false;
            ties++;
        }

        return contGame;
    }
}
