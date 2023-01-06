//package designPatterns;

import java.util.LinkedList;
import java.util.List;

public class Pila<Color> {
    private Color Color;
    private List<Color> lista;
    public Pila() {
        lista = new LinkedList<>();
    }
    public void apilar (Color elemento) {
        lista.add(0, elemento);
    }

    public Color desapilar() {
        if (lista.size() > 0) {
            viewList();
            return lista.remove(lista.size() - 1);
        }
        else
            return null;
    }

    public boolean isVacia() {
        return lista.size() == 0;
    }

    public void viewList(){
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }

    public void vaciar() {
        lista.clear();
    }
}
