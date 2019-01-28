package Manejo_Capa_De_Datos_DTO.Usuarios.jdbc;

import Manejo_Capa_De_Datos_DTO.Usuarios.dto.UsuarioDTO;

import java.util.List;
import java.sql.SQLException;

public interface UsuarioDao {
    public int insert(UsuarioDTO usuario) throws SQLException;
    public int update(UsuarioDTO usuario) throws SQLException;
    public int delete(UsuarioDTO usuario) throws SQLException;
    public List<UsuarioDTO> select() throws SQLException;


}
