package ManejoInterfaces.datos;

public interface AccesoDatos {
    public static int MAX_REGISTRO = 10;
    public abstract void insertar();
    public abstract void listar();
}
