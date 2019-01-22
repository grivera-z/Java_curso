package ManejoGenericos;

public class ManejoGenericos_M {
    public static void main(String[] args) {
        ClaseGenerica<Integer> objInt = new ClaseGenerica<Integer>(15);
        System.out.println("objInt = " + objInt.getObjecto());
        objInt.obtenerTipo();

        ClaseGenerica<String> objStr = new ClaseGenerica<String>("Hola");
        System.out.println("objInt = " + objStr.getObjecto());
        objStr.obtenerTipo();
    }
}
