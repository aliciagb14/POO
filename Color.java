import usantatecla.utils.*;
enum Color {
    R,
    Y,
    NULL;

    static Color get(int ordinal){//REVISAR
        Error error = null;
        if(ordinal >= 0 && ordinal < Color.NULL.ordinal())
            return Color.values()[ordinal];
        else {
            error = error.INVALID_COLOR;
            error.writeln();
            return Color.NULL;
        }
    }

    boolean isNull() {
        return this == Color.NULL;
    }
}