package modelo;

import java.util.ArrayList;
import java.util.List;

public class CatalogoModelo {
    private List<Producto> productos;
    public CatalogoModelo() {
        productos = new ArrayList<>();
        // algunos productos iniciales
        productos.add(new Producto(1, "Arroz Chaufa", 12.50));
        productos.add(new Producto(2, "Lomo Saltado", 25.00));
        productos.add(new Producto(3, "Ceviche", 18.00));
    }
    public List<Producto> getProductos(){ return productos; }
    public Producto buscarPorId(int id) {
        return productos.stream().filter(p -> p.getId()==id).findFirst().orElse(null);
    }
}
