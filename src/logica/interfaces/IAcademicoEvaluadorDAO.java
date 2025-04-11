package logica.interfaces;

import logica.usuariosDTO.AcademicoEvaluadorDTO;
import logica.usuariosDTO.EstudianteDTO;

import java.sql.SQLException;

public interface IAcademicoEvaluadorDAO {

    boolean insertarAcademicoEvaluador(AcademicoEvaluadorDTO academicoEvaluador) throws Exception;

    boolean eliminarAcademicoEvaluadorPorNumeroDePersonal(String numeroDePersonal) throws Exception;

    boolean modificarAcademicoEvaluador(AcademicoEvaluadorDTO academicoEvaluador) throws Exception;

    EstudianteDTO buscarAcademicoEvaluadorPorNumeroDePersonal(int numeroDePersonal) throws SQLException;
}
