import usantatecla.utils.*;

public class Board {
    public static final int nRow = 6;
    public static final int nColumn = 7;
    public static final int MAX_TOKEN = 42;
    public static final int TOKEN_WINNER = 4;
    private char board[][];
    private int lastColumn;

    public Board() {
        board = new char[nRow][nColumn];
    }

    /**
     * Nos permitirá obtener el tablero
     * @return - devuelve el tablero
     */

    public char[][] getBoard() {
        return board;
    }

    /**
     * Inicializa nuestro tablero con las dimensiones
     * pasadas como constantes
     */

    public void initBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                board[i][j] = ' ';
        }
    }

    /**
     * Rellenará cada coordenada del tablero
     * con una linea vertical
     */

    public void showBoard() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColumn; j++)
                System.out.print("|" + board[i][j]);
            System.out.print("|");
            System.out.print("\t\n");
        }
    }

    /**
     * Nos permitirá saber si en la posición de la columna pasada por parámetro
     * hay ya una ficha o no
     * @param columnInput
     * @return
     */

    public boolean isEmpty(int columnInput) {
        if (board[nRow - 1][columnInput] == ' ')
            return true;
        return false;
    }

    /**
     * Método que nos devuelve la posición de la fila que se encuentra libre
     * para saber donde colocar la ficha (según la columna pasada por parámetro)
     * @param column - le pasamos el numero de columna
     * @return - si esta libre devolverá fila libre , si no -1
     */

    public int freeGap(int column) {
        for (int i = nRow - 1; i >= 0; i--) {
            if (board[i][column] == ' ')
                return i;
        }
        return -1;
    }

    /**
     * Pondrá la ficha que proceda en cada coordenada
     * @param color - nos dirá el valor de cada ficha
     * @param column - le pasaremos la columna
     * @return - nos devolverá la fila libre
     */

    public int putToken(Color color, int column) {
        int freeRow = freeGap(column);
        lastColumn = column;
        if (color == Color.R)
            board[freeRow][column] = 'R';
        else
            board[freeRow][column] = 'Y';
        return freeRow;
    }

    /**
     * Nos permitirá saber si el tablero esta lleno
     * @return - un valor boooleano en cada caso, true si esta lleno, false si no lo está
     */

    public boolean fullBoard() {
        boolean isFull = true;
        for (int i = 0; i < nColumn; i++) {
            if (board[nRow - 1][i] == ' ')
                isFull = false;
        }
        return isFull;
    }

    /**
     * Este método nos mostrará la interfaz que queremos usar en nuestro juego
     */

    public void showInterface(){
        Console console = new Console();
        console.writeln(Message.TITLE.toString());
        console.writeln(Message.HORIZONTAL_LINE.toString());
        this.showBoard();
        console.writeln(Message.HORIZONTAL_LINE.toString());
    }

    /**
     * Ns pedirá por consola que ingresemos una valor para la columna
     * @return - nos devolvera el valor de la columna
     */

    public int getColumn(){

        Console console = new Console();
        return console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    /**
     * Nos permitirá borrar la ficha del tablero (una vez realizado el undo)
     * para así poder actualizarlo
     * @param column - le pasamos el valor de la columna
     */

    public void deleteToken(int column){
        for (int i = 0; i < nRow; i++){
            if (board[i][column] != ' ') {
                board[i][column] = ' ';
                return;
            }
        }
    }

    /**
     * Obtendremos la ultima columna que nos será útil para realizar
     * las operaciones de undo y redo
     * @return - el valor de la ultima columna
     */
    public int getLastColumn() {
        return lastColumn;
    }
}