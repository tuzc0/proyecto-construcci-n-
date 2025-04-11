package logica.interfaces;

import logica.ovsDTO.RepresentanteDTO;
import java.sql.SQLException;

public interface IRepresentanteDAO {

    boolean insertarRepresentante(RepresentanteDTO representante) throws SQLException;

    boolean eliminarRepresentantePorID(int idRepresentante) throws SQLException;

    boolean modificarRepresentante(RepresentanteDTO representante) throws SQLException;

    RepresentanteDTO buscarRepresentantePorID(int idRepresentante) throws SQLException;
}
