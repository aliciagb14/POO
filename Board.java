import usantatecla.utils.*;

import static java.lang.String.valueOf;

/*
 * 21 fichas cada jugador
 * fichas RED, YELLOW
 * Cada posición viene determinada por un valor de fila y columna.
 * Inicialmente, el tablero se encuentra vacío.


 * Jugada = situar una ficha dentro de una posición del tablero que realiza un jugador en su turno.
 * Una vez realizada la jugada, se cambia el turno de juego.
 * El objetivo de un jugador es conectar 4 fichas del mismo color en  horizontal, vertical o diagonal en cualquier dirección.
  *El primer jugador que logre este resultado ganará la partida.

  *En el caso de que las 42 fichas hayan sido utilizadas y ningún jugador haya logrado su meta = empate.

 * Tablero vertical,inserción de fichas: en una columna y caerán hasta la fila más baja que no esté ocupada.
 * En cada turno, el jugador elige la  columna donde quiere poner su ficha, pero no la fila.
 * Si la columna tiene 6 fichas, columna LLENA, no deja insertar
 * Jugadores sin fichas y sin ganador = empate

 * Varios modos:
 *   “Básico” 2 jugadores humanos que interactúan con el programa según el turno de juego.
 *   “Entrenamiento”, tiene que permitir jugar contra  la máquina, 1 humano y 1 máquina.
 *   “Demo” tiene que permitir que los dos jugadores sean controlados por la máquina sin intervención humana.
 *  Se pueden deshacer los últimos movimientos realizados y volver a hacer los movimientos
 * que se habían deshecho (patrón undo/redo).
 */
public class Board {
    private final int nRow = 6; //fila
    private final int nColumn = 7; //columna
    private final int MAX_TOKEN = 42;
    private char board[][];
    private Player player;
    //private Player[] players;
    private String color;
    private Turn turn;
   // private int turn;

    public Board() {
        board = new char[nRow][nColumn];
        this.player = player;
    }

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
            System.out.print("\t\n");
        }
    }

    public boolean isEmpty(int columnInput) {
        if (board[nRow - 1][columnInput] == ' ')
            return true;
        return false;
    }

    public int freeGap(int column){
        for (int i = nRow - 1; i > 0 ; i--){
            if (board[i][column] == ' ')
                return i;
        }
        return -1;
    }

    public void putToken(Turn turn, Color color, int column) {
        boolean encontrado;
        do {
            int freeRow = freeGap(column);
            if (player.changeTurn(turn, column) == 0)
                board[freeRow][column] = 'R';
            else
                board[freeRow][column] = 'Y';
            encontrado = true;
        }while(encontrado == false);
    }

    public boolean fullBoard(){
        if (board[nRow - 1][nColumn - 1] == ' ')
            return false;
        return true;
    }

    public int getDimension(){return MAX_TOKEN;}

}