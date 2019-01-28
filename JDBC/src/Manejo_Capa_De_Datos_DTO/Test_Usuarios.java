package Manejo_Capa_De_Datos_DTO;

import Manejo_Capa_De_Datos_DTO.Usuarios.dto.UsuarioDTO;
import Manejo_Capa_De_Datos_DTO.Usuarios.jdbc.UsuarioDao;
import Manejo_Capa_De_Datos_DTO.Usuarios.jdbc.UsuarioDaoJDBC;

import java.sql.SQLException;
import java.util.List;

public class Test_Usuarios {
    public static void main(String[] args) {
        /*Utilizamos el tipo interface como referencia
         * a una clase concreta*/
        UsuarioDao usuriDao = new UsuarioDaoJDBC();
        /*
         * Creamos nuevo registro
         * Hacemos uso de la clase persona DTO la cual se usa para transferir la inofrmacion entre las capas
         * No es necesario especificar la llave primaria ya que en este caso es de tipo autonumerico y la BD se encarga de asignarle un nuevo valor ;)
         * */
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsuario("Ninis");
        usuario.setPassword("1234");
        usuario.setId_usuario(9);
        //Utilizamos la capa DAO para persistir el Ojbeto DTO
        try{
           // usuriDao.insert(usuario);
            //usuriDao.update(persona);
            //usuriDao.delete(new PersonaDTO(4));

            List<UsuarioDTO> usuaios = usuriDao.select();
            for (UsuarioDTO element:usuaios) {
                System.out.println(element);
            }

        }catch (SQLException sqle){
            System.out.println("Excepcion en la capa de prueba");
            sqle.printStackTrace();
        }
    }
}
