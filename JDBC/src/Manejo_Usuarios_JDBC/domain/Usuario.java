package Manejo_Usuarios_JDBC.domain;

public class Usuario {
    private int id_usuario;
    private String usuario;
    private String passworc;


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassworc() {
        return passworc;
    }

    public void setPassworc(String passworc) {
        this.passworc = passworc;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", usuario='" + usuario + '\'' +
                ", passworc='" + passworc + '\'' +
                '}';
    }
}
