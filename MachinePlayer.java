import exceptions.ExColumnFull;
import exceptions.ExNumberColumn;

public class MachinePlayer extends Player {

    public MachinePlayer(Board board, Color color) {
        super(board, color);
    }
    public void putTokenRandom(int column) throws ExNumberColumn, ExColumnFull { super.putToken(column); }
}
