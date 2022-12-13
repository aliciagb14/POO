public interface IPlayer {
    void play(Connect4 game, int opcion);
    void putToken(int column);
    int getColumn();
    int getRow();
    Color getColor();
    void writeWinner(Turn turn);
    void setColor(Color color);
}
