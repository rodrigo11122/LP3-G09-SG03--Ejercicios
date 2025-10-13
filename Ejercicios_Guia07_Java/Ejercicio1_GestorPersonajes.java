import java.io.*;
import java.util.*;

class Personaje {
    String nombre;
    int vida, ataque, defensa, alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance;
    }
}

class Gestor {
    private List<Personaje> lista = new ArrayList<>();
    private final String archivo = "personajes.txt";

    public Gestor() { leerArchivo(); }

    public void agregar(Personaje p) {
        if (lista.stream().anyMatch(x -> x.nombre.equalsIgnoreCase(p.nombre))) {
            System.out.println("El personaje ya existe.");
            return;
        }
        lista.add(p);
        guardarArchivo();
    }

    public void mostrar() {
        lista.forEach(p -> System.out.println(p.toString()));
    }

    public void eliminar(String nombre) {
        lista.removeIf(p -> p.nombre.equalsIgnoreCase(nombre));
        guardarArchivo();
    }

    public void modificar(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        for (Personaje p : lista) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                p.vida = nuevaVida;
                p.ataque = nuevoAtaque;
                p.defensa = nuevaDefensa;
                p.alcance = nuevoAlcance;
                break;
            }
        }
        guardarArchivo();
    }

    private void leerArchivo() {
        File f = new File(archivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5)
                    lista.add(new Personaje(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4])));
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : lista) pw.println(p.toString());
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}

public class Ejercicio1_GestorPersonajes {
    public static void main(String[] args) {
        Gestor g = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n1. Agregar 2. Mostrar 3. Modificar 4. Eliminar 5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Vida: "); int v = sc.nextInt();
                    System.out.print("Ataque: "); int a = sc.nextInt();
                    System.out.print("Defensa: "); int d = sc.nextInt();
                    System.out.print("Alcance: "); int al = sc.nextInt();
                    g.agregar(new Personaje(n, v, a, d, al));
                }
                case 2 -> g.mostrar();
                case 3 -> {
                    System.out.print("Nombre a modificar: "); String nm = sc.nextLine();
                    System.out.print("Nueva vida: "); int nv = sc.nextInt();
                    System.out.print("Nuevo ataque: "); int na = sc.nextInt();
                    System.out.print("Nueva defensa: "); int nd = sc.nextInt();
                    System.out.print("Nuevo alcance: "); int nal = sc.nextInt();
                    g.modificar(nm, nv, na, nd, nal);
                }
                case 4 -> {
                    System.out.print("Nombre a eliminar: "); String ne = sc.nextLine();
                    g.eliminar(ne);
                }
            }
        } while (opcion != 5);
        sc.close();
    }
}
