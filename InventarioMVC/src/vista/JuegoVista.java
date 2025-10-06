package vista;

import modelo.Enemigo;
import modelo.Jugador;
import java.util.List;
import java.util.Scanner;

public class JuegoVista {
    private Scanner scanner = new Scanner(System.in);

    public String pedir(String p){ System.out.print(p); return scanner.nextLine(); }
    public void mostrarMensaje(String m){ System.out.println(m); }
    public void mostrarEstado(Jugador j, List<Enemigo> enemigos){
        System.out.println("\n--- ESTADO ---");
        System.out.println("Jugador: " + j.getNombre() + " HP:" + j.getSalud() + " Lvl:" + j.getNivel());
        System.out.println("Enemigos:"); enemigos.forEach(e -> System.out.println(e));
    }
}
