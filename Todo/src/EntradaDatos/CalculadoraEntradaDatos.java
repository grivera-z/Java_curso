package EntradaDatos;
import java.util.*;
public class CalculadoraEntradaDatos {
    public static void main(String[] args) {
        System.out.println("Proporciona el primer Valor: ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Proporciona el Segundo Valor: ");
        int b = scan.nextInt();
        int result = sumar(a,b);
        System.out.println("El resultado de la suma es = " + result);
    }
    public static int sumar(int a,int b){
        return (a+b);
    }
}
