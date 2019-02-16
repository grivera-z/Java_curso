package _2_Estructuras_Colas;

public class Colas_Main_M {
    public static void main(String[] args) {
        Trabajo t1 = new Trabajo("T1","T1");
        Trabajo t2 = new Trabajo("T2","T2");
        Trabajo t3 = new Trabajo("T3","T3");
        Trabajo t4 = new Trabajo("T4","T4");
        Trabajo t5 = new Trabajo("T5","T5");

        MiColaProceso mc = new MiColaProceso();

        mc.encolar(t1);
        mc.encolar(t2);
        mc.encolar(t3);
        mc.encolar(t4);
        mc.encolar(t5);

        while (mc.obtener() != null){
            //System.out.println("Entrando en proceso de impresion");
            mc.obtener().setImpreso(true);
            System.out.println("mc.obtener() = " + mc.obtener());
            mc.eliminar();
        }




    }
}
