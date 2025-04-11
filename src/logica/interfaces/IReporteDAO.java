package logica.interfaces;

import logica.proyectosDTO.ReporteDTO;
import java.sql.SQLException;

public interface IReporteDAO {

    boolean insertarReporte(ReporteDTO reporte) throws SQLException;

    boolean eliminarReportePorID(int idReporte) throws SQLException;

    boolean modificarReporte(ReporteDTO reporte) throws SQLException;

    ReporteDTO buscarReportePorID(int idReporte) throws SQLException;
}
