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

    /**
     * Nos permitirá desarrollar según la opción elegida un tipo de modo de juego
     * @param game -
     * @param opcion - la opcion elegida
     */

	public void play(Connect4 game, int opcion) {
        if (opcion == 1){
            int column = board.getColumn();
            if (this.countTokens < Board.MAX_TOKEN)
                this.putToken(column);
        }
        else {
            do {
                int column = (int) (Math.random() * 7 + 1);
                System.out.println("La columna random es: " + column);
                if (this.countTokens < Board.MAX_TOKEN)
                    this.putToken(column);
            } while (game.isConnect4());
        }
	}

    /**
     * Intenta colocar la ficha en el tablero siempre y cuando no se produzca un error
     * @param column - le pasaremos la posicion donde queremos meter la ficha
     * @throws ExNumberColumn
     * @throws ExColumnFull
     */

    public void putToken(int column)  {
        Error error = getPutTokenError(this.board, column);
        assert(this.countTokens < Board.MAX_TOKEN);

        if (error == Error.NULL) {
            this.row = this.board.putToken(color, column - 1);
            this.countTokens++;
        }
    }

    /**
     * Controlaremos los errores a la hora de meter la ficha
     * @param board
     * @param column
     * @return - devolveremos el error en cualquier caso
     * @throws ExNumberColumn
     * @throws ExColumnFull
     */

    protected Error getPutTokenError(Board board, int column)  {
        Error error = Error.NULL;
        if (column <= 0 || column > 7)
            error = Error.FAILED_NUMBER_COLUMN_INSERTION;
        else if (board.freeGap(column - 1) == -1)
            error = Error.COLUMN_NOT_EMPTY;
        error.writeln();
        return error;
    }

    public int getColumn(){ return this.column;}

    public Color getColor(){ return color;}

    public void setColor(Color color) {this.color = color;}
}
