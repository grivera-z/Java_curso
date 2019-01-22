package ComversionObjecto;

public class ConversionObjectos_M {
    public static void main(String[] args) {
        Empleado empleado = new Escritor("Roy",1500,TipoEscritura.CLASICO);
        imprimirDetalles(empleado);

        empleado = new Gerente("Laura",255555,"Casa");
        imprimirDetalles(empleado);

    }
    private static void imprimirDetalles(Empleado e1){
        if(e1 instanceof Escritor){
            System.out.println(((Escritor) e1).getTipoDeEscrituraEnTexto());
        }
        else if (e1 instanceof Gerente){
            System.out.println(((Gerente) e1).getDepartamento());
        }

    }
}
