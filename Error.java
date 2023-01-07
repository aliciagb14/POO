import usantatecla.utils.*;
import exceptions.*;

/**
 * Nos ayudará a controlar los errores de nuestro programa
 * mostrando por pantalla los avisos al usuario
 */

public enum Error {
    COLUMN_NOT_EMPTY("Column choosen not empty"),
    FAILED_NUMBER_COLUMN_INSERTION("Invalid column!! Values [1-7]"),
    INVALID_COLOR("Color invalid"),
    NULL;

    private String message;
    Error(){
    }

    Error(String message){
        this.message = message;
    }

    void writeln() {
        if (!this.isNull()) {
            Console.getInstance().writeln(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}
