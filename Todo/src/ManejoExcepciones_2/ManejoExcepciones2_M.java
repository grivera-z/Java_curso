package ManejoExcepciones_2;
import ManejoExcepciones_2.datos.*;
import ManejoExcepciones_2.excepciones.*;
public class ManejoExcepciones2_M {
    public static void main(String[] args) {
        AccesoDatos datos = new ImplementacionMySql();
        //cambiamos el estado a simular Error = true
        datos.simularError(true);
        ejecutar(datos,"listar");

        System.out.println("");
        datos.simularError(false);
        ejecutar(datos,"insertar");
    }
    private static void ejecutar(AccesoDatos datos, String accion){
        if("listar".equals(accion)) {
            try {
                datos.listar();
            }catch (LecturaDatosEx ex){
                System.out.println("Error Lectura: Procesa la excepcion mas especifica de lectura de datos");
            }catch (AccesoDatosEx ex){
                System.out.println("Error Acceso datos: Procesa la excepcion mas Generica de Acceso a datos");
            }catch (Exception ex){
                System.out.println("Error General");
            }finally {
                System.out.println("Proceso finally es opcional, siempre se ejecutara sin importar si hubo error o no");
            }
        }
        else if("insertar".equals(accion)) {
            try {
                datos.insertar();
            }catch (AccesoDatosEx ex){
                System.out.println("Podemos procesar solo la excepcion mas generica");
            }finally {
                System.out.println("Proceso finally es opcional, siempre se ejecutara sin importar si hubo error o no");
            }
        }
        else
            System.out.println("No se Proporciono ninguna accion conocida");
    }

}
