import usantatecla.utils.*;

import java.util.Scanner;
import exceptions.*;

public class Player implements IPlayer{

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

	public void play(Connect4 game, int opcion) throws ExNumberColumn, ExColumnFull {
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
            } while (game.isConnect4());
        }
	}

    public void putToken(int column) throws ExNumberColumn, ExColumnFull {
        Error error = getPutTokenError(this.board, column);
        assert(this.countTokens < Board.MAX_TOKEN);

        if (error == Error.NULL) {
            this.row = this.board.putToken(color, column - 1);
            this.countTokens++;
        }
    }

    protected Error getPutTokenError(Board board, int column) throws ExNumberColumn, ExColumnFull {
        Error error = Error.NULL;
        if (column <= 0 || column > 7){
            try {
                error = Error.FAILED_NUMBER_COLUMN_INSERTION;
            }catch(NullPointerException e) {
                throw new ExNumberColumn();
            }
        }
        else if (board.freeGap(column - 1) == -1) {
            try {
                error = Error.COLUMN_NOT_EMPTY;
            } catch(NullPointerException e) {
                throw new ExColumnFull();
            }
        }
        error.writeln();
        return error;
    }

    public int getColumn(){ return this.column;}

    public int getRow(){ return this.row;}

    public Color getColor(){ return color;}

	public void writeWinner(Turn turn) { Message.PLAYER_WIN.writeln(turn.getColor());}

    public void setColor(Color color) {this.color = color;}
}
