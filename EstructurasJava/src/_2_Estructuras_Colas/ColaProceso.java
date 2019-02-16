package _2_Estructuras_Colas;

public interface ColaProceso {
    public void encolar(Trabajo t);
    public void eliminar();
    public Trabajo obtener();
}
