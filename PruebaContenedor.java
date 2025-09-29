package ejercicios;

public class PruebaContenedor {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("A", 1);
        contenedor.agregarPar("B", 2);
        contenedor.agregarPar("C", 3);

        System.out.println("Mostrando pares en el contenedor:");
        contenedor.mostrarPares();
    }
}
