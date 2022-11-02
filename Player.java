import usantatecla.utils.*;

import java.util.Scanner;

public class Player {

    private Color color;
    private Board board;
    private int countTokens;

    public Player(Board board, Color color){
        assert  board != null;

        this.board = board;
        this.color = color;
        this.countTokens = 0;
    }

    public void putToken(Turn turn, int column){ //Board
        Error error;
        assert(this.countTokens < board.getDimension());
      // do{
            error = this.getPutTokenError(board, column);
       // }while(!error.isNull());
       if (Color.R == getColor(color))
            this.board.putToken(turn, color, column);
        countTokens++;
    }

    public Error getPutTokenError(Board board, int column){
        Error error = Error.NULL;
        if (!board.isEmpty(column))
            error = Error.COLUMN_NOT_EMPTY;
        else if(column < 1 || column > 7){
            error = Error.FAILED_NUMBER_COLUMN_INSERTION;}
        error.writeln();
        return error;
    }

    public int getTurn(int turn){
        return turn;
    }

    public Color getColor(Color color){
        return color;
    }

    public int changeTurn(Turn turn, int column){
        int turnActual;
        boolean encontrado = false;
        int fichasMAX = board.getDimension();
        if (fichasMAX % 2 == 0)
            turnActual = 0;
        else
            turnActual = 1;
        putToken(turn, column);
        fichasMAX--;
        return turnActual;
    }

}
