package logica.interfaces;

import logica.evaluacionesDTO.CriterioAutoevaluacionDTO;
import java.sql.SQLException;

public interface ICriterioAutoevaluacionDTO {

    boolean crearNuevoCriterioAutoevaluacion(CriterioAutoevaluacionDTO criterio) throws SQLException;

    boolean eliminarCriterioAutoevaluacionPorNumeroDeCriterio(int numeroDeCriterio) throws SQLException;

    boolean modificarCriterioAutoevaluacion(CriterioAutoevaluacionDTO criterio) throws SQLException;

    CriterioAutoevaluacionDTO buscarCriterioAutoevaluacionPorID(int numeroDeCriterio) throws SQLException;
}
