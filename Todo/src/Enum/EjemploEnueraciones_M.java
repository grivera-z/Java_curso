package Enum;

public class EjemploEnueraciones_M {
    public static void main(String[] args) {
        System.out.println("Dias.LUNES = " + Dias.LUNES);
        indicarDia(Dias.VIERNES);
        indicarDia(Dias.Z);

        System.out.println("Continentes.AFRICA = " + Continentes.AFRICA);
        System.out.println("Continentes.AFRICA.getPaises() = " + Continentes.AFRICA.getPaises());
        indicarPaises(Continentes.AFRICA);
        impirmirContinentes();
    }


    public static void indicarDia(Dias dias){
        switch (dias){
            case LUNES:
                System.out.println("Primer dia de la semana");
                break;
            case MARTES:
                System.out.println("Segundo dia de la semana");
                break;
            case MIERCOLES:
                System.out.println("Tercer dia de la semana");
                break;
            case JUEVES:
                System.out.println("Cuarto dia de la semana");
                break;
            case VIERNES:
                System.out.println("Quinto dia de la semana");
                break;
            case SABADO:
                System.out.println("Sexto dia de la semana");
                break;
            case DOMINGO:
                System.out.println("Septimo dia de la semana");
                break;
            default:
                System.out.println("Y asi seguimos los demas dias");
        }
    }

    public static void indicarPaises(Continentes continentes){
        switch (continentes){
            case AFRICA:
                System.out.println("No. Paises en: " + continentes + "  #: "+ continentes.getPaises());
                break;
            default:
                System.out.println("Y asi seguimos los demas Continentes");

        }
    }
    public static void impirmirContinentes(){
        for(Continentes c:Continentes.values()){
            System.out.println("Continente: " + c  + " - Contiene: "+ c.getPaises() + " Paises.");
        }
    }
}
