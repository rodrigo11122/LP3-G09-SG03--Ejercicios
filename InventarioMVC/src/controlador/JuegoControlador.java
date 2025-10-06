package controlador;

import modelo.*;
import vista.JuegoVista;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoControlador {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private JuegoVista vista;
    private Random rnd = new Random();

    public JuegoControlador(Jugador j, List<Enemigo> enemigos, JuegoVista vista) {
        this.jugador = j; this.enemigos = enemigos; this.vista = vista;
    }

    public void iniciar() {
        String opt;
        do {
            vista.mostrarEstado(jugador, enemigos);
            opt = vista.pedir("Acción (1=Atacar, 2=Usar item, 3=Salir): ");
            switch(opt) {
                case "1":
                    if(enemigos.isEmpty()){ vista.mostrarMensaje("No hay enemigos."); break; }
                    Enemigo e = enemigos.get(0);
                    jugador.atacar(e);
                    vista.mostrarMensaje("Atacaste a " + e.getNombre());
                    if(!e.estaVivo()){ vista.mostrarMensaje(e.getNombre() + " derrotado."); enemigos.remove(e); jugador.subirNivel(); }
                    // enemigos atacan aleatoriamente
                    enemigos.forEach(en -> { if(en.estaVivo()) { if(rnd.nextBoolean()) en.atacar(jugador); } });
                    break;
                case "2":
                    if(jugador.getInventario().isEmpty()){ vista.mostrarMensaje("No tienes items."); break; }
                    String item = jugador.getInventario().get(0);
                    jugador.usarObjeto(item);
                    vista.mostrarMensaje("Usaste: " + item);
                    break;
                case "3": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción inválida."); break;
            }
        } while(!opt.equals("3") && jugador.estaVivo());
        if(!jugador.estaVivo()) vista.mostrarMensaje("Has muerto. Fin del juego."); else vista.mostrarMensaje("Juego terminado."); 
    }
}
