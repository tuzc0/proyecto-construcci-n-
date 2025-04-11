package accesoadatos;

import logica.actividadesDTO.CronogramaActividadesDTO;
import logica.interfaces.ICronogramaActividadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CronogramaActividadesDAO implements ICronogramaActividadesDAO {

    Connection conexionBaseDeDatos = new ConexionBD().getConnection();
    PreparedStatement sentenciaCronograma = null;
    ResultSet resultadoConsultaCronograma;

    public boolean crearNuevoCronogramaDeActividades(CronogramaActividadesDTO cronograma) throws SQLException {

        String insertarSQLCronograma = "INSERT INTO cronogramaactividades (IDCronograma, fechaInicio, fechaFinal, idEstudiante) VALUES (?, ?, ?, ?)";
        boolean cronogramaInsertado = false;

        try {
            sentenciaCronograma = conexionBaseDeDatos.prepareStatement(insertarSQLCronograma);
            sentenciaCronograma.setInt(1, cronograma.getIDCronograma());
            sentenciaCronograma.setTimestamp(2, cronograma.getFechaInicio());
            sentenciaCronograma.setTimestamp(3, cronograma.getFechaFinal());
            sentenciaCronograma.setString(4, cronograma.getMatriculaEstudiante());
            sentenciaCronograma.executeUpdate();
            cronogramaInsertado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el cronograma de actividades: " + e.getMessage());
        }

        return cronogramaInsertado;
    }

    public boolean modificarCronogramaDeActividades(CronogramaActividadesDTO cronograma) throws SQLException {

        String modificarSQLCronograma = "UPDATE cronogramaactividades SET fechaInicio = ?, fechaFinal = ? WHERE idCronograma = ?";
        boolean cronogramaModificado = false;

        try {
            sentenciaCronograma = conexionBaseDeDatos.prepareStatement(modificarSQLCronograma);
            sentenciaCronograma.setTimestamp(1, cronograma.getFechaInicio());
            sentenciaCronograma.setTimestamp(2, cronograma.getFechaFinal());
            sentenciaCronograma.setInt(3, cronograma.getIDCronograma());
            sentenciaCronograma.executeUpdate();
            cronogramaModificado = true;

        } catch (SQLException e) {
            throw new SQLException("Error al modificar el cronograma de actividades: " + e.getMessage());
        }

        return cronogramaModificado;
    }

    public CronogramaActividadesDTO buscarCronogramaDeActividadesPorID(int idCronograma) throws SQLException {

        CronogramaActividadesDTO cronogramaEncontrado = new CronogramaActividadesDTO(-1, null, null, "0");
        String buscarSQLCronograma = "SELECT * FROM cronogramaactividades WHERE IDCronograma = ?";


        try {
            sentenciaCronograma = conexionBaseDeDatos.prepareStatement(buscarSQLCronograma);
            sentenciaCronograma.setInt(1, idCronograma);
            resultadoConsultaCronograma = sentenciaCronograma.executeQuery();

            if (resultadoConsultaCronograma.next()) {

                cronogramaEncontrado.setIDCronograma(resultadoConsultaCronograma.getInt("idCronograma"));
                cronogramaEncontrado.setFechaInicio(resultadoConsultaCronograma.getTimestamp("fechaInicio"));
                cronogramaEncontrado.setFechaFinal(resultadoConsultaCronograma.getTimestamp("fechaFinal"));
                cronogramaEncontrado.setMatriculaEstudiante(resultadoConsultaCronograma.getString("idEstudiante"));
            }

        } catch (SQLException e) {
            throw new SQLException("Error al buscar el cronograma de actividades: " + e.getMessage());
        }

        return cronogramaEncontrado;
    }




}
