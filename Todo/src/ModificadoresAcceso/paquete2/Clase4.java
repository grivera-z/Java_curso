package ModificadoresAcceso.paquete2;

import ModificadoresAcceso.paquete1.Clase1;

public class Clase4 {
    public  Clase4(){
        //Constructor protegido,al ser una subclase puede acceder
        //Aunque este en otro paquete
        //Paquete Publico desde clase 3
        //super(1,2);
        //Acceso packege, y al estar fuera de paquete esta restrugindo
        //super(1,2,3);
        //Acceso privado,Restringido
        //Super(1,2,3,4)
    }
    public void pruebaDesdeClase4(){
        Clase1 c1 = new Clase1();
        System.out.println("");
        System.out.println("c1.atrPublico = " + c1.atrPublico +"Heredado:");
        System.out.println("c1.atrProtected  = Acceso negado" /*+ c1.atrProtected*/);
        System.out.println("c1.atrPaquete Default  = Acceso negado" /*+ c1.atrPaquete*/);
        System.out.println("Atributo private : Acceso negado");

        new Clase1();

        System.out.println("");
        System.out.println("c1.metodoPublico() = " + c1.metodoPublico());
        System.out.println("c1.metodoProtegido() : Acceso negado " /* + c1.metodoProtegido()*/);
        System.out.println("c1.metodoPaquete() Default : Acceso negado " /* + c1.metodoPaquete()*/);
        System.out.println("metodoPaquete private : Acceso negado");
    }
}
