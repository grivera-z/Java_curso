package _3_Estructuras_Pila;

public interface Pila {
    public void apilar(URL url);
    public void desapilar();
    public URL obtener();
    public int longitud();
    public boolean vacia();
}
