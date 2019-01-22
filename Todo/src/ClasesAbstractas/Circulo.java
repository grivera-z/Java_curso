package ClasesAbstractas;

public class Circulo extends FiguraGeometrica {
    public Circulo(String tipoFigura) {
        super(tipoFigura);
    }

    public void dibujar() {
        //Comportamiento de la subclase
        System.out.println("AquÃ­ deberÃ­a dibujar un:" + this.getClass().getSimpleName());
    }
}
