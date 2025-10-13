import java.io.*;
import java.util.*;

class Empleado {
    int numero;
    String nombre;
    double sueldo;

    Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String toString() {
        return numero + "," + nombre + "," + sueldo;
    }
}

class Modelo {
    private final String archivo = "empleados.txt";

    public List<Empleado> leerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                lista.add(new Empleado(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2])));
            }
        } catch (IOException e) {}
        return lista;
    }

    public void guardarEmpleados(List<Empleado> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Empleado e : lista) pw.println(e.toString());
        } catch (IOException e) {}
    }
}

class Controlador {
    private Modelo modelo = new Modelo();
    private List<Empleado> empleados;

    public Controlador() {
        empleados = modelo.leerEmpleados();
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
        modelo.guardarEmpleados(empleados);
    }

    public void listar() {
        empleados.forEach(System.out::println);
    }

    public void buscar(int numero) {
        empleados.stream().filter(e -> e.numero == numero).forEach(System.out::println);
    }

    public void eliminar(int numero) {
        empleados.removeIf(e -> e.numero == numero);
        modelo.guardarEmpleados(empleados);
    }
}

public class Ejercicio3_EmpleadosMVC {
    public static void main(String[] args) {
        Controlador c = new Controlador();
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n1. Listar 2. Agregar 3. Buscar 4. Eliminar 5. Salir");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1 -> c.listar();
                case 2 -> {
                    System.out.print("Número: "); int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Sueldo: "); double s = sc.nextDouble();
                    c.agregarEmpleado(new Empleado(num, nom, s));
                }
                case 3 -> {
                    System.out.print("Número a buscar: "); int nb = sc.nextInt();
                    c.buscar(nb);
                }
                case 4 -> {
                    System.out.print("Número a eliminar: "); int ne = sc.nextInt();
                    c.eliminar(ne);
                }
            }
        } while (op != 5);
        sc.close();
    }
}
