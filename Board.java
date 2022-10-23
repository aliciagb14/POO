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
    private char board[][];
    private String color;

    public Board() {this.board = new char[nRow][nColumn];}

    public char[][] getBoard() {
        return board;
    }

    //set Token tienen turn.changeTurn()
    public void initBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                board[i][j] = ' ';
        }
    }

    public void showBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                System.out.print("|" + board[i][j] + "\t");
            System.out.print("\n");
        }
    }

    public boolean isEmpty(int columnInput) {
        if (columnInput >= 1 && columnInput <= 7) {
            for (int i = 0; i < nRow; i++) {
                    if (board[i][columnInput] == '|')
                        return true;
            }
        }
        return false;
    }

    //hueco libre en fila para saber donde meter la ficha
    public int freeGap(int column){
        int j = 1;
        for (int i = nRow - j; j < nRow ; j++){
            if (board[i][column] == ' ' && board[i - 1][column] != ' ')
                return i;
        }
        return -1;
    }

    public void putToken(Color color, int column) {
        Player player = new Player();
        do {
            int freeRow = freeGap(column);
            this.board[freeRow][column] = colorOnBoard(player, color); //decidir si inserta r o y
        }while(!fullBoard());
    }

    public char colorOnBoard(Player player, Color color){
        if (player.getColor(color) == color.get(0))
            return 'R';
        else
            return 'Y';
    }

    public boolean fullBoard(){
        for (int j = 0; j < nColumn; j++){
            if (board[nRow][j] == ' ')
                return false;
        }
        return true;
    }
}