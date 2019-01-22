package ProyectoFinal.peliculas.excepciones;

public class EscrituraDatosEx extends AccesoDatosEx{
    public EscrituraDatosEx(String mensaje){
        super("Error en EscrituraDE: "+mensaje);
    }
}
