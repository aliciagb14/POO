import usantatecla.utils.*;
enum Color {
    R,
    Y,
    NULL;


    static Color get(int ordinal){
        assert (ordinal >= 0 && ordinal < Color.NULL.ordinal());
        return Color.values()[ordinal];
    }

    boolean isNull() {
        return this == Color.NULL;
    }

}