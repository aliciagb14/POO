public class Victory {
    public Victory(){}

    /**
     * nos permitirá saber si hay 4 fichas de manera vertical
     * @param board - recibira el tablero
     * @param color - recibira el color de la ficha
     * @return - nos devolvera el total de fichas consecutivas
     */

    public int countVertical(char[][] board, char color){ //vertical
        int countToken = 0;
        int  maxToken=0;
        for (int j = 0; j <= Board.nColumn - 1; j++) {
            for (int i = 0; i <= Board.nRow - 1; i++) {
                if (board[i][j] == color)
                    countToken++;
                else
                    countToken = 0;


                if(countToken>maxToken)
                    maxToken=countToken;
            }
        }
        return maxToken;
    }

    /**
     * nos permitira saber si hay 4 fichas de manera horizontal consecutivas
     * @param board - recibirá el tablero
     * @param color - recibira el valor de la ficha
     * @return - nos dira el total de fichas
     */

    public int countHorizontal(char[][] board, char color){ //columnas
        int countToken = 0;
        int  maxToken=0;
        for (int i = 0; i <= Board.nRow - 1 ; i++){
            for (int j = 0; j <= Board.nColumn - 1; j++) {
                if (color == board[i][j])
                    countToken++;
                else
                    countToken = 0;


                if(countToken>maxToken)
                    maxToken=countToken;
            }
        }
        return maxToken;
    }

    /**
     * nos permitirá saber si hay 4 fichas de diagonal, tanto superior como inferior
     * @param board - recibirá el tablero
     * @param color - recibirá el valor de la ficha
     * @return - nos dirá el total de fichas
     */


    public int countDiagonal(char[][] board, char color){
        int countTokenWinner = 0;
        for (int i = 3; i < Board.nColumn - 1; i++){
            for (int j = 0; j < Board.nRow - 3; j++){
                if (board[i][j] == color
                        && board[i - 1][j + 1] == color
                        && board[i - 2][j + 2] == color
                        && board[i - 3][j + 3] == color) {
                    countTokenWinner = 4;
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < Board.nColumn - 1; i++){
            for (int j = 3; j < Board.nRow - 1; j++){
                if (board[i][j] == color
                        && board[i - 1][j - 1] == color
                        && board[i - 2][j - 2] == color
                        && board[i - 3][j - 3] == color) {
                    countTokenWinner = 4;
                }
            }
        }
        return countTokenWinner;
    }

    /**
     * nos permitirá saber que jugador ha ganado , en cuyo caso lo mostrara por pantalla
     * @param board
     * @param color
     * @param turn
     * @return - nos devolvera true para terminar la partida o false para seguir jugando
     */

    public boolean isWinner(Board board, Color color, Turn turn){
        assert !color.isNull();
        if (countVertical(board.getBoard(), turn.getColorToken(color)) >= Board.TOKEN_WINNER
                ||countHorizontal(board.getBoard(), turn.getColorToken(color)) >= Board.TOKEN_WINNER
                || countDiagonal(board.getBoard(), turn.getColorToken(color)) >= Board.TOKEN_WINNER){
            if (color == Color.R) {
                board.showInterface();
                Message.PLAYER_WIN.writeln("RED");
            }

            else if (color == Color.Y) {
                board.showInterface();
                Message.PLAYER_WIN.writeln("YELLOW");
            }
            return true;
        }
        return false;
    }
//
}
