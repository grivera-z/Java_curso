package _1_Estructuras_Listas_Enlazadas;

public class ListasLigadasSimples_M {
    public static void main(String[] args) {
        Libro l1 =  new Libro("1","1","1");
        Libro l2 =  new Libro("2","2","2");
        Libro l3 =  new Libro("3","3","3");
        Libro l4 =  new Libro("4","4","4");
        Libro l5 =  new Libro("5","5","5");

        Lista lis1 = new Lista();
        lis1.insertarFinal(l1);
        lis1.insertarFinal(l2);
        lis1.insertarFinal(l3);
        lis1.insertarFinal(l4);
        lis1.insertarFinal(l5);


        System.out.println(lis1.obtener(2).toString());
        System.out.println("lis1.Contador() = " + lis1.Contador());


    }
}
