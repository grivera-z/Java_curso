package Manejo_Capa_De_Datos_DTO.Personas.jdbc;

import  java.sql.SQLException;
import java.util.List;
import Manejo_Capa_De_Datos_DTO.Personas.dto.PersonaDTO;
/**
 * Esta interfaz contiene los métodos abstractos con las
 * operaciones básicas sobre la tabla de Persona
 * CRUD (Create, Read, Update y Delete)
 * Se debe crear una clase concreta para implementar el
 * código asociado a cada método
 * @author Ubaldo
 *
 */

public interface PersonaDao {
    public int insert(PersonaDTO persona) throws SQLException;
    public int update(PersonaDTO persona) throws SQLException;
    public int delete(PersonaDTO persona) throws SQLException;
    public List<PersonaDTO> select() throws SQLException;
    }
