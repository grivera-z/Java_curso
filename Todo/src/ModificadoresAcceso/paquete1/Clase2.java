package ModificadoresAcceso.paquete1;

public class Clase2 {
    public Clase2(){
        System.out.println("");
        //Constructor Publico
        new Clase1(1);
        //Constructor Protegido
        new Clase1(1,2);
        //Constructor default o package
        new Clase1(1,2,3);
        //Constructor Privado
        //new Clase1(1,2,3,4);
        System.out.println("Construcotr Private: Acceso negado");
    }

    public void pruebaDesdeClase2(){
        Clase1 c1 = new Clase1();
        System.out.println("");
        System.out.println("c1.atrPublico = " + c1.atrPublico);
        System.out.println("c1.atrProtected = " + c1.atrProtected);
        System.out.println("c1.atrPaquete Default = " + c1.atrPaquete);
        System.out.println("Atributo private: Acceso negado");

        System.out.println("");
        System.out.println("c1.metodoPublico() = " + c1.metodoPublico());
        System.out.println("c1.metodoProtegido() = " + c1.metodoProtegido());
        System.out.println("c1.metodoPaquete() Default = " + c1.metodoPaquete());
        System.out.println("metodoPaquete private: Acceso negado");
    }
}
