package accesoadatos;

import logica.experienciaseducativasDTO.PeriodoDTO;
import logica.interfaces.IPeriodoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodoDAO implements IPeriodoDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaPeriodo = null;
    ResultSet resultadoConsultaPeriodo;

    public boolean crearNuevoPeriodo(PeriodoDTO periodo) throws SQLException {
        boolean periodoInsertado = false;

        String insertarSQLPeriodo = "INSERT INTO periodo VALUES(?, ?, ?)";

        try {
            sentenciaPeriodo = conexionBaseDeDatos.prepareStatement(insertarSQLPeriodo);
            sentenciaPeriodo.setInt(1, periodo.getIDPeriodo());
            sentenciaPeriodo.setString(2, periodo.getDescripcion());
            sentenciaPeriodo.setInt(3, periodo.getEstadoActivo());
            sentenciaPeriodo.executeUpdate();
            periodoInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el periodo: " + e.getMessage());
        }

        return periodoInsertado;
    }

    public boolean eliminarPeriodoPorID(int idPeriodo) throws SQLException {
        boolean periodoEliminado = false;

        String eliminarSQLPeriodo = "UPDATE periodo SET estadoActivo = 0 WHERE idPeriodo = ?";

        try {
            sentenciaPeriodo = conexionBaseDeDatos.prepareStatement(eliminarSQLPeriodo);
            sentenciaPeriodo.setInt(1, idPeriodo);
            sentenciaPeriodo.executeUpdate();
            periodoEliminado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el periodo: " + e.getMessage());
        }

        return periodoEliminado;
    }

    public boolean modificarPeriodo(PeriodoDTO periodo) throws SQLException {
        boolean periodoModificado = false;

        String modificarSQLPeriodo = "UPDATE periodo SET descripcion = ?, estadoActivo = ? WHERE idPeriodo = ?";

        try {
            sentenciaPeriodo = conexionBaseDeDatos.prepareStatement(modificarSQLPeriodo);
            sentenciaPeriodo.setInt(3, periodo.getIDPeriodo());
            sentenciaPeriodo.setString(1, periodo.getDescripcion());
            sentenciaPeriodo.setInt(2, periodo.getEstadoActivo());

            sentenciaPeriodo.executeUpdate();
            periodoModificado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el periodo: " + e.getMessage());
        }

        return periodoModificado;
    }

    public PeriodoDTO mostrarPeriodoActual ( ) throws SQLException {
        PeriodoDTO periodo = new PeriodoDTO(-1, "N/A", -1);

        String consultaSQLPeriodo = "SELECT * FROM periodo WHERE estadoActivo = 1";
        try {
            sentenciaPeriodo = conexionBaseDeDatos.prepareStatement(consultaSQLPeriodo);
            resultadoConsultaPeriodo = sentenciaPeriodo.executeQuery( );

            if (resultadoConsultaPeriodo.next( )) {
                periodo.setIDPeriodo(resultadoConsultaPeriodo.getInt("idPeriodo"));
                periodo.setDescripcion(resultadoConsultaPeriodo.getString("descripcion"));
                periodo.setEstadoActivo(resultadoConsultaPeriodo.getInt("estadoActivo"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al mostrar el periodo: " + e.getMessage());
        }

        return periodo;
    }

}
