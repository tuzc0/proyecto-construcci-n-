package accesoadatos;

import logica.interfaces.IReporteDAO;
import logica.proyectosDTO.ReporteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteDAO implements IReporteDAO {
    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaReporte = null;
    ResultSet resultadoReporte;

    public boolean insertarReporte(ReporteDTO reporte) throws SQLException {
        String insertarSQLReporte = "INSERT INTO reporte VALUES (?, ?, ?, ?, ?, ?)";
        boolean reporteInsertado = false;

        try {
            sentenciaReporte = conexionBaseDeDatos.prepareStatement(insertarSQLReporte);
            sentenciaReporte.setInt(1, reporte.getIDReporte());
            sentenciaReporte.setInt(2, reporte.getNumeroHoras());
            sentenciaReporte.setString(3, reporte.getMetodologia());
            sentenciaReporte.setString(4, reporte.getObservaciones());
            sentenciaReporte.setTimestamp(5, reporte.getFecha());
            sentenciaReporte.setString(6, reporte.getMatricula());
            sentenciaReporte.executeUpdate();
            reporteInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el reporte: " + e.getMessage());
        }

        return reporteInsertado;
    }

    public boolean modificarReporte(ReporteDTO reporte) throws SQLException {
        String modificarSQLReporte = "UPDATE reporte SET numeroHoras = ?, metodologia = ?, observaciones = ?, fecha = ?, IDEstudiante = ? WHERE IDReporte = ?";
        boolean reporteModificado = false;

        try {
            sentenciaReporte = conexionBaseDeDatos.prepareStatement(modificarSQLReporte);
            sentenciaReporte.setInt(1, reporte.getNumeroHoras());
            sentenciaReporte.setString(2, reporte.getMetodologia());
            sentenciaReporte.setString(3, reporte.getObservaciones());
            sentenciaReporte.setTimestamp(4, reporte.getFecha());
            sentenciaReporte.setString(5, reporte.getMatricula());
            sentenciaReporte.setInt(6, reporte.getIDReporte());
            sentenciaReporte.executeUpdate();
            reporteModificado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el reporte: " + e.getMessage());
        }

        return reporteModificado;
    }

    public ReporteDTO buscarReportePorID(int idReporte) throws SQLException {
        String buscarSQLReporte = "SELECT * FROM reporte WHERE IDReporte = ?";
        ReporteDTO reporteEncontrado = new ReporteDTO( -1, -1, "", "", null, "");

        try {
            sentenciaReporte = conexionBaseDeDatos.prepareStatement(buscarSQLReporte);
            sentenciaReporte.setInt(1, idReporte);
            resultadoReporte = sentenciaReporte.executeQuery();

            if (resultadoReporte.next()) {
                reporteEncontrado = new ReporteDTO();
                reporteEncontrado.setIDReporte(resultadoReporte.getInt("IdReporte"));
                reporteEncontrado.setNumeroHoras(resultadoReporte.getInt("numeroHoras"));
                reporteEncontrado.setMetodologia(resultadoReporte.getString("metodologia"));
                reporteEncontrado.setObservaciones(resultadoReporte.getString("observaciones"));
                reporteEncontrado.setFecha(resultadoReporte.getTimestamp("fecha"));
                reporteEncontrado.setMatricula(resultadoReporte.getString("IdEstudiante"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar el reporte: " + e.getMessage());
        }

        return reporteEncontrado;
    }


}
