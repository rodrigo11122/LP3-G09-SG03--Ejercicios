package controlador;

import modelo.*;
import vista.CarritoVista;
import java.util.List;

public class CarritoControlador {
    private CatalogoModelo catalogo;
    private CarritoModelo carrito;
    private CarritoVista vista;

    public CarritoControlador(CatalogoModelo catalogo, CarritoModelo carrito, CarritoVista vista) {
        this.catalogo = catalogo; this.carrito = carrito; this.vista = vista;
    }

    public void iniciar() {
        String opt;
        do {
            vista.mostrarMenu();
            opt = vista.pedir("Opción: ");
            switch(opt) {
                case "1":
                    vista.mostrarCatalogo(catalogo.getProductos()); break;
                case "2":
                    try {
                        int id = Integer.parseInt(vista.pedir("ID producto: "));
                        Producto p = catalogo.buscarPorId(id);
                        if(p!=null){ carrito.agregar(p); vista.mostrarMensaje("Agregado."); } else vista.mostrarMensaje("No existe.") ;
                    } catch(Exception e){ vista.mostrarMensaje("ID inválido."); }
                    break;
                case "3":
                    vista.mostrarCarrito(carrito.verCarrito()); vista.mostrarMensaje("Total: S/"+carrito.total()); break;
                case "4":
                    try { carrito.eliminar(Integer.parseInt(vista.pedir("Indice a eliminar: "))); vista.mostrarMensaje("Eliminado."); } catch(Exception e){ vista.mostrarMensaje("Error."); }
                    break;
                case "5":
                    carrito.comprar(); vista.mostrarMensaje("Compra realizada."); break;
                case "6":
                    for(List<Producto> c : carrito.getHistorial()) { System.out.println("Compra:"); c.forEach(System.out::println); }
                    break;
                case "7": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción no válida."); break;
            }
        } while(!opt.equals("7"));
    }
}
