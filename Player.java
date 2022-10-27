import usantatecla.utils.*;

import java.util.Scanner;

public class Player {
    private Color color;
    private Board board;
    private int countTokens;

    public Player(){}

    public Player(Color color, Board board){
        this.color = color;
        this.board = board;
        this.countTokens = 0;
    }

    public void putToken(Turn turn, int column){
        Error error;
        assert(countTokens < board.getDimension());
       do{
            error = this.getPutTokenError(column);
        }while(error != null);
        board.putToken(this.color, turn, column);
        countTokens++;
    }

    public Error getPutTokenError(int column){
        Error error = null;
        if (!board.isEmpty(column))
            error = error.COLUMN_NOT_EMPTY;
        else if(column < 1 && column > 7) {
            error = error.FAILED_NUMBER_COLUMN_INSERTION;
            error.writeln();
        }
        return error;
    }

    public int getTurn(int turn){
        return turn;
    }

    public Color getColor(Color color){
        return color;
    }

}
