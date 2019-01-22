package EntradaDatos;
import java.io.*;
public class EntradaDatos_M {
    public static void main(String[] args) {
        String caputra;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bInput = new BufferedReader(input);
        try{
            System.out.println("Introduce un dato Buen samaritano :) = ");
            caputra = bInput.readLine();
            while (caputra!=null){
                System.out.println("Dato Introducido = " + caputra);
                caputra = bInput.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
