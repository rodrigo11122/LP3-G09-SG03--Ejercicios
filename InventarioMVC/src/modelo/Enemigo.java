package modelo;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int nivel, String tipo) {
        this.nombre = nombre; this.nivel = nivel; this.tipo = tipo; this.salud = 30 + nivel*10;
    }

    public String getNombre(){ return nombre; }
    public int getSalud(){ return salud; }
    public int getNivel(){ return nivel; }
    public String getTipo(){ return tipo; }

    public void recibirDaño(int d){ salud -= d; if(salud<0) salud=0; }
    public void atacar(Jugador j){ j.recibirDaño(5 + nivel*2); }
    public boolean estaVivo(){ return salud>0; }
    @Override public String toString(){ return nombre + " (Lvl " + nivel + ") - " + tipo + " - HP:" + salud; }
}
