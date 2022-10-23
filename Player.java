import usantatecla.utils.*;

import java.util.Scanner;

public class Player {
    private Color color;
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private final int MAX_TOKEN = 42;
    private int countTokens;

    public Player(){}

    public Player(Color color, Board board){
        this.color = color;
        this.board = board;
        this.countTokens = 0;
        this.players = new Player[NUMBER_PLAYERS];
    }

    public void putToken(int column){
        Error error;
        assert(countTokens < MAX_TOKEN);
        do{
            error = this.getPutTokenError(column);
        }while(!error.isNull());
        board.putToken(this.color, column);
        countTokens++;
    }

    public Error getPutTokenError(int column){
       Error error = null;
        if (!board.isEmpty(column)){
            error = error.COLUMN_NOT_EMPTY;
        }
        else if(column < 1 && column > 7)
            error = error.FAILED_NUMBER_COLUMN_INSERTION;
        error.writeln();
        return error;
    }

    public int getTurn(int turn){
        return turn;
    }

    public Color getColor(Color color){
        return color;
    }

}
