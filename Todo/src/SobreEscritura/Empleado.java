package SobreEscritura;

public class Empleado {
    protected String nombre;
    protected double sueldo;
    public static int test;
    {
        ++test;
    }

    protected Empleado(String nombre, double sueldo){
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public String obtenerDetalles(){
        return  "Nombre: "+nombre +",\nsueldo: "+sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setTest(int test){
        this.test = test;
    }
    public int getTest(){
        return  test;
    }
}
