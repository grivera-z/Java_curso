package Manejo_Capa_De_Datos_DTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Manejo_Capa_De_Datos_DTO.Personas.dto.PersonaDTO;
import Manejo_Capa_De_Datos_DTO.Personas.jdbc.PersonaDao;
import Manejo_Capa_De_Datos_DTO.Personas.jdbc.PersonasDaoJDBC;

public class Test_Personas {
    public static void main(String[] args) {
        /*Utilizamos el tipo interface como referencia
        * a una clase concreta*/
        PersonaDao personaDao = new PersonasDaoJDBC();
        /*
        * Creamos nuevo registro
        * Hacemos uso de la clase persona DTO la cual se usa para transferir la inofrmacion entre las capas
        * No es necesario especificar la llave primaria ya que en este caso es de tipo autonumerico y la BD se encarga de asignarle un nuevo valor ;)
        * */
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Mario");
        persona.setApellido("Lopez01");
        persona.setId_persona(8);
        //Utilizamos la capa DAO para persistir el Ojbeto DTO
        try{
            //personaDao.insert(persona);
            //personaDao.update(persona);
            //personaDao.delete(new PersonaDTO(4));
            List<PersonaDTO> personas = personaDao.select();
            for (PersonaDTO element:personas) {
                System.out.println(element);
            }
        }catch (SQLException sqle){
            System.out.println("Excepcion en la capa de prueba");
            sqle.printStackTrace();
        }
    }
}
