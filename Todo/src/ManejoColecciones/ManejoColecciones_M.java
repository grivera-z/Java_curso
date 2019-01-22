package ManejoColecciones;
import java.util.*;

public class ManejoColecciones_M {
    public static void main(String[] args) {
        List milista = new ArrayList();
        milista.add("1");
        milista.add("2");
        milista.add("3");
        milista.add("4");
        //Elemento Repetido
        milista.add("4");
        imprimir(milista);

        Set miSet = new HashSet();
        miSet.add("100");
        miSet.add("200");
        miSet.add("300");
        miSet.add("400");
        //Elemento Repetido
        miSet.add("400");
        imprimir(miSet);

        Map miMapa = new HashMap();
        miMapa.put("1","1000");
        miMapa.put("2","2000");
        miMapa.put("3","3000");
        miMapa.put("4","4000");
        miMapa.put("4","5000");
        //Se imprimen todas las llaves
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());
    }
    private static void imprimir(Collection collection){
        for (Object elemento:collection) {
            System.out.print(elemento + " ");
        }
        System.out.println("");
    }
}
