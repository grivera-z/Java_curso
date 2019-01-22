package ManejoJavaBeans;

import java.io.Serializable;
//1. implementa la interface Serializable
public class PersonaBean implements Serializable {
    //2. Cada propiedad es de tipo private
    private String nombre;
    private int edad;
    //3.Siempre tiene un Constructor sin argumentos
    public PersonaBean(){
    }
    public PersonaBean(String nombre,int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    //4. Por cada propiedad agrega un get y set (o solo uno de ellos)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
