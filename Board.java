import usantatecla.utils.*;

public class Board {
    private final int nRow = 6;
    private final int nColumn = 7;
    public static final int MAX_TOKEN = 42;
    public static final int TOKEN_WINNER = 4;
    private char board[][];

    public Board() {board = new char[nRow][nColumn];}

    public char[][] getBoard() {
        return board;
    }


    public void initBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                board[i][j] = ' ';
        }
    }

    public void showBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                System.out.print("|" + board[i][j]);
            System.out.print("|");
            System.out.print("\t\n");
        }
    }

    public boolean isEmpty(int columnInput) {
        if (board[nRow - 1][columnInput] == ' ')
            return true;
        return false;
    }

    public int freeGap(int column) {
        for (int i = nRow - 1; i >= 0; i--) {
            if (board[i][column] == ' ')
                return i;
        }
        return -1;
    }

    public int putToken(Color color, int column) {
        int freeRow = freeGap(column);
        if (color == Color.R)
            board[freeRow][column] = 'R';
        else
            board[freeRow][column] = 'Y';
        return freeRow;
    }

    public boolean fullBoard() {
        boolean isFull = true;
        for (int i = 0; i < nColumn; i++) {
            if (board[nRow - 1][i] == ' ')
                isFull = false;
        }
        return isFull;
    }

    public void showInterface(){
        Console console = new Console();
        console.writeln(Message.TITLE.toString());
        console.writeln(Message.HORIZONTAL_LINE.toString());
        this.showBoard();
        console.writeln(Message.HORIZONTAL_LINE.toString());
    }

    public int countVertical(Turn turn, int column, char color){
        int countToken = 1;//0
        for (int i = 0; i < nRow - 1; i++) { //|| countToken <= TOKEN_WINNER
           if (board[i][column] != ' ') {
                if (/*turn.getColor().equals(board[i][column])
                        && turn.getColor().equals(board[i + 1][column])*/
                        board[i][column] == color
                        && board[i + 1][column] == color) // board[i + 1][column] && turn.getActiveColor() == Color.R
                    countToken++;
                else
                    countToken = 0;
            }
        }
        System.out.println("Cont token vert" + countToken);
        return countToken;
    }

    public int countHorizontal(char color){
        int countTokenWinner = 1;
        for (int i = 0; i < nRow - 1; i++){
            for (int j = 0; j < nColumn - 1; j++) {
                if (board[i][j] != ' ') {
                    if (board[i][j + 1] == color
                            && board[i][j] == color) //&& countTokenWinner < TOKEN_WINNER
                        countTokenWinner++;
                    else
                        countTokenWinner = 0;
                }
            }
        }
        System.out.println("cont horizontal " + countTokenWinner);
        return countTokenWinner;
    }

    public int countDiagonal(Turn turn, char color){
        int countTokenWinner = 0;
        for (int i = 3; i < nColumn - 1; i++){
            for (int j = 0; j < nRow - 3; j++){
                if (board[i][j] != ' ') {
                    if (board[i][j] == color
                        && board[i - 1][j + 1] == color
                        && board[i - 2][j + 2] == color
                        && board[i - 3][j + 3] == color) {
                        countTokenWinner = 4;
                    }
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < nColumn - 1; i++){
            for (int j = 3; j < nRow - 1; j++){
                if (board[i][j] != ' ') {
                    if (board[i][j] == color
                            && board[i - 1][j - 1] == color
                            && board[i - 2][j - 2] == color
                            && board[i - 3][j - 3] == color) {
                        countTokenWinner = 4;
                    }
                }
            }
        }
        System.out.println("count diagonal " + countTokenWinner);
        return countTokenWinner;
    }

    public boolean isWinner(Color color, Player player, Turn turn){
        assert !color.isNull();
        if (countVertical(turn, player.getColumn(), turn.getColorToken()) == TOKEN_WINNER
               ||countHorizontal(turn.getColorToken()) == TOKEN_WINNER
               || countDiagonal(turn, turn.getColorToken()) == TOKEN_WINNER){
            player.writeWinner(turn);
            return true;
        }
        return false;
    }

    public int getColumn(){
        Console console = new Console();
        return console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
    }

}