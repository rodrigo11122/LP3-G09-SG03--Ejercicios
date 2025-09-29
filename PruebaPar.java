package ejercicios;

public class PruebaPar {
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Uno", 1);
        Par<String, Integer> par2 = new Par<>("Uno", 1);
        Par<String, Integer> par3 = new Par<>("Dos", 2);

        System.out.println("Par1: " + par1);
        System.out.println("Par2: " + par2);
        System.out.println("Par3: " + par3);

        
        System.out.println("¿Par1 es igual a Par2?: " + par1.esIgual(par2));
        System.out.println("¿Par1 es igual a Par3?: " + par1.esIgual(par3));
    }
}
