package accesoadatos;

import logica.interfaces.IAcademicoEvaluadorDAO;
import logica.usuariosDTO.AcademicoEvaluadorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicoEvaluadorDAO implements IAcademicoEvaluadorDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaAcademicoEvaluador = null;
    ResultSet resultadoConsultaAcademicoEvaluador;

    public boolean insertarAcademicoEvaluador(AcademicoEvaluadorDTO academicoEvaluador) throws SQLException {

        String insertarSQLAcademicoEvaluador = "INSERT INTO academicoevaluador (numeroDePersonal, idUsuario) VALUES (?, ?)";
        boolean academicoEvaluadorInsertado = false;

        try {
            sentenciaAcademicoEvaluador = conexionBaseDeDatos.prepareStatement(insertarSQLAcademicoEvaluador);
            sentenciaAcademicoEvaluador.setInt(1, academicoEvaluador.getNumeroDePersonal());
            sentenciaAcademicoEvaluador.setInt(2, academicoEvaluador.getIdUsuario());
            sentenciaAcademicoEvaluador.executeUpdate();
            academicoEvaluadorInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el académico evaluador: " + e.getMessage());
        }

        return academicoEvaluadorInsertado;
    }

    public boolean eliminarAcademicoEvaluadorPorNumeroDePersonal(int numeroDePersonal) throws SQLException {

        String modificarSQLAcademicoEvaluador = "UPDATE usuario SET estadoActivo = ? WHERE idUsuario = (SELECT idUsuario FROM academicoevaluador WHERE numeroDePersonal = ?)";
        boolean academicoEvaluadorEliminado = false;

        try {
            sentenciaAcademicoEvaluador = conexionBaseDeDatos.prepareStatement(modificarSQLAcademicoEvaluador);
            sentenciaAcademicoEvaluador.setInt(1, 0);
            sentenciaAcademicoEvaluador.setInt(2, numeroDePersonal);
            sentenciaAcademicoEvaluador.executeUpdate();
            academicoEvaluadorEliminado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el académico evaluador: " + e.getMessage());
        }

        return academicoEvaluadorEliminado;
    }

    public boolean modificarAcademicoEvaluador(AcademicoEvaluadorDTO academicoEvaluador) throws SQLException {

        String modificarSQLAcademicoEvaluador = "UPDATE academicoevaluador SET numeroDePersonal = ?, idUsuario = ? WHERE numeroDePersonal = ?";
        boolean academicoEvaluadorModificado = false;

        try {
            sentenciaAcademicoEvaluador = conexionBaseDeDatos.prepareStatement(modificarSQLAcademicoEvaluador);
            sentenciaAcademicoEvaluador.setInt(1, academicoEvaluador.getNumeroDePersonal());
            sentenciaAcademicoEvaluador.setInt(2, academicoEvaluador.getIdUsuario());
            sentenciaAcademicoEvaluador.setInt(3, academicoEvaluador.getNumeroDePersonal());
            sentenciaAcademicoEvaluador.executeUpdate();
            academicoEvaluadorModificado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el académico evaluador: " + e.getMessage());
        }

        return academicoEvaluadorModificado;
    }

    public AcademicoEvaluadorDTO buscarAcademicoEvaluadorPorNumeroDePersonal(int numeroDePersonal) throws SQLException {

        String consultaSQLAcademicoEvaluador = "SELECT * FROM vista_evaluadores WHERE numeroDePersonal = ?";
        AcademicoEvaluadorDTO academicoEvaluador = new AcademicoEvaluadorDTO(-1,1, "", "", 0);

        try {

            sentenciaAcademicoEvaluador = conexionBaseDeDatos.prepareStatement(consultaSQLAcademicoEvaluador);
            sentenciaAcademicoEvaluador.setInt(1, numeroDePersonal);
            resultadoConsultaAcademicoEvaluador = sentenciaAcademicoEvaluador.executeQuery();

            if (resultadoConsultaAcademicoEvaluador.next()) {

                int numeroDePersonalAcademico = resultadoConsultaAcademicoEvaluador.getInt("numeroDePersonal");
                int idUsuario = resultadoConsultaAcademicoEvaluador.getInt("idUsuario");
                String nombre = resultadoConsultaAcademicoEvaluador.getString("nombre");
                String apellido = resultadoConsultaAcademicoEvaluador.getString("apellidos");
                int estadoActivo = resultadoConsultaAcademicoEvaluador.getInt("estadoActivo");

                academicoEvaluador = new AcademicoEvaluadorDTO(numeroDePersonalAcademico, idUsuario, nombre, apellido, estadoActivo);
            }

        } catch (SQLException e) {

            throw new SQLException("Error al obtener el académico evaluador: " + e.getMessage());
        }

        return academicoEvaluador;
    }



}
