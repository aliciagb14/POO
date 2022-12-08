import usantatecla.utils.*;

import java.util.Scanner;

public class Player {

    private Color color;
    private Board board;
    private int countTokens;
    private int column;
    private int row;

    public Player(Board board, Color color){
        assert board != null;

        this.board = board;
        this.color = color;
        this.countTokens = 0;
    }

	public void play(Connect4 game, int opcion) {
        if (opcion == 1){
            int column = board.getColumn();
            if (this.countTokens < Board.MAX_TOKEN)
                this.putToken(column);
        }
        else {
            do {
                int column = (int) (Math.random() * (0 - 7 + 1) + 7);
                System.out.println("La columna random es: " + column);
                if (this.countTokens < Board.MAX_TOKEN)
                    this.putToken(column);
                this.board.showInterface();
            } while (game.isConnect4());
        }
	}

    public void putToken(int column){
        Error error = getPutTokenError(this.board, column);
        assert(this.countTokens < Board.MAX_TOKEN);

        if (error == Error.NULL) {
            this.row = this.board.putToken(color, column - 1);
            this.countTokens++;
        }
    }

    public Error getPutTokenError(Board board, int column){
        Error error = Error.NULL;

        if (column <= 0 || column > 7) {
            error = Error.FAILED_NUMBER_COLUMN_INSERTION;
        }
       else if (board.freeGap(column - 1) == -1)
            error = Error.COLUMN_NOT_EMPTY;
        error.writeln();
        return error;
    }

    public int getColumn(){ return this.column;}

    public int getRow(){ return this.row;}

    public Color getColor(){ return color;}

	public void writeWinner(Turn turn) { Message.PLAYER_WIN.writeln(turn.getColor());}

    public void setColor(Color color) {this.color = color;}
}
