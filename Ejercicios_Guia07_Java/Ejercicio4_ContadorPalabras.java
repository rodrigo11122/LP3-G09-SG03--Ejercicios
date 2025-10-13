import javax.swing.*;
import java.io.*;
import java.util.*;

public class Ejercicio4_ContadorPalabras {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó archivo.");
            return;
        }
        File archivo = fc.getSelectedFile();
        int lineas = 0, palabras = 0, caracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                String[] tokens = linea.split("\s+");
                for (String t : tokens) {
                    if (!t.isEmpty()) {
                        palabras++;
                        caracteres += t.length();
                        t = t.toLowerCase();
                        frecuencia.put(t, frecuencia.getOrDefault(t, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Total de líneas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de caracteres: " + caracteres);
        System.out.println("Promedio de palabras por línea: " + (lineas > 0 ? (palabras / (double) lineas) : 0));

        System.out.println("\nPalabras más frecuentes:");
        frecuencia.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
