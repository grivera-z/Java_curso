package InstanceOf;

public class InstanceOf_M {
    public static void main(String[] args) {
        FigurasGeometrica figura = new Elipse();
        determinarTipo(figura);
        System.out.println("\nTodos sus Tipos");
        determinarTodosLosTipos(figura);

        System.out.println();
        System.out.println("Test Another");
        FigurasGeometrica f1 = new Rectangulo();
        determinarTodosLosTipos(f1);
    }
    private static void determinarTodosLosTipos(FigurasGeometrica figura){
        if(figura instanceof Elipse){
            System.out.println("Elipse");
        }
        if(figura instanceof Circulo){
            System.out.println("Es un Circulo");
        }
        if(figura instanceof FigurasGeometrica){
            System.out.println("Es una figura geometrica");
        }
        if(figura instanceof Object){
            System.out.println("Es un Object");
        }
        else
            System.out.println("No se encontro el tipo");
    }
    private static void determinarTipo(FigurasGeometrica figura){
        if(figura instanceof Elipse){
            System.out.println("Es una Elipse");
        }
        else if(figura instanceof FigurasGeometrica){
            System.out.println("Es una Figura Geometrica");
        }
        else if (figura instanceof Object){
            System.out.println("Es un Objeto");
        }
        else{
            System.out.println("No se encontro el tipo");
        }
    }


}
