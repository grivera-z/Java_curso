package Enum;

public enum Continentes {
    AFRICA(53),
    AUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);

    /**
     * Atributos de cada elemento de una enumeracion
     */
    private final int paises;
    Continentes(int paises){
        this.paises=paises;
    }
    public int getPaises(){
        return paises;
    }
}
