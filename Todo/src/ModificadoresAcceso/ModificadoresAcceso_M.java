package ModificadoresAcceso;

import ModificadoresAcceso.paquete1.Clase2;
import ModificadoresAcceso.paquete2.Clase3;
import ModificadoresAcceso.paquete2.Clase4;

public class ModificadoresAcceso_M {
    public static void main(String[] args) {
        System.out.println("*** Acceso desde Calse 2 a clase 1 (Mismo Paquete)");
        new Clase2().pruebaDesdeClase2();

        System.out.println("*** Acceso desde Calse 3 a clase 1 (Diferente Paquete, Pero es SubClase)");
        new Clase3().pruebaDesdeClase3();

        System.out.println("*** Acceso desde Calse 4 a clase 1 (Diferente Paquete, NO es SubClase)");
        new Clase4().pruebaDesdeClase4();
    }
}
