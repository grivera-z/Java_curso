package ManejoExcepciones_2.datos;
import ManejoExcepciones_2.excepciones.*;

public class ImplementacionMySql implements AccesoDatos{
    private boolean simularError;
    @Override
    public void insertar() throws AccesoDatosEx{
        if(simularError)
            throw new EscrituraDatosEx("Error de escritura de datos");
        else
            System.out.println("Insertar desde MySql");
    }

    @Override
    public void listar() throws AccesoDatosEx{
        if(simularError)
            throw new LecturaDatosEx("Error de Lectura de datos");
        else
            System.out.println("Lista de datos desde MySql");
    }
    public boolean isSimularError(){
        return simularError;
    }
    public void simularError(boolean simularError){
        this.simularError = simularError;
    }
}
