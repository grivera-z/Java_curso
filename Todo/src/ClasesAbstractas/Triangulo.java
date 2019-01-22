package ClasesAbstractas;

public class Triangulo extends FiguraGeometrica {

    public Triangulo(String tipoFigura) {
        super(tipoFigura);
    }

    public void dibujar() {
        //Implementacion del metodo dibujar heredado de la clase FiguraGeometrica
        System.out.println("AquÃ­ deberÃ­a dibujar un:" + this.getClass().getSimpleName());
    }
}