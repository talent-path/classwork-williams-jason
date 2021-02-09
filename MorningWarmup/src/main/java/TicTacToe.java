import java.util.Locale;

public class TicTacToe {

    public static void main(String[] args) {
        String[] board = new String[3];
        board[0] = "OXX";
        board[1] = "XOX";
        board[2] = "OXO";


        System.out.println(validTicTacToe(board) + " valid board");
        System.out.println(checkRows(board) + " rows");
        System.out.println(checkColumns(board) + " columns");
        System.out.println(checkDiagonals(board) + " diagonals");
        System.out.println(!boardIsFull(board) + " full board");

    }

    public static boolean validTicTacToe(String[] board) {
    boolean validGameState = true;
    int diffenceInPieceCount = numOfO(board)-numOfX(board);

    if(!(diffenceInPieceCount>-2 && diffenceInPieceCount < 1)){
        validGameState = false;
    }
        System.out.println(diffenceInPieceCount + " difference in piece count");

    if(!checkColumns(board) || !checkRows(board) || !checkDiagonals(board)){
        validGameState = false;
        if(diffenceInPieceCount==-1){
            validGameState = true;
        }
    }

    if(boardIsFull(board)){
        validGameState = false;
        if(diffenceInPieceCount==-1){
            validGameState = true;
        }
    }

    return validGameState;
    }

    public static boolean checkRows(String[] board){
        boolean rowsValid = true;
        for (int i = 0; i < board.length; i++) {

            if (board[i].equals("XXX") || board[i].equals("OOO")) {
                rowsValid = false;
            }
        }

        return rowsValid;
    }

    public static boolean checkColumns(String[] board){
        boolean columnsValid = true;
        for (int i = 0; i < board[0].length() && columnsValid; i++) {
            String a = board[0].substring(i,i+1);
            String b = board[1].substring(i,i+1);
            String c = board[2].substring(i,i+1);
            if((a.equals(b) && b.equals(c))){
                    columnsValid = false;
                    if(a.equals(" "))
                        columnsValid=true;
            }
        }


        return columnsValid;
    }

    public static boolean checkDiagonals(String[] board){
        boolean diagonalsValid = true;
        if((board[0].substring(0,1).equals(board[1].substring(1,2))) &&
            board[1].substring(1,2).equals(board[2].substring(2,3))){
            if(!board[1].contains(" "))
                diagonalsValid = false;

        } else if((board[0].substring(2,3).equals(board[1].substring(1,2))) &&
                board[1].substring(1,2).equals(board[2].substring(0,1))){
            if(!board[1].contains(" "))
                diagonalsValid = false;
        }

        return diagonalsValid;
    }

    public static int numOfX(String[] board){
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= board[i].length()-1; j++) {
                String test = board[i].substring(j,j+1);
                if(test.equals("X")){
                    count++;
                }
            }
        }

        return count;
    }

    public static int numOfO(String[] board){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= board[i].length()-1; j++) {
                String test = board[i].substring(j,j+1);
                if(test.equals("O")){
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean boardIsFull(String[] board){
        boolean fullBoard = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i].contains(" ")){
                fullBoard = false;
            }
        }
        return fullBoard;
    }
}
