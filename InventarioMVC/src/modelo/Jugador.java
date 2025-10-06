package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private List<String> inventario;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
        this.inventario = new ArrayList<>();
    }

    public String getNombre(){ return nombre; }
    public int getSalud(){ return salud; }
    public int getNivel(){ return nivel; }
    public List<String> getInventario(){ return inventario; }

    public void recibirDaño(int d){ salud -= d; if(salud<0) salud=0; }
    public void atacar(Enemigo e){ e.recibirDaño(10 + nivel*2); }
    public void usarObjeto(String obj){ inventario.remove(obj); salud += 20; if(salud>100) salud=100; }
    public void subirNivel(){ nivel++; }
    public boolean estaVivo(){ return salud>0; }
}
