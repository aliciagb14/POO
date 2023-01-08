import exceptions.ExColumnFull;
import exceptions.ExNumberColumn;

public interface IPlayer {
    void play(Connect4 game, int opcion) throws ExNumberColumn, ExColumnFull;
    void putToken(int column) throws ExNumberColumn, ExColumnFull;
    int getColumn();
    Color getColor();
    void setColor(Color color);
}
