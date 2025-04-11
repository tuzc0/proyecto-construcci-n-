package accesoadatos;

import logica.experienciaseducativasDTO.GrupoDTO;
import logica.interfaces.IGrupoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrupoDAO implements IGrupoDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaGrupo = null;
    ResultSet resultadoGrupo;

    public boolean crearNuevoGrupo(GrupoDTO grupo) {

        boolean resultado = false;
        String sql = "INSERT INTO Grupo (NRC, nombre, numeroPersonal, idEE, idPeriodo, estadoActivo) VALUES (?, ?, ?, ?, ?, ?)";
        try {

            sentenciaGrupo = conexionBaseDeDatos.prepareStatement(sql);
            sentenciaGrupo.setInt(1, grupo.getNRC());
            sentenciaGrupo.setString(2, grupo.getNombre());
            sentenciaGrupo.setInt(3, grupo.getNumeroPersonal());
            sentenciaGrupo.setInt(4, grupo.getIdEE());
            sentenciaGrupo.setInt(5, grupo.getIdPeriodo());
            sentenciaGrupo.setInt(6, 1);
            sentenciaGrupo.executeUpdate();
            resultado = true;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return resultado;
    }

    public boolean eliminarGrupoPorNRC(int NRC) {

        boolean resultado = false;
        String sql = "UPDATE Grupo SET estadoActivo = 0 WHERE NRC = ?";
        try {

            sentenciaGrupo = conexionBaseDeDatos.prepareStatement(sql);
            sentenciaGrupo.setInt(1, NRC);
            sentenciaGrupo.executeUpdate();
            resultado = true;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return resultado;
    }

    public boolean modificarGrupo(GrupoDTO grupo) throws SQLException {
        boolean resultado = false;
        String sql = "UPDATE Grupo SET nombre = ?, numeroPersonal = ?, idEE = ?, idPeriodo = ?, estadoActivo = ? WHERE NRC = ?";
        try {
            sentenciaGrupo = conexionBaseDeDatos.prepareStatement(sql);
            sentenciaGrupo.setString(1, grupo.getNombre());
            sentenciaGrupo.setInt(2, grupo.getNumeroPersonal());
            sentenciaGrupo.setInt(3, grupo.getIdEE());
            sentenciaGrupo.setInt(4, grupo.getIdPeriodo());
            sentenciaGrupo.setInt(5, grupo.getEstadoActivo());
            sentenciaGrupo.setInt(6, grupo.getNRC());
            sentenciaGrupo.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            throw new SQLException("Error al modificar el grupo: " + e.getMessage());
        }
        return resultado;
    }

    public GrupoDTO buscarGrupoPorNRC(int NRC) {

        GrupoDTO grupo = new GrupoDTO(-1, "N/A", -1, -1, -1, -1);
        String sql = "SELECT * FROM Grupo WHERE NRC = ?";
        try {

            sentenciaGrupo = conexionBaseDeDatos.prepareStatement(sql);
            sentenciaGrupo.setInt(1, NRC);
            resultadoGrupo = sentenciaGrupo.executeQuery();
            if (resultadoGrupo.next()) {

                grupo.setNRC(resultadoGrupo.getInt("NRC"));
                grupo.setNombre(resultadoGrupo.getString("nombre"));
                grupo.setNumeroPersonal(resultadoGrupo.getInt("numeroPersonal"));
                grupo.setIdEE(resultadoGrupo.getInt("idEE"));
                grupo.setIdPeriodo(resultadoGrupo.getInt("idPeriodo"));
                grupo.setEstadoActivo(resultadoGrupo.getInt("estadoActivo"));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return grupo;
    }

    public GrupoDTO mostrarGruposActivos() {

        GrupoDTO grupo = new GrupoDTO(-1, "N/A", -1, -1, -1, -1);
        String sql = "SELECT * FROM Grupo WHERE estadoActivo = 1";
        try {

            sentenciaGrupo = conexionBaseDeDatos.prepareStatement(sql);
            resultadoGrupo = sentenciaGrupo.executeQuery();
            if (resultadoGrupo.next()) {

                grupo.setNRC(resultadoGrupo.getInt("NRC"));
                grupo.setNombre(resultadoGrupo.getString("nombre"));
                grupo.setNumeroPersonal(resultadoGrupo.getInt("numeroPersonal"));
                grupo.setIdEE(resultadoGrupo.getInt("idEE"));
                grupo.setIdPeriodo(resultadoGrupo.getInt("idPeriodo"));
                grupo.setEstadoActivo(resultadoGrupo.getInt("estadoActivo"));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return grupo;
    }


}
