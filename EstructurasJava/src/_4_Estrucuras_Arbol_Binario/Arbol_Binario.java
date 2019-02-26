package _4_Estrucuras_Arbol_Binario;

public class Arbol_Binario implements IBST<Empleado> {
    private Empleado valor;
    private Arbol_Binario izdo,dcho;
    private Arbol_Binario padre;

    @Override
    public boolean esVacio() {
        return valor==null;
    }

    @Override
    public boolean esHoja() {
        return valor!=null && izdo == null && dcho==null;
    }

    private void insertarImpl(Empleado empl,Arbol_Binario padre) {
        if(valor==null){
            this.valor=empl;
            this.padre=padre;
        }else{
            if(empl.compareTo(valor)<0){
                if(izdo == null) izdo = new Arbol_Binario();
                izdo.insertarImpl(empl,this);
            }else if (empl.compareTo(valor)>0){
                if(dcho==null) dcho = new Arbol_Binario();
                dcho.insertarImpl(empl,this);
            }else{
                throw new RuntimeException("Estas metiendo Objeto duplicado");
            }
        }
    }

    @Override
    public void insertar(Empleado empl) {
        insertarImpl(empl,null);
    }


    @Override
    public boolean existe(int id_Empleado) {
        if(valor != null){
            if (id_Empleado==valor.getId_Empleado()){
                return true;
            }else if(id_Empleado < valor.getId_Empleado() && izdo != null){
                return izdo.existe(id_Empleado);
            }else if(id_Empleado > valor.getId_Empleado() && dcho != null){
                return dcho.existe(id_Empleado);
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public Empleado obtener(int id_Empleado) {
        if(valor != null){
            if (id_Empleado==valor.getId_Empleado()){
                return valor;
            }else if(id_Empleado < valor.getId_Empleado() && izdo != null){
                return izdo.obtener(id_Empleado);
            }else if(id_Empleado > valor.getId_Empleado() && dcho != null){
                return dcho.obtener(id_Empleado);
            }else{
                return null;
            }
        }else {
            return null;
        }
    }

    private void preordenImpl(String prefijo){
        if(valor != null){
            System.out.println(prefijo + valor);
            if(izdo != null) izdo.preordenImpl(prefijo + "I: --");
            if(dcho != null) dcho.preordenImpl(prefijo + "D: --");
        }
    }

    @Override
    public void preorden() {
        preordenImpl("");
    }

    public void inordenImpl(String prefijo){
        if(valor != null){
            if(izdo != null) izdo.inordenImpl(prefijo + "I: --");
            System.out.println(prefijo+valor);
            if(dcho != null) dcho.inordenImpl(prefijo + "D: --");
        }
    }

    @Override
    public void inorden() {
        inordenImpl("");
    }

    public void postordenImpl(String prefijo){
        if(valor != null){
            if(izdo != null) izdo.postordenImpl(prefijo + "I: --");
            if(dcho != null) dcho.postordenImpl(prefijo + "D: --");
            System.out.println(prefijo + valor);
        }
    }

    @Override
    public void postorden() {
        postordenImpl("");
    }

    private Arbol_Binario minimo(){
        if(izdo !=null && !izdo.esVacio()) {
            return izdo.minimo();
        }else {
            return this;
        }
    }

    private void eliminarImpl(int id_Empleado){
        if(izdo != null && dcho != null){
            //Eliminar con 2 Hijos
            Arbol_Binario minimo = dcho.minimo();
            this.valor = minimo.valor;
            dcho.eliminar(minimo.valor.getId_Empleado());
        }else if (izdo != null || dcho != null){
            //Eliminar con 1 Hijos
            Arbol_Binario sustituto = (izdo != null) ? izdo:dcho;
            this.valor = sustituto.valor;
            this.izdo = sustituto.izdo;
            this.dcho = sustituto.dcho;

        }else{
            //Eliminar con 0 Hijos
            if(padre != null){
               if(this == padre.izdo) padre.izdo = null;
               if(this == padre.dcho) padre.dcho = null;
               padre = null;
            }
            valor=null;
        }

    }


    @Override
    public void eliminar(int id_Empleado) {
        if(valor != null){
             if(id_Empleado == valor.getId_Empleado()){
                eliminarImpl(id_Empleado);
             }else if(id_Empleado < valor.getId_Empleado() && izdo != null){
                 izdo.eliminar(id_Empleado);
             }else if(id_Empleado > valor.getId_Empleado() && dcho != null){
                 dcho.eliminar(id_Empleado);
             }
        }
    }
}
