package logica.interfaces;

import java.sql.SQLException;
import logica.evaluacionesDTO.EvaluacionDTO;

public interface IEvaluacionDAO {

    boolean crearNuevaEvaluacion(EvaluacionDTO evaluacion) throws SQLException;

    boolean eliminarEvaluacionPorID(int idEvaluacion) throws SQLException;

    boolean modificarEvaluacion(EvaluacionDTO evaluacion) throws SQLException;

    EvaluacionDTO buscarEvaluacionPorID(int idEvaluacion) throws SQLException;
}
