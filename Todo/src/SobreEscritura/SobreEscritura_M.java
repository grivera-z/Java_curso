package SobreEscritura;

public class SobreEscritura_M {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("pepe",200000);
        System.out.println(e1.obtenerDetalles());

        Gerente g1 = new Gerente("Goku",999999,"Super Sayan");
        System.out.println(g1.obtenerDetalles());
        g1.change_static();


        System.out.println("\nPoliformismo");
        Empleado polimorfismo = new Empleado("Arturo",655555);
        System.out.println("polimorfismo = " + polimorfismo.obtenerDetalles());

        System.out.println("\nPoliformismo Gerente");
        polimorfismo =  new Gerente("Gabriel",35555,"Mi Cama");
        System.out.println("polimorfismo = " + polimorfismo.obtenerDetalles());


    }
}
