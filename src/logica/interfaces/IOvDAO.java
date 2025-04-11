package logica.interfaces;

import logica.ovsDTO.OvDTO;
import java.sql.SQLException;

public interface IOvDAO {
    boolean crearNuevoOv(OvDTO ov) throws SQLException;

    boolean eliminarOvPorID(int idOv) throws SQLException;

    boolean modificarOv(OvDTO ov) throws SQLException;

    OvDTO buscarOvPorID(int idOv) throws SQLException;
}
