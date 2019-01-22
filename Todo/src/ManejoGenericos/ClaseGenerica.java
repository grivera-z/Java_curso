package ManejoGenericos;

import ModificadoresAcceso.paquete2.Clase4;

public class ClaseGenerica<T> {
    private T objecto;
    public ClaseGenerica(T objecto){
        this.objecto = objecto;
    }

    public void obtenerTipo(){
        System.out.println("El Tipo T es: "+ objecto.getClass().getName());
    }
    public T getObjecto(){
        return objecto;
    }
}
