package accesoadatos;

import logica.interfaces.IOvDAO;
import logica.ovsDTO.OvDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OvDAO implements IOvDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaOV = null;
    ResultSet resultadoConsultaOV;

    public boolean crearNuevaOv(OvDTO ov) throws SQLException {

        boolean ovCreada = false;

        String insertarSQLOV = "INSERT INTO ov VALUES(?, ?, ?, ?, ?, ?)";

        try {

            sentenciaOV = conexionBaseDeDatos.prepareStatement(insertarSQLOV);
            sentenciaOV.setInt(1, ov.getIdOV());
            sentenciaOV.setString(2, ov.getNombre());
            sentenciaOV.setString(3, ov.getCorreo());
            sentenciaOV.setString(4, ov.getNumeroDeContacto());
            sentenciaOV.setString(5, ov.getDireccion());
            sentenciaOV.setInt(6, ov.getEstadoActivo());
            sentenciaOV.executeUpdate();

            ovCreada = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar", e);
        }

        return ovCreada;
    }

    public boolean eliminarOvPorID(int idOv) throws SQLException {

        boolean ovEliminada = false;

        String eliminarSQLOV = "UPDATE ov SET estadoActivo = 0 WHERE idOV = ?";

        try {

            sentenciaOV = conexionBaseDeDatos.prepareStatement(eliminarSQLOV);
            sentenciaOV.setInt(1, idOv);
            sentenciaOV.executeUpdate();

            ovEliminada = true;

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar la OV: " + e.getMessage());
        }

        return ovEliminada;
    }

    public boolean modificarOv(OvDTO ov) throws SQLException {

        boolean ovModificada = false;

        String modificarSQLOV = "UPDATE ov SET nombre = ?, correo = ?, numeroContacto = ?, direccion = ? WHERE idOV = ?";

        try {

            sentenciaOV = conexionBaseDeDatos.prepareStatement(modificarSQLOV);
            sentenciaOV.setString(1, ov.getNombre());
            sentenciaOV.setString(2, ov.getCorreo());
            sentenciaOV.setString(3, ov.getNumeroDeContacto());
            sentenciaOV.setString(4, ov.getDireccion());
            sentenciaOV.setInt(5, ov.getIdOV());
            sentenciaOV.executeUpdate();

            ovModificada = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar la OV: " + e.getMessage());
        }

        return ovModificada;
    }

    public OvDTO buscarOvPorID(int idOv) throws SQLException {

        OvDTO ov = new OvDTO(-1, "N/A", "N/A", "N/A", "N/A", 0);

        String buscarSQLOV = "SELECT * FROM ov WHERE idOV = ?";

        try {

            sentenciaOV = conexionBaseDeDatos.prepareStatement(buscarSQLOV);
            sentenciaOV.setInt(1, idOv);
            resultadoConsultaOV = sentenciaOV.executeQuery();

            if (resultadoConsultaOV.next()) {
                ov.setIdOV(resultadoConsultaOV.getInt("idOV"));
                ov.setNombre(resultadoConsultaOV.getString("nombre"));
                ov.setCorreo(resultadoConsultaOV.getString("correo"));
                ov.setNumeroDeContacto(resultadoConsultaOV.getString("numeroContacto"));
                ov.setDireccion(resultadoConsultaOV.getString("direccion"));
                ov.setEstadoActivo(resultadoConsultaOV.getInt("estadoActivo"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar la OV: " + e.getMessage());
        }

        return ov;
    }




}
