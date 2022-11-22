import usantatecla.utils.*;

import java.util.Scanner;

public class Player {

    private Color color;
    private Board board;
    //private Turn turn;
    private int countTokens;

    public Player(Board board, Color color){
        assert board != null;

        this.board = board;
        this.color = color;
        this.countTokens = 0;
    }

	public void play() {
        int column = board.getColumn();
		if (this.countTokens < board.getDimension())
			this.putToken(column);
	}

    public void putToken(int column){
        Error error = getPutTokenError(this.board, column);
        assert(this.countTokens < board.getDimension());

        if (error == Error.NULL) {
            this.board.putToken(color, column - 1);
            countTokens++;
        }
    }

    public Error getPutTokenError(Board board, int column){
        Error error = Error.NULL;

        if (column < 0 || column > 7) {
            error = Error.FAILED_NUMBER_COLUMN_INSERTION;
        }
       else if (board.freeGap(column - 1) == -1)
            error = Error.COLUMN_NOT_EMPTY;
        error.writeln();
        return error;
    }

    public int getTurn(int turn){
        return turn;
    }

    public Color getColor(){
        return color;
    }


    public int getCountTokens(){ return countTokens;}

	public void writeWinner() {
		Message.PLAYER_WIN.writeln(this.color.name());
	}

    public void setColor(Color color)
    {
        this.color = color;
    }
}
