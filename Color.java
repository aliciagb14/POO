import usantatecla.utils.*;


enum Color {
    R,
    Y,
    NULL;

    /**
     * nos permitirá obtener el valor de color siempre y cuando se encuentre
     * en el rango entre 0 y 2
     * @param ordinal - le pasaremos una posicion
     * @return - nos dira que valor tiene nuestra posicion dada
     */

    static Color get(int ordinal){
        assert (ordinal >= 0 && ordinal < Color.NULL.ordinal());
        return Color.values()[ordinal];
    }

    /**
     * Booleano que nos ayudará a saber si el color es nulo
     * @return - nos dira si el nulo
     */

    boolean isNull() {
        return this == Color.NULL;
    }
//
}