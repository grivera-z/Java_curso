package ManejoExcepciones_1;

public class ManejoExcepcionesArg_M {
    public static void main(String[] args) throws OperationException {
        try{
            int op1 = Integer.parseInt(args[0]);
            int op2 = Integer.parseInt(args[1]);
            Division div = new Division(op1,op2);
            div.visualizarOperacion();
        }catch (ArrayIndexOutOfBoundsException aie){
            System.out.println("Ocurrio una Excepcion: ");
            aie.printStackTrace();
        }catch(NumberFormatException nfe){
            System.out.println("Ocurrio una Excepcion: ");
            nfe.printStackTrace();
        }finally {
            System.out.println("Se terminaron de revisar las Excepciones: ");
        }
    }
}
