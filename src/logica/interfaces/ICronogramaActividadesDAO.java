package logica.interfaces;

import logica.actividadesDTO.CronogramaActividadesDTO;
import java.sql.SQLException;

public interface ICronogramaActividadesDAO {

    boolean crearNuevoCronogramaDeActividades(CronogramaActividadesDTO cronograma) throws SQLException;

    boolean modificarCronogramaDeActividades(CronogramaActividadesDTO cronograma) throws SQLException;

    CronogramaActividadesDTO buscarCronogramaDeActividadesPorID(int idCronograma) throws SQLException;
}
