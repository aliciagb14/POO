import usantatecla.utils.*;
enum Color {
    R,
    Y,
    NULL;

    static Color get(int ordinal){
        Error error = null; //REVISAR
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