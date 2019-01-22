package SobreEscritura;

public class Gerente extends Empleado {
    private String departamento;
    public Gerente(String nombre,double sueldo,String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;
    }
//    public String obtenerDetalles(){
//        return  "Nombre: "+super.getNombre() +",\nsueldo: "+super.getSueldo() + ",\nDepartamento: "+departamento;
//    }
    public String obtenerDetalles(){
        return  "Nombre: "+nombre +",\nsueldo: "+sueldo + ",\nDepartamento: "+departamento;
    }
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public void change_static(){
        test = 10;
    }

}
