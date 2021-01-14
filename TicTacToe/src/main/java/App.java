import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    static boolean isPlayersTurn = true;

    public static void main(String[] args) {

        startGame();

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
            computerTurn(board);
            turns++;
            noWinner = checkWinner(board, turns);
        }


    }

    public static void printBoard(String[] board) {

        System.out.println(board[0]+" | "+board[1]+" | "+board[2]);
        System.out.println("---------");
        System.out.println(board[3]+" | "+board[4]+" | "+board[5]);
        System.out.println("---------");
        System.out.println(board[6]+" | "+board[7]+" | "+board[8]);

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

    public static void computerTurn(String[] board) {
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

    public static boolean checkWinner(String[] board, int turns) {
        boolean contGame = true;

        if (board[0].equals(board[1]) && board[1].equals(board[2]) &&
                !board[0].isBlank() && !board[1].isBlank() && !board[2].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        } else if (board[3].equals(board[4]) && board[4].equals(board[5]) &&
                !board[3].isBlank() && !board[4].isBlank() && !board[5].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        } else if (board[6].equals(board[7]) && board[7].equals(board[8]) &&
                !board[6].isBlank() && !board[7].isBlank() && !board[8].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        }


        //vertical checks
        else if (board[0].equals(board[3]) && board[3].equals(board[6]) &&
                !board[0].isBlank() && !board[3].isBlank() && !board[6].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        } else if (board[1].equals(board[4]) && board[4].equals(board[7]) &&
                !board[1].isBlank() && !board[4].isBlank() && !board[7].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        } else if (board[2].equals(board[5]) && board[5].equals(board[8]) &&
                !board[2].isBlank() && !board[5].isBlank() && !board[8].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        }


        //Diagonal checks
        else if (board[0].equals(board[4]) && board[4].equals(board[8]) &&
                !board[0].isBlank() && !board[4].isBlank() && !board[8].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        } else if (board[2].equals(board[4]) && board[4].equals(board[6]) &&
                !board[2].isBlank() && !board[4].isBlank() && !board[6].isBlank()) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("game over!");
            if (isPlayersTurn) System.out.println("you win!");
            else System.out.println("you lose!");
            contGame = false;

        } else if (turns == 9) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(board);
            System.out.println("its a tie!");
            contGame = false;
        }

        return contGame;
    }
}
