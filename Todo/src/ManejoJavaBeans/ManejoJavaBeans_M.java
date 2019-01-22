package ManejoJavaBeans;

public class ManejoJavaBeans_M {
    public static void main(String[] args) {
        PersonaBean bean = new PersonaBean();
        bean.setNombre("Jose");
        bean.setEdad(29);
        System.out.println("bean.getNombre() = " + bean.getNombre());
        System.out.println("bean.getEdad() = " + bean.getEdad());


    }
}
