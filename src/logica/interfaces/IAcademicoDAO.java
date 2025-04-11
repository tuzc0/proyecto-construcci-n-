package logica.interfaces;

import logica.usuariosDTO.AcademicoDTO;
import java.sql.SQLException;

public interface IAcademicoDAO {

    boolean insertarAcademico(AcademicoDTO academico) throws SQLException;

    boolean eliminarAcademicoPorNumeroDePersonal(String numeroDePersonal) throws SQLException;

    boolean modificarAcademico(AcademicoDTO academico) throws SQLException;

    AcademicoDTO buscarAcademicoPorNumeroDePersonal(int numeroDePersonal) throws SQLException;
}
