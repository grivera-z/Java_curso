package ProyectoFinal.peliculas.excepciones;

public class LecturaDatosEx extends AccesoDatosEx {
    public LecturaDatosEx(String mensaje){
        super("Error En LecturaDE: "+mensaje);
    }
}
