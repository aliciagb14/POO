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
        }while(!error.isNull());
        board.putToken(color, turn, column); //board . no me coge el tablero q quiero
        countTokens++;
    }

    public Error getPutTokenError(int column){
        Error error;
        if (!board.isEmpty(column))
            error = Error.COLUMN_NOT_EMPTY;
        else if(column < 1 && column > 7){
            error = Error.FAILED_NUMBER_COLUMN_INSERTION;}
        rror.writeln();
        return error;
    }

    public int getTurn(int turn){
        return turn;
    }

    public Color getColor(Color color){
        return color;
    }

}
