import exceptions.ExColumnFull;
import exceptions.ExNumberColumn;

public class UserPlayer extends Player{
    public UserPlayer(Board board, Color color){
        super(board, color);
    }

    @Override
    protected Error getPutTokenError(Board board, int column) throws ExNumberColumn, ExColumnFull {
        Error error = super.getPutTokenError(board, column);
        error.writeln();
        return error;
    }

}
