import usantatecla.utils.*;

public class Board {
    public static final int nRow = 6;
    public static final int nColumn = 7;
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

    public int getColumn(){
        Console console = new Console();
        return console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
    }
//
}