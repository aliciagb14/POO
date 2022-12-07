public class Machine extends Player {

    public Machine(Board board, Color color) {
        super(board, color);
    }

    public void putTokenRandom(int column){
        super.putToken(column);
    }
}
