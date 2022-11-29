public class Victory {
    public Victory(){}

    public int countVertical(char[][] board, char color){
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

    public int countHorizontal(char[][] board, char color){
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

    public boolean isWinner(Board board, Color color, Turn turn){
        assert !color.isNull();
        if (countVertical(board.getBoard(), turn.getColorToken(color)) == Board.TOKEN_WINNER
                ||countHorizontal(board.getBoard(), turn.getColorToken(color)) == Board.TOKEN_WINNER
                || countDiagonal(board.getBoard(), turn.getColorToken(color)) == Board.TOKEN_WINNER){
            if (color == Color.R)
                Message.PLAYER_WIN.writeln("RED");
            else if (color == Color.Y)
                Message.PLAYER_WIN.writeln("YELLOW");
            return true;
        }
        return false;
    }

}