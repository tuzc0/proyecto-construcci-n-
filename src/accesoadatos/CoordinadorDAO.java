package accesoadatos;

import logica.interfaces.ICoordinadorDAO;
import logica.usuariosDTO.CoordinadorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDAO implements ICoordinadorDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaCoordinador = null;
    ResultSet resultadoCoordinador;

    public boolean insertarCoordinador (CoordinadorDTO coordinador) throws SQLException {

        boolean coordinadorInsertado = false;

        String insertarSQLCoordinador = "INSERT INTO coordinador VALUES(?, ?)";

        try {

            sentenciaCoordinador = conexionBaseDeDatos.prepareStatement(insertarSQLCoordinador);
            sentenciaCoordinador.setInt(1, coordinador.getNumeroDePersonal());
            sentenciaCoordinador.setInt(2, coordinador.getIdUsuario());
            sentenciaCoordinador.executeUpdate();
            coordinadorInsertado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al insertar el coordinador: " + e.getMessage());
        }

        return coordinadorInsertado;
    }

    public boolean eliminarCoordinadorPorNumeroDePersonal (int numeroDePersonal) throws SQLException {

        boolean coordinadorModificado = false;

        String modificarSQLCoordinador = "UPDATE usuario SET estadoActivo = 0 WHERE idUsuario = " +
                "(SELECT idUsuario FROM coordinador WHERE numeroDePersonal = ?)";

        try {

            sentenciaCoordinador = conexionBaseDeDatos.prepareStatement(modificarSQLCoordinador);
            sentenciaCoordinador.setInt(1, numeroDePersonal);
            sentenciaCoordinador.executeUpdate();
            coordinadorModificado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar el coordinador: " + e.getMessage());
        }

        return coordinadorModificado;
    }


    public boolean modificarCoordinador (CoordinadorDTO coordinador) throws SQLException {

        boolean coordinadorModificado = false;

        String modificarSQLCoordinador = "UPDATE coordinador SET numeroDePersonal = ? WHERE idUsuario = ?";

        try {

            sentenciaCoordinador = conexionBaseDeDatos.prepareStatement(modificarSQLCoordinador);
            sentenciaCoordinador.setInt(1, coordinador.getNumeroDePersonal());
            sentenciaCoordinador.setInt(2, coordinador.getIdUsuario());
            sentenciaCoordinador.executeUpdate();
            coordinadorModificado = true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar el coordinador: " + e.getMessage());
        }

        return coordinadorModificado;
    }

    public CoordinadorDTO buscarCoordinadorPorNumeroDePersonal (int numeroDePersonal) throws SQLException {

        CoordinadorDTO coordinador = new CoordinadorDTO(-1, -1, "N/A", "N/A", 0);

        String consultaSQL = "SELECT * FROM vista_coordinadores WHERE numeroDePersonal = ?";

        try {
            sentenciaCoordinador = conexionBaseDeDatos.prepareStatement(consultaSQL);
            sentenciaCoordinador.setInt(1, numeroDePersonal);
            resultadoCoordinador = sentenciaCoordinador.executeQuery();

            if (resultadoCoordinador.next()) {

                coordinador.setNumeroDePersonal(resultadoCoordinador.getInt("numeroDePersonal"));
                coordinador.setIdUsuario(resultadoCoordinador.getInt("idUsuario"));
                coordinador.setNombre(resultadoCoordinador.getString("nombre"));
                coordinador.setApellido(resultadoCoordinador.getString("apellidos"));
                coordinador.setEstado(resultadoCoordinador.getInt("estadoActivo"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar el coordinador: " + e.getMessage());
        }

        return coordinador;
    }

}
