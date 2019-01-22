package EntradaDatos;
import java.util.*;
public class EntradaDatosScanner_M {
    public static void main(String[] args) {
        String captura = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce un Dato: ");
        captura = scan.nextLine();
        while (captura !=null){
            System.out.println("Dato Introducido = " + captura);
            captura = scan.nextLine();
            if("exit".equals(captura))
                break;
        }
    }
}
