package Bloque_Codigo;

public class Persona {
    private final int idPersona;
    private static int contadorPersonas;
    static {
        System.out.println("Ejecuta Bloque estatico");
        contadorPersonas=10;
    }
    {
        System.out.println("Ejecuta bloque inicializador");
        idPersona = ++contadorPersonas;
    }
    public Persona(){
        System.out.println("Ejecuta Constructor");
    }
    public int getIdPersona(){
        return idPersona;
    }
}
