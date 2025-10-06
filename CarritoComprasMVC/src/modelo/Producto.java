package modelo;

public class Producto {
    private String nombre;
    private double precio;
    private int id;
    public Producto(int id, String nombre, double precio) {
        this.id = id; this.nombre = nombre; this.precio = precio;
    }
    public int getId(){return id;}
    public String getNombre(){return nombre;}
    public double getPrecio(){return precio;}
    @Override public String toString(){ return id+". " + nombre + " - S/" + precio; }
}
