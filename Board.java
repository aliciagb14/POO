import usantatecla.utils.*;

public class Board {
    private final int nRow = 6;
    private final int nColumn = 7;
    public static final int MAX_TOKEN = 42;
    private static final int TOKEN_WINNER = 4;
    private char board[][];
    private int countTokenWinner;

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

    public int countVertical(){
        int countTokenWinner = 0;
        for (int i = 0; i < nRow - 1; i++) {
            for (int j = 0; j < nColumn - 1; j++) {
                if (board[i][j] == board[i + 1][j] && countTokenWinner < TOKEN_WINNER - 1)
                    countTokenWinner++;
            }
        }
       return  countTokenWinner;
    }

    public int countHorizontal(int x){
        int countTokenWinner = 0;
        for (int j = 0; j < nRow - 1; j++) {
            if (board[x][j] == board[x][j + 1] && countTokenWinner < TOKEN_WINNER)
                countTokenWinner++;
            else
                countTokenWinner = 0;
            }
        return countTokenWinner;
    }

    public int countDiagonal(Turn turn){
        int countTokenWinner = 0;
        for (int i = 3; i < nColumn; i++){
            for (int j = 0; j < nRow - 3; j++){
                if (turn.getColor().equals(this.board[i][j])
                        && turn.getColor().equals(this.board[i-1][j+1])
                        && turn.getColor().equals(this.board[i-2][j+2])
                        && turn.getColor().equals(this.board[i-3][j+3]))
                    countTokenWinner = 4;
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < nColumn; i++){
            for (int j = 3; j < nRow; j++){
                if (turn.getColor().equals(this.board[i][j])
                        && turn.getColor().equals(this.board[i-1][j-1])
                        && turn.getColor().equals(this.board[i-2][j-2])
                        && turn.getColor().equals(this.board[i-3][j-3]))
                    countTokenWinner = 4;
            }
        }
        return countTokenWinner;
    }

    public boolean isWinner(Color color, Player player, Turn turn){
        assert !color.isNull();
        if (/*countHorizontal(player.getRow()) == TOKEN_WINNER || */countVertical() == TOKEN_WINNER
                /*|| countDiagonal(turn) == TOKEN_WINNER*/){
            System.out.println("count token horizont: " + countHorizontal(player.getRow())
                + "\ncount token vert: " + countVertical() + "\n");
            player.writeWinner();
            return true;
        }
        return false;
    }

    public int getColumn(){
        Console console = new Console();
        return console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
    }

}