package _2_Estructuras_Colas;

public class MiColaProceso implements ColaProceso{

    private class NodoProceso{
        public Trabajo trabajo;
        public NodoProceso siguiente;
        public NodoProceso(Trabajo trabajo){
            this.trabajo = trabajo;
            this.siguiente = null;
        }
    }

    private NodoProceso cabeza, ultimo;

    @Override
    public void encolar(Trabajo trabajo) {
        NodoProceso nuevoNodo = new NodoProceso(trabajo);
        if (cabeza == null){
            cabeza = nuevoNodo;
        }else{
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
    }

    @Override
    public void eliminar() {
        if(cabeza != null){
            NodoProceso eliminar = cabeza;
            cabeza = cabeza.siguiente;
            eliminar.siguiente = null;
            if(cabeza == null){
                ultimo = null;
            }
        }
    }

    @Override
    public Trabajo obtener() {
        if(cabeza == null ){
            return null;
        }else{
            return cabeza.trabajo;
        }
    }
}
