package accesoadatos;

import logica.interfaces.IProyectoDAO;
import logica.proyectosDTO.ProyectoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectoDAO implements IProyectoDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaProyecto = null;
    ResultSet resultadoProyecto;

    public boolean crearNuevoProyecto(ProyectoDTO proyecto) throws SQLException {

        String insertarSQLProyecto = "INSERT INTO proyecto VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        boolean proyectoInsertado = false;

        try {
            sentenciaProyecto = conexionBaseDeDatos.prepareStatement(insertarSQLProyecto);
            sentenciaProyecto.setInt(1, proyecto.getIDProyecto());
            sentenciaProyecto.setString(2, proyecto.getNombre());
            sentenciaProyecto.setString(3, proyecto.getDescripcion());
            sentenciaProyecto.setDate(4, java.sql.Date.valueOf(proyecto.getFechaInicio()));
            sentenciaProyecto.setDate(5, java.sql.Date.valueOf(proyecto.getFechaFin()));
            sentenciaProyecto.setInt(6, proyecto.getIDRepresentante());
            sentenciaProyecto.setString(7, proyecto.getMatricula());
            sentenciaProyecto.setInt(8, proyecto.getEstadoActivo());

            sentenciaProyecto.executeUpdate();
            proyectoInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el proyecto: " + e.getMessage());
        }

        return proyectoInsertado;
    }

    public boolean eliminarProyectoPorID(int idProyecto) throws SQLException {

        String modificarSQLProyecto = "UPDATE proyecto SET estadoActivo = ? WHERE IDProyecto = ?";
        boolean proyectoEliminado = false;

        try {
            sentenciaProyecto = conexionBaseDeDatos.prepareStatement(modificarSQLProyecto);
            sentenciaProyecto.setInt(1, 0);
            sentenciaProyecto.setInt(2, idProyecto);
            sentenciaProyecto.executeUpdate();
            proyectoEliminado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el proyecto: " + e.getMessage());
        }

        return proyectoEliminado;
    }

    public boolean modificarProyecto(ProyectoDTO proyecto) throws SQLException {

        String modificarSQLProyecto = "UPDATE proyecto SET nombre = ?, descripcion = ?, fechaInicio = ?, fechaFin = ?, IDRepresentante = ?, IDEstudiante = ? WHERE IDProyecto = ?";
        boolean proyectoModificado = false;

        try {
            sentenciaProyecto = conexionBaseDeDatos.prepareStatement(modificarSQLProyecto);
            sentenciaProyecto.setString(1, proyecto.getNombre());
            sentenciaProyecto.setString(2, proyecto.getDescripcion());
            sentenciaProyecto.setDate(3, java.sql.Date.valueOf(proyecto.getFechaInicio()));
            sentenciaProyecto.setDate(4, java.sql.Date.valueOf(proyecto.getFechaFin()));
            sentenciaProyecto.setInt(5, proyecto.getIDRepresentante());
            sentenciaProyecto.setString(6, proyecto.getMatricula());
            sentenciaProyecto.setInt(7, proyecto.getIDProyecto());

            sentenciaProyecto.executeUpdate();
            proyectoModificado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el proyecto: " + e.getMessage());
        }

        return proyectoModificado;
    }

    public ProyectoDTO buscarProyectoPorID(int idProyecto) throws SQLException {

        String consultaSQLProyecto = "SELECT * FROM proyecto WHERE IDProyecto = ?";
        ProyectoDTO proyecto = new ProyectoDTO(-1, "", "", "", "", -1, "", 0);

        try {
            sentenciaProyecto = conexionBaseDeDatos.prepareStatement(consultaSQLProyecto);
            sentenciaProyecto.setInt(1, idProyecto);
            resultadoProyecto = sentenciaProyecto.executeQuery();

            if (resultadoProyecto.next()) {
                proyecto.setIDProyecto(resultadoProyecto.getInt("IDProyecto"));
                proyecto.setNombre(resultadoProyecto.getString("nombre"));
                proyecto.setDescripcion(resultadoProyecto.getString("descripcion"));
                proyecto.setFechaInicio(resultadoProyecto.getString("fechaInicio"));
                proyecto.setFechaFin(resultadoProyecto.getString("fechaFin"));
                proyecto.setIDRepresentante(resultadoProyecto.getInt("IDRepresentante"));
                proyecto.setMatricula(resultadoProyecto.getString("IDEstudiante"));
                proyecto.setEstadoActivo(resultadoProyecto.getInt("estadoActivo"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar el proyecto: " + e.getMessage());
        }

        return proyecto;
    }
}
