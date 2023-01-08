//package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class GestorComandos {
    private static GestorComandos gestor = null;
    private Color color;
    private Turn turn;
    private Pila<Color> pilaundo;
    private Pila<Color> pilaredo;

    /**
     * Gestiona las pilas que contendrá cada accion de nuestro patrón
     * @param color - recibirá el color
     * @param turn - recibirá el turno correspondiente
     */

    public GestorComandos(Color color, Turn turn) {
        pilaredo = new Pila<Color>();
        pilaundo = new Pila<Color>();
        this.turn = turn;
        this.color = Color.R;
    }

    static GestorComandos getInstance(Color color, Turn turn) {
        if (gestor != null) {
            return gestor;
        } else {
            return new GestorComandos(color, turn);
        }
    }

    /**
     * Añade un elemento al principio de la pila de undo cada vez que depositemos una ficha
     * @param color - recibirá el color que se este usando en ese momento
     */

    public void execute(Color color) {
        pilaundo.apilar(color);
    }

    /**
     * ejecutará la accion de deshacer
     */

    public void undo() {
        if (!pilaundo.isVacia()) {
            Color color = pilaundo.desapilar();
            pilaredo.apilar(color);
       }
    }

    /**
     * ejecutará la accion de rehacer
     * @return - nos devolvera el valor la ficha que se ha vuelto a poner
     */

    public Color redo() {
      if (!pilaredo.isVacia()) {
          pilaundo.apilar(color);
          Color color = pilaredo.desapilar();
          return color;
      }
      return Color.NULL;
    }
}
