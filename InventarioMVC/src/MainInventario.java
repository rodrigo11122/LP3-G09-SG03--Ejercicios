import modelo.*;
import vista.JuegoVista;
import controlador.JuegoControlador;
import java.util.ArrayList;
import java.util.List;

public class MainInventario {
    public static void main(String[] args) {
        Jugador j = new Jugador("Heroe");
        j.getInventario().add("Pocion");
        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Rata", 1, "Bestia"));
        enemigos.add(new Enemigo("Goblin", 2, "Humanoide"));
        JuegoVista vista = new JuegoVista();
        JuegoControlador ctrl = new JuegoControlador(j, enemigos, vista);
        ctrl.iniciar();
    }
}
