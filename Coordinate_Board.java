import usantatecla.utils.*;


public class Coordinate_Board extends SquareBoundedCoordinate{
    public Coordinate_Board() {
        super();
    }

    public Coordinate_Board(int row, int column) {
        super(row, column);
    }

    @Override
    protected int getDimension() {
        return 0;
    }

    @Override
    protected String getErrorMessage() {
        return null;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
