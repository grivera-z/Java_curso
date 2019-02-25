package _4_Estrucuras_Arbol_Binario;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Arbol_Binario_Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado(20,"Pepito Perez", "Ventas", "A-252");
        Empleado e2 = new Empleado(44,"Ana Lopez", "Recursos Humanos", "B-198");
        Empleado e3 = new Empleado(18,"Elena Nito", "Ventas", "A-241");
        Empleado e4 = new Empleado(33,"Jose Gomez", "Contabilidad", "B-96");
        Empleado e5 = new Empleado(64,"Francisco Perez", "Marketing", "A-69");
        Empleado e6 = new Empleado(55,"Javier Lopez", "Informatica", "B-161");

        Arbol_Binario bst = new Arbol_Binario();
        Arrays.asList(e1,e2,e3,e4,e5,e6).forEach(e -> bst.insertar(e));
        System.out.println("Preorden");
        bst.preorden();
        System.out.println();

        System.out.println("Inorden");
        bst.inorden();
        System.out.println();


        System.out.println("Postorden");
        bst.postorden();


    }

    private static void Localizar(Arbol_Binario bst, int id_empleado){
        if (bst.existe(id_empleado)){
            System.out.println(bst.obtener(id_empleado));
        }else{
            System.out.println("No se encontro el Empleado "+ id_empleado);
        }
    }
}
