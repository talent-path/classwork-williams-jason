import java.util.Random;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                  {'5', '3', '8', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '.', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '2', '.', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+"\t");

            }
            System.out.println();
        }

        System.out.println("\n\n\n\n\n");
        solveSudoku(board);

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+"\t");

            }
            System.out.println();
        }

    }

    public static boolean isValidSudoku(char[][] board) {
        boolean isValid = true;

        for(int row = 0;isValid && row<board.length;row++){

//            isValid = checkColumn(board[row],row);
            isValid = checkRow(board[row]);


            for(int col = 0;isValid && col<board[row].length;col++){

                isValid = checkColumn(board,col);
                //isValid = checkRow(board,row);

            }


        }

        return isValid;
    }

    public static boolean checkRow(char[] row){
        boolean isValid = true;

        for (int i = 0;isValid && i < row.length-1; i++) {

            for (int j = i+1;isValid && j < row.length-1; j++) {

                char b = row[j];
                char a = row[i];

                if(a==b&& (a!='.'||b!='.')){
                    isValid=false;
                }
            }


        }
        return isValid;
    }

    public static boolean checkColumn(char[][] col, int index){
        boolean isValid = true;

        for (int i = 0;isValid && i < col.length-1; i++) {

            for (int j = i+1;isValid && j < col.length-1; j++) {
                char b = col[j][index];
                char a = col[i][index];

                if(a==b&& (a!='.'||b!='.')){
                    isValid=false;
                }
            }


        }

        return isValid;
    }

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='.')
                    makeMove(board,i,j,randomChar());
                if(!checkColumn(board,j)){
                    makeMove(board,i,j,randomChar());
                }

            }

        }
    }

    public static void makeMove(char[][] board,int row, int col,char value) {
        board[row][col] = value;


    }

    public static char randomChar(){
        Random rand = new Random();
        int guess = rand.nextInt(9)+1;

        switch(guess){
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';

        }

        return 'B';

    }


}
