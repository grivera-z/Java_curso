package ManejoColeccionesGenericas;
import java.util.*;

public class ManejoColeccionesGenericas_M {
    public static void main(String[] args) {
        List<String> miLista = new ArrayList<String>();
        miLista.add("1");
        miLista.add("2");
        miLista.add("3");
        miLista.add("4");
        miLista.add("4");
        imprimir(miLista);

        Set<String> miSet = new HashSet<>();
        miSet.add("100");
        miSet.add("200");
        miSet.add("300");
        miSet.add("400");
        imprimir(miSet);

        Map<String,String> miMapa = new HashMap<>();
        miMapa.put("1","Pepe");
        miMapa.put("2","jose");
        miMapa.put("3","Juan");
        miMapa.put("4","Saturno");
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());

    }
    private static void imprimir(Collection<String> col){
        for (String elemento:col) {
            System.out.print(elemento + " ");
        }
        System.out.println("");
    }
}
