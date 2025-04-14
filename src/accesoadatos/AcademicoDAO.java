package accesoadatos;

import logica.interfaces.IAcademicoDAO;
import logica.usuariosDTO.AcademicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicoDAO implements IAcademicoDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaAcademico = null;
    ResultSet resultadoConsultaAcademico;

    public boolean insertarAcademico(AcademicoDTO academico) throws SQLException {

        String insertarSQLAcademico = "INSERT INTO academico (numeroDePersonal, idUsuario) VALUES (?, ?)";
        boolean academicoInsertado = false;

        try {

            sentenciaAcademico = conexionBaseDeDatos.prepareStatement(insertarSQLAcademico);
            sentenciaAcademico.setInt(1, academico.getNumeroDePersonal());
            sentenciaAcademico.setInt(2, academico.getIdUsuario());
            sentenciaAcademico.executeUpdate();
            academicoInsertado = true;

        } finally {

            if (sentenciaAcademico != null) {

                sentenciaAcademico.close();
            }
        }

        return academicoInsertado;
    }

    public boolean eliminarAcademicoPorNumeroDePersonal(int estadoActivo, String numeroDePersonal) throws SQLException {

        String modificarSQLEstudiante = "UPDATE usuario SET estadoActivo = ? WHERE idUsuario = " +
                "(SELECT idUsuario FROM academico WHERE numeroDePersonal = ?)";
        boolean AcademicoEliminado = false;

        try {

            sentenciaAcademico = conexionBaseDeDatos.prepareStatement(modificarSQLEstudiante);
            sentenciaAcademico.setInt(1, estadoActivo);
            sentenciaAcademico.setString(2, numeroDePersonal);
            sentenciaAcademico.executeUpdate();
            AcademicoEliminado = true;

        } finally {

            if (sentenciaAcademico != null) {

                sentenciaAcademico.close();
            }
        }

        return AcademicoEliminado;
    }

    public boolean modificarAcademico(AcademicoDTO academico) throws SQLException {

        String modificarSQLAcademico = "UPDATE academico SET numeroDePersonal = ?, idUsuario = ? " +
                "WHERE numeroDePersonal = ?";
        boolean academicoModificado = false;

        try {

            sentenciaAcademico = conexionBaseDeDatos.prepareStatement(modificarSQLAcademico);
            sentenciaAcademico.setInt(1, academico.getNumeroDePersonal());
            sentenciaAcademico.setInt(2, academico.getIdUsuario());
            sentenciaAcademico.setInt(3, academico.getNumeroDePersonal());
            sentenciaAcademico.executeUpdate();
            academicoModificado = true;

        } finally {

            if (sentenciaAcademico != null) {

                sentenciaAcademico.close();
            }
        }

        return academicoModificado;
    }

    public AcademicoDTO buscarAcademicoPorNumeroDePersonal(int numeroDePersonal) throws SQLException {

        AcademicoDTO academico = new AcademicoDTO(-1, -1, "N/A", "N/A", 0);

        String buscarSQLAcademico = "SELECT * FROM vista_academico_usuario WHERE numeroDePersonal = ?";

        try {

            sentenciaAcademico = conexionBaseDeDatos.prepareStatement(buscarSQLAcademico);
            sentenciaAcademico.setInt(1, numeroDePersonal);
            resultadoConsultaAcademico = sentenciaAcademico.executeQuery();

            if (resultadoConsultaAcademico.next()) {

                int numeroDePersonalAcademico = resultadoConsultaAcademico.getInt("numeroDePersonal");
                int idUsuario = resultadoConsultaAcademico.getInt("idUsuario");
                String apellidos = resultadoConsultaAcademico.getString("apellidos");
                String nombre = resultadoConsultaAcademico.getString("nombre");
                int estadoActivo = resultadoConsultaAcademico.getInt("estadoActivo");

                academico = new AcademicoDTO(numeroDePersonalAcademico,idUsuario, nombre, apellidos, estadoActivo);
            }

        } finally {

            if (sentenciaAcademico != null) {

                sentenciaAcademico.close();
            }
        }

        return academico;
    }
}
