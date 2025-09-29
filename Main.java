package ejercicios;

public class Main {
 
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Hola", 10);
        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Juan", 20), 5);

        System.out.println("Imprimiendo pares:");
        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
