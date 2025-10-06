package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner = new Scanner(System.in);
    public void mostrarCatalogo(List<Producto> productos){ productos.forEach(System.out::println); }
    public void mostrarCarrito(List<Producto> c){
        if(c.isEmpty()) System.out.println("Carrito vacío."); else c.forEach(System.out::println);
    }
    public String pedir(String prompt){ System.out.print(prompt); return scanner.nextLine(); }
    public void mostrarMensaje(String m){ System.out.println(m); }
    public void mostrarMenu(){
        System.out.println("\n--- CARRITO ---");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Agregar al carrito (id)");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar del carrito (indice)");
        System.out.println("5. Comprar");
        System.out.println("6. Historial");
        System.out.println("7. Salir");
    }
}
