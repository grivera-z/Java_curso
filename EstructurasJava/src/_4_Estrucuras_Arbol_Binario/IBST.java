package _4_Estrucuras_Arbol_Binario;

public interface IBST<T extends Comparable> {
    void insertar(T empl);
    boolean existe(int id_Empleado);
    T obtener(int id_Empleado);
    boolean esHoja();
    boolean esVacio();
    void preorden();
    void inorden();
    void postorden();
    void eliminar(int id_Empleado);
}
