import usantatecla.utils.*;


enum Color {
    R,
    Y,
    NULL;

    /**
     * nos permitirá obtener el valor de color
     * @param ordinal - le pasaremos una posicion
     * @return - nos dira que valor tiene nuestra posicion dada
     */

    static Color get(int ordinal){
        assert (ordinal >= 0 && ordinal < Color.NULL.ordinal());
        return Color.values()[ordinal];
    }

    /**
     * booleano para saber si es nula
     * @return - nos dira si el nulo
     */

    boolean isNull() {
        return this == Color.NULL;
    }
//
}