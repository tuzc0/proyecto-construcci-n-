package accesoadatos;

import logica.evaluacionesDTO.CriterioEvaluacionDTO;
import logica.interfaces.ICriterioEvaluacionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriterioEvaluacionDAO implements ICriterioEvaluacionDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaCriterio = null;
    ResultSet resultadoConsultaCriterio;

    public boolean crearNuevoCriterioEvaluacion(CriterioEvaluacionDTO criterio) throws SQLException {

        String insertarSQLCriterio = "INSERT INTO criterioevaluacion (descripcion, numeroCriterio) VALUES (?, ?)";
        boolean criterioInsertado = false;

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(insertarSQLCriterio);
            sentenciaCriterio.setString(1, criterio.getDescripcion());
            sentenciaCriterio.setInt(2, criterio.getNumeroCriterio());
            sentenciaCriterio.executeUpdate();
            criterioInsertado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al insertar el criterio de evaluación: " + e.getMessage());
        }

        return criterioInsertado;
    }

    public boolean eliminarCriterioEvaluacionPorID(int idCriterio) throws SQLException {

        String eliminarSQLCriterio = "UPDATE criterioevaluacion SET estadoActivo = ? WHERE numeroCriterio = ?";
        boolean criterioEliminado = false;

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(eliminarSQLCriterio);
            sentenciaCriterio.setInt(1, 0);
            sentenciaCriterio.setInt(2, idCriterio);
            sentenciaCriterio.executeUpdate();
            criterioEliminado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al eliminar el criterio de evaluación: " + e.getMessage());
        }

        return criterioEliminado;
    }

    public boolean modificarCriterioEvaluacion(CriterioEvaluacionDTO criterio) throws SQLException {

        String modificarSQLCriterio = "UPDATE criterioevaluacion SET descripcion = ? WHERE numeroCriterio = ?";
        boolean criterioModificado = false;

        try {

            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(modificarSQLCriterio);
            sentenciaCriterio.setString(1, criterio.getDescripcion());
            sentenciaCriterio.setInt(2, criterio.getNumeroCriterio());
            sentenciaCriterio.executeUpdate();
            criterioModificado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar el criterio de evaluación: " + e.getMessage());
        }

        return criterioModificado;
    }

    public CriterioEvaluacionDTO buscarCriterioEvaluacionPorID(int numeroCriterio) throws SQLException {

        String buscarSQLCriterio = "SELECT * FROM criterioevaluacion WHERE numeroCriterio = ?";
        CriterioEvaluacionDTO criterioEncontrado = new CriterioEvaluacionDTO(-1, "N/A", -1);

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(buscarSQLCriterio);
            sentenciaCriterio.setInt(1, numeroCriterio);
            resultadoConsultaCriterio = sentenciaCriterio.executeQuery();

            if (resultadoConsultaCriterio.next()) {

                int identificadorCriterio = resultadoConsultaCriterio.getInt("idCriterio");
                String descripciones = resultadoConsultaCriterio.getString("descripcion");
                int numeroDeCriterio = resultadoConsultaCriterio.getInt("numeroCriterio");
                criterioEncontrado = new CriterioEvaluacionDTO(identificadorCriterio, descripciones, numeroDeCriterio);
            }

        } catch (SQLException e) {

            throw new SQLException("Error al buscar el criterio de evaluación: " + e.getMessage());
        }

        return criterioEncontrado;
    }

}
