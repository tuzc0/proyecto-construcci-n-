package accesoadatos;

import logica.evaluacionesDTO.CriterioAutoevaluacionDTO;
import logica.interfaces.ICriterioAutoevaluacionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriterioAutoevaluacionDAO implements ICriterioAutoevaluacionDTO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaCriterio = null;
    ResultSet resultadoConsultaCriterio;


    public boolean crearNuevoCriterioAutoevaluacion(CriterioAutoevaluacionDTO criterio) throws SQLException {

        String insertarSQLCriterio = "INSERT INTO criterioautoevaluacion (idCriterio, descripciones, numeroCriterio) VALUES (?, ?, ?)";
        boolean criterioInsertado = false;

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(insertarSQLCriterio);
            sentenciaCriterio.setInt(1, criterio.getIDCriterio());
            sentenciaCriterio.setString(2, criterio.getDescripcion());
            sentenciaCriterio.setInt(3, criterio.getNumeroCriterio());
            sentenciaCriterio.executeUpdate();
            criterioInsertado = true;

        } finally {

            if (sentenciaCriterio != null) {

                sentenciaCriterio.close();
            }
        }

        return criterioInsertado;
    }

    public boolean eliminarCriterioAutoevaluacionPorNumeroDeCriterio(int numeroDeCriterio) throws SQLException {

        String eliminarSQLCriterio = "UPDATE criterioautoevaluacion SET estadoActivo = ? WHERE numeroCriterio = ?";
        boolean criterioEliminado = false;

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(eliminarSQLCriterio);
            sentenciaCriterio.setInt(1, 0);
            sentenciaCriterio.setInt(2, numeroDeCriterio);
            sentenciaCriterio.executeUpdate();
            criterioEliminado = true;

        } finally {

            if (sentenciaCriterio != null) {

                sentenciaCriterio.close();
            }
        }

        return criterioEliminado;
    }

    public boolean modificarCriterioAutoevaluacion(CriterioAutoevaluacionDTO criterio) throws SQLException {

        String modificarSQLCriterio = "UPDATE criterioautoevaluacion SET descripciones = ? WHERE numeroCriterio = ?";
        boolean criterioModificado = false;

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(modificarSQLCriterio);
            sentenciaCriterio.setString(1, criterio.getDescripcion());
            sentenciaCriterio.setInt(2, criterio.getNumeroCriterio());
            sentenciaCriterio.executeUpdate();
            criterioModificado = true;

        } finally {

            if (sentenciaCriterio != null) {

                sentenciaCriterio.close();
            }
        }

        return criterioModificado;
    }

    public CriterioAutoevaluacionDTO buscarCriterioAutoevaluacionPorID(int numeroDeCriterio) throws SQLException {

        String buscarSQLCriterio = "SELECT * FROM criterioautoevaluacion WHERE numeroCriterio = ?";
        CriterioAutoevaluacionDTO criterioEncontrado = new CriterioAutoevaluacionDTO(-1, "N/A", -1);

        try {
            sentenciaCriterio = conexionBaseDeDatos.prepareStatement(buscarSQLCriterio);
            sentenciaCriterio.setInt(1, numeroDeCriterio);
            resultadoConsultaCriterio = sentenciaCriterio.executeQuery();

            if (resultadoConsultaCriterio.next()) {

                int idCriterio = resultadoConsultaCriterio.getInt("idCriterio");
                String descripciones = resultadoConsultaCriterio.getString("descripciones");
                int numeroCriterio = resultadoConsultaCriterio.getInt("numeroCriterio");
                criterioEncontrado = new CriterioAutoevaluacionDTO(idCriterio, descripciones, numeroCriterio);
            }

        } finally {

            if (sentenciaCriterio != null) {

                sentenciaCriterio.close();
            }
        }

        return criterioEncontrado;
    }
}
