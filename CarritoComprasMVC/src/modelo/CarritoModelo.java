package modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<Producto> carrito;
    private List<List<Producto>> historial;

    public CarritoModelo() { carrito = new ArrayList<>(); historial = new ArrayList<>(); }

    public void agregar(Producto p){ carrito.add(p); }
    public void eliminar(int index){ if(index>=0 && index<carrito.size()) carrito.remove(index); }
    public double total(){ return carrito.stream().mapToDouble(Producto::getPrecio).sum(); }
    public List<Producto> verCarrito(){ return carrito; }
    public void comprar(){ historial.add(new ArrayList<>(carrito)); carrito.clear(); }
    public List<List<Producto>> getHistorial(){ return historial; }
}
