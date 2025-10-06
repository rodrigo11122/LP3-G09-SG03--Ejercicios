import modelo.CatalogoModelo;
import modelo.CarritoModelo;
import vista.CarritoVista;
import controlador.CarritoControlador;

public class MainCarrito {
    public static void main(String[] args) {
        CatalogoModelo catalogo = new CatalogoModelo();
        CarritoModelo carrito = new CarritoModelo();
        CarritoVista vista = new CarritoVista();
        CarritoControlador controlador = new CarritoControlador(catalogo, carrito, vista);
        controlador.iniciar();
    }
}
