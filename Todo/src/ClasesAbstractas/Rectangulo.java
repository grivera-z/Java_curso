package ClasesAbstractas;

public class Rectangulo extends FiguraGeometrica {

    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
    }

    public void dibujar() {
        //Comportamiento de la subclase
        System.out.println("AquÃ­ deberÃ­a dibujar un:" + this.getClass().getSimpleName());
    }

}