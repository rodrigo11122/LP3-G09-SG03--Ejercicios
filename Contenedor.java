package ejercicios;

import java.util.ArrayList;

public class Contenedor<F, S> {
    private ArrayList<Par<F, S>> lista;

    public Contenedor() {
        lista = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        lista.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return lista;
    }

    public void mostrarPares() {
        for (Par<F, S> par : lista) {
            System.out.println(par);
        }
    }
}
