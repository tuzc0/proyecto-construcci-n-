package accesoadatos;

import logica.actividadesDTO.ActividadDTO;
import logica.interfaces.IActividadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActividadDAO implements IActividadDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaActividad = null;
    ResultSet resultadoConsultaActividad;

    public boolean crearNuevaActividad(ActividadDTO actividad) throws SQLException {
        boolean actividadInsertada = false;

        String insertarSQLActividad = "INSERT INTO actividad VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            sentenciaActividad = conexionBaseDeDatos.prepareStatement(insertarSQLActividad);
            sentenciaActividad.setInt(1, actividad.getIDActividad());
            sentenciaActividad.setString(2, actividad.getNombre());
            sentenciaActividad.setString(3, actividad.getDuracion());
            sentenciaActividad.setString(4, actividad.getHitos());
            sentenciaActividad.setTimestamp(5, actividad.getFechaInicio());
            sentenciaActividad.setTimestamp(6, actividad.getFechaFin());
            sentenciaActividad.setInt(7, 1);
            sentenciaActividad.executeUpdate();
            actividadInsertada = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar la actividad: " + e.getMessage());
        }

        return actividadInsertada;
    }

    public boolean eliminarActividadPorID(int idActividad) throws SQLException {
        boolean actividadEliminada = false;

        String eliminarSQLActividad = "UPDATE actividad SET estadoActivo = 0 WHERE IDActividad = ?";

        try {
            sentenciaActividad = conexionBaseDeDatos.prepareStatement(eliminarSQLActividad);
            sentenciaActividad.setInt(1, idActividad);
            sentenciaActividad.executeUpdate();
            actividadEliminada = true;

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar la actividad: " + e.getMessage());
        }

        return actividadEliminada;
    }

    public boolean modificarActividad(ActividadDTO actividad) throws SQLException {
        boolean actividadModificada = false;

        String modificarSQLActividad = "UPDATE actividad SET nombre = ?, duracion = ?, hitos = ?, fechaInicio = ?, fechaFin = ? , estadoActivo = ? WHERE IDActividad = ?";

        try {
            sentenciaActividad = conexionBaseDeDatos.prepareStatement(modificarSQLActividad);
            sentenciaActividad.setString(1, actividad.getNombre());
            sentenciaActividad.setString(2, actividad.getDuracion());
            sentenciaActividad.setString(3, actividad.getHitos());
            sentenciaActividad.setTimestamp(4, actividad.getFechaInicio());
            sentenciaActividad.setTimestamp(5, actividad.getFechaFin());
            sentenciaActividad.setInt(6, actividad.getIDActividad());
            sentenciaActividad.setInt(7, actividad.getEstadoActivo());
            sentenciaActividad.executeUpdate();
            actividadModificada = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar la actividad: " + e.getMessage());
        }

        return actividadModificada;
    }

    public ActividadDTO buscarActividadPorID(int idActividad) throws SQLException {
        ActividadDTO actividad = null;

        String buscarSQLActividad = "SELECT * FROM actividad WHERE IDActividad = ?";

        try {
            sentenciaActividad = conexionBaseDeDatos.prepareStatement(buscarSQLActividad);
            sentenciaActividad.setInt(1, idActividad);
            resultadoConsultaActividad = sentenciaActividad.executeQuery();

            if (resultadoConsultaActividad.next()) {
                actividad = new ActividadDTO();
                actividad.setIDActividad(resultadoConsultaActividad.getInt("IdActividad"));
                actividad.setNombre(resultadoConsultaActividad.getString("nombre"));
                actividad.setDuracion(resultadoConsultaActividad.getString("duracion"));
                actividad.setHitos(resultadoConsultaActividad.getString("hitos"));
                actividad.setFechaInicio(resultadoConsultaActividad.getTimestamp("fechaInicio"));
                actividad.setFechaFin(resultadoConsultaActividad.getTimestamp("fechaFin"));
                actividad.setEstadoActivo(resultadoConsultaActividad.getInt("estadoActivo"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar la actividad: " + e.getMessage());
        }

        return actividad;
    }



}
