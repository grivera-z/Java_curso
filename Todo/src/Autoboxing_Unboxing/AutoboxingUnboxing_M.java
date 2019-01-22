package Autoboxing_Unboxing;

public class AutoboxingUnboxing_M {
    public static void main(String[] args) {
        /** *Autoboxing (Se convierten de tipos primitivos a tipos Object) */
        Integer enteroObj = 10;
        Float flotanteObj = 15.2F;
        Double dobleObj = 40.1;
        System.out.println("Autoboxing");
        System.out.println("enteroObj = " + enteroObj.intValue());
        System.out.println("flotanteObj = " + flotanteObj.floatValue());
        System.out.println("dobleObj = " + dobleObj.doubleValue());

        System.out.println("\ntest");
        System.out.println("enteroObj = " + enteroObj.toString());
        System.out.println("flotanteObj = " + flotanteObj.doubleValue());
        System.out.println("dobleObj = " + dobleObj);


        /** *Autoboxing (Se convierten de tipos Object a tipos primitivos ) */
        int entero = enteroObj;
        float flotante = flotanteObj;
        double doble = dobleObj;
        System.out.println("AutoUnboxing ");
        System.out.println("entero = " + entero);
        System.out.println("flotante = " + flotante);
        System.out.println("doble = " + doble);

    }
}
