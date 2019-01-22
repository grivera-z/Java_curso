package ManejoExcepciones_1;

public class ManejoExcepciones_M {
    public static void main(String[] args) {
        try {
            Division d1 = new Division(2, 0);
            d1.visualizarOperacion();
        }catch (OperationException ex){
            System.out.println(ex);
            ex.printStackTrace();
        }

    }
}
