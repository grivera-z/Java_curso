package _4_Estrucuras_Arbol_Binario;

import java.util.Objects;

public class Empleado implements Comparable<Empleado>{
    private int id_Empleado;
    private String nombre;
    private String departamento;
    private String despacho;

    public Empleado(int id_Empleado,String nombre,String departamento, String despacho){
        this.id_Empleado=id_Empleado;
        this.nombre=nombre;
        this.departamento=departamento;
        this.despacho=despacho;
    }


    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
       /* return "Empleado{" +
                "id_Empleado=" + id_Empleado +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", despacho='" + despacho + '\'' +
                '}';*/
       return Integer.toString(id_Empleado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id_Empleado == empleado.id_Empleado &&
                nombre.equals(empleado.nombre) &&
                departamento.equals(empleado.departamento) &&
                despacho.equals(empleado.despacho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Empleado, nombre, departamento, despacho);
    }

    public int compareTo(Empleado empl){
        if (id_Empleado==empl.id_Empleado){
            return 0;
        }else if (id_Empleado<empl.id_Empleado){
            return -1;
        }else {
            return 1;
        }
    }


}
