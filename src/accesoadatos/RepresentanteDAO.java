package accesoadatos;

import logica.interfaces.IRepresentanteDAO;
import logica.ovsDTO.RepresentanteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepresentanteDAO implements IRepresentanteDAO {
    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaRepresentante = null;
    ResultSet resultadoConsultaRepresentante;

    public boolean insertarRepresentante(RepresentanteDTO representante) throws SQLException {
        boolean representanteInsertado = false;

        String insertarSQLRepresentante = "INSERT INTO representante VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            sentenciaRepresentante = conexionBaseDeDatos.prepareStatement(insertarSQLRepresentante);
            sentenciaRepresentante.setInt(1, representante.getIDRepresentante());
            sentenciaRepresentante.setString(2, representante.getCorreo());
            sentenciaRepresentante.setString(3, representante.getTelefono());
            sentenciaRepresentante.setString(4, representante.getNombre());
            sentenciaRepresentante.setString(5, representante.getApellidos());
            sentenciaRepresentante.setInt(6, representante.getIdOV());
            sentenciaRepresentante.setInt(7, representante.getEstadoActivo());
            sentenciaRepresentante.executeUpdate();
            representanteInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar", e);
        }

        return representanteInsertado;
    }

    public boolean eliminarRepresentantePorID(int idRepresentante) throws SQLException {
        boolean representanteEliminado = false;

        String eliminarSQLRepresentante = "UPDATE representante SET estadoActivo = 0 WHERE IdRepresentante = ?";

        try {
            sentenciaRepresentante = conexionBaseDeDatos.prepareStatement(eliminarSQLRepresentante);
            sentenciaRepresentante.setInt(1, idRepresentante);
            sentenciaRepresentante.executeUpdate();
            representanteEliminado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el representante: " + e.getMessage());
        }

        return representanteEliminado;
    }

    public boolean modificarRepresentante(RepresentanteDTO representante) throws SQLException {
        boolean representanteModificado = false;

        String modificarSQLRepresentante = "UPDATE representante SET correo = ?, telefono = ?, nombre = ?, apellidos = ?, idOV = ?, estadoActivo = ? WHERE IdRepresentante = ?";

        try {
            sentenciaRepresentante = conexionBaseDeDatos.prepareStatement(modificarSQLRepresentante);
            sentenciaRepresentante.setString(1, representante.getCorreo());
            sentenciaRepresentante.setString(2, representante.getTelefono());
            sentenciaRepresentante.setString(3, representante.getNombre());
            sentenciaRepresentante.setString(4, representante.getApellidos());
            sentenciaRepresentante.setInt(5, representante.getIdOV());
            sentenciaRepresentante.setInt(6, representante.getEstadoActivo());
            sentenciaRepresentante.setInt(7, representante.getIDRepresentante());
            sentenciaRepresentante.executeUpdate();
            representanteModificado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el representante: " + e.getMessage());
        }

        return representanteModificado;
    }

    public RepresentanteDTO buscarRepresentantePorID(int idRepresentante) throws SQLException {
        RepresentanteDTO representante = new RepresentanteDTO(-1, "N/A", "N/A", "N/A", "N/A", 0, 0);

        String buscarSQLRepresentante = "SELECT * FROM representante WHERE IdRepresentante = ?";

        try {
            sentenciaRepresentante = conexionBaseDeDatos.prepareStatement(buscarSQLRepresentante);
            sentenciaRepresentante.setInt(1, idRepresentante);
            resultadoConsultaRepresentante = sentenciaRepresentante.executeQuery();

            if (resultadoConsultaRepresentante.next()) {
                representante = new RepresentanteDTO(
                        resultadoConsultaRepresentante.getInt("idRepresentante"),
                        resultadoConsultaRepresentante.getString("correo"),
                        resultadoConsultaRepresentante.getString("telefono"),
                        resultadoConsultaRepresentante.getString("nombre"),
                        resultadoConsultaRepresentante.getString("apellidos"),
                        resultadoConsultaRepresentante.getInt("idOV"),
                        resultadoConsultaRepresentante.getInt("estadoActivo")
                );
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar el representante: " + e.getMessage());
        }

        return representante;
    }




}
