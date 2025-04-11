package logica.interfaces;

import java.sql.SQLException;

public interface ICriterioAutoevaluacionDTO {

    boolean crearNuevoCriterioAutoevaluacion(ICriterioAutoevaluacionDTO criterio) throws SQLException;

    boolean eliminarCriterioAutoevaluacionPorNumeroDeCriterio(int numeroDeCriterio) throws SQLException;

    boolean modificarCriterioAutoevaluacion(ICriterioAutoevaluacionDTO criterio) throws SQLException;

    ICriterioAutoevaluacionDTO buscarCriterioAutoevaluacionPorID(int numeroDeCriterio) throws SQLException;
}
