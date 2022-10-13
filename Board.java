import usantatecla.utils.*;
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

    public Board() {
        this.board = new char[nRow][nColumn];
    }

    public void initBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                board[i][j] = '|';
        }
    }

    public void showBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                System.out.print(board[i][j] + "\t");
            System.out.print("\n");
        }
    }

    public boolean isEmpty(int columnInput) {
        if (columnInput >= 1 && columnInput <= 7) {
            for (int i = 0; i < nRow; i++) {
                    if (board[i][columnInput] == ' ')
                        return true;
            }
        }
        return false;
    }

    public int countHorizontal(char board[][]) {
        int i = 0, j;
        int numFichas = 0;
        int fichasGanador = 4;
        boolean encontrado = false;
        for (j = 0; j < nColumn && !encontrado; j++) {
            if (board[i][j] == board[i][j + 1]) {
                encontrado = true;
                numFichas++;
                if (numFichas == fichasGanador)
                    System.out.println("HA GANADO");
            } else
                i++;
        }
        return numFichas;
    }

    public int countVertical(char board[][]) {
        int i, j = 0;
        int numFichas = 0;
        int fichasGanador = 4;
        boolean encontrado = false;
        for (i = 0; i < nRow && !encontrado; i++) {
            if (board[i][j] == board[i + 1][j]) {
                encontrado = true;
                numFichas++;
                if (numFichas == fichasGanador)
                    System.out.println("HA GANADO");
            } else
                j++;
        }
        return numFichas;
    }

    public int contarDiagonal(char board[][]) {
        int numFichasDiagonalPpal = 0;
        int numFichasDiagonalSecund = 0;
        int[] diagoPrincipal = new int[board.length];
        int[] diagoSecundaria = new int[board.length];
        int fichasGanador = 4;
        boolean encontrado = false;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++) {
                if (i == j) {
                    diagoPrincipal[i] = board[i][j];
                    numFichasDiagonalPpal++;
                }
                if (i + j == board.length - 1) {
                    diagoSecundaria[i] = board[i][j];
                    numFichasDiagonalSecund++;
                }
            }
        }
        if (numFichasDiagonalPpal == 4)
            return numFichasDiagonalPpal;
        else
            return numFichasDiagonalSecund;
    }
}