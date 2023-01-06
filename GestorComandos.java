//package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class GestorComandos {
    private static GestorComandos gestor = null;
    private Color color;
    private Turn turn;
    private Pila<Color> pilaundo;
    private Pila<Color> pilaredo;
    private List<String> historiadecomandos;
    private int lastColumn;

    public GestorComandos(Color color, Turn turn) {
        pilaredo = new Pila<Color>();
        pilaundo = new Pila<Color>();
        historiadecomandos = new ArrayList<>();
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

    public void execute(Color color) {
        pilaundo.apilar(color);
    }

    public void undo() {
        System.out.println("undo fuera");
        if (!pilaundo.isVacia()) {
            System.out.println("undo intentando");
            Color color = pilaundo.desapilar();
            System.out.println("color desapilado es: " + color);
            pilaredo.apilar(color);
       }
    }

    public Color redo() {
      if (!pilaredo.isVacia()) {
          System.out.println("redo intentando");
            Color color = pilaredo.desapilar();
            pilaundo.apilar(color);
            return color;
      }
      return Color.NULL;
    }
}
