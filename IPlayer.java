import exceptions.ExColumnFull;
import exceptions.ExNumberColumn;

public interface IPlayer {
    void play(Connect4 game, int opcion) throws ExNumberColumn, ExColumnFull;
    void putToken(int column) throws ExNumberColumn, ExColumnFull;
    int getColumn();
    int getRow();
    Color getColor();
    void writeWinner(Turn turn);
    void setColor(Color color);
}
