package logica.interfaces;

import logica.experienciaseducativasDTO.ExperienciaEducativaDTO;
import java.sql.SQLException;

public interface IExperienciaEducativaDAO {

    boolean crearNuevaExperienciaEducativa(ExperienciaEducativaDTO experienciaEducativa) throws SQLException;

    boolean eliminarExperienciaEducativaPorID(int idEE) throws SQLException;

    boolean modificarExperienciaEducativa(ExperienciaEducativaDTO experienciaEducativa) throws SQLException;

    ExperienciaEducativaDTO buscarExperienciaEducativaPorID(int idEE) throws SQLException;
}
