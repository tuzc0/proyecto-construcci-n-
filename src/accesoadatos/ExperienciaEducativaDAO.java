package accesoadatos;

import logica.experienciaseducativasDTO.ExperienciaEducativaDTO;
import logica.interfaces.IExperienciaEducativaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperienciaEducativaDAO implements IExperienciaEducativaDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaExperienciaEducativa = null;
    ResultSet resultadoExperienciaEducativa;


    public boolean crearNuevaExperienciaEducativa(ExperienciaEducativaDTO experienciaEducativa) throws SQLException {
        boolean experienciaEducativaInsertada = false;

        String insertarSQLEducativa = "INSERT INTO experienciaeducativa VALUES(?, ?)";

        try {

            sentenciaExperienciaEducativa = conexionBaseDeDatos.prepareStatement(insertarSQLEducativa);
            sentenciaExperienciaEducativa.setInt(1, experienciaEducativa.getIdEE());
            sentenciaExperienciaEducativa.setString(2, experienciaEducativa.getNombre());
            sentenciaExperienciaEducativa.executeUpdate();
            experienciaEducativaInsertada = true;

        } catch (SQLException e) {

            throw new SQLException("Error al insertar la experiencia educativa: " + e.getMessage());
        }

        return experienciaEducativaInsertada;
    }

    public boolean modificarExperienciaEducativa(ExperienciaEducativaDTO experienciaEducativa) throws SQLException {
        boolean experienciaEducativaModificada = false;

        String modificarSQLEducativa = "UPDATE experienciaeducativa SET nombre = ? WHERE idEE = ?";

        try {

            sentenciaExperienciaEducativa = conexionBaseDeDatos.prepareStatement(modificarSQLEducativa);
            sentenciaExperienciaEducativa.setString(1, experienciaEducativa.getNombre());
            sentenciaExperienciaEducativa.setInt(2, experienciaEducativa.getIdEE());
            sentenciaExperienciaEducativa.executeUpdate();
            experienciaEducativaModificada = true;

        } catch (SQLException e) {

            throw new SQLException("Error al modificar la experiencia educativa: " + e.getMessage());
        }

        return experienciaEducativaModificada;
    }

    public ExperienciaEducativaDTO mostrarExperienciaEducativa() throws SQLException {

        ExperienciaEducativaDTO experienciaEducativa = new ExperienciaEducativaDTO(-1,"N/A");

        String consultaSQL = "SELECT * FROM experienciaeducativa";

        try {
            sentenciaExperienciaEducativa = conexionBaseDeDatos.prepareStatement(consultaSQL);
            resultadoExperienciaEducativa = sentenciaExperienciaEducativa.executeQuery();

            if (resultadoExperienciaEducativa.next()) {

                experienciaEducativa.setIdEE(resultadoExperienciaEducativa.getInt("idEE"));
                experienciaEducativa.setNombre(resultadoExperienciaEducativa.getString("nombre"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al mostrar la experiencia educativa: " + e.getMessage());
        }

        return experienciaEducativa;
    }
}
