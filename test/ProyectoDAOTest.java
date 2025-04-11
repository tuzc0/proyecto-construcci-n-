

import accesoadatos.ProyectoDAO;
import logica.proyectosDTO.ProyectoDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoDAOTest {

    private ProyectoDAO proyectoDAO;

    @BeforeEach
    void setUp() {
        proyectoDAO = new ProyectoDAO();
    }

    @Test
    void testCrearNuevoProyecto() {
        ProyectoDTO proyecto = new ProyectoDTO(0, "Proyecto A", "Descripción A", "2023-01-01", "2023-12-31", 1, "A12345", 1);
        try {
            boolean resultado = proyectoDAO.crearNuevoProyecto(proyecto);
            assertTrue(resultado, "El proyecto debería haberse creado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al crear el proyecto: " + e.getMessage());
        }
    }

    @Test
    void testEliminarProyectoPorID() {
        int idProyecto = 1;
        try {
            boolean resultado = proyectoDAO.eliminarProyectoPorID(idProyecto);
            assertTrue(resultado, "El proyecto debería haberse marcado como inactivo correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar el proyecto: " + e.getMessage());
        }
    }

    @Test
    void testModificarProyecto() {
        ProyectoDTO proyecto = new ProyectoDTO(2, "Proyecto Modificado", "Descripción Modificada", "2023-01-01", "2023-12-31", 102, "A12345", 1);
        try {
            boolean resultado = proyectoDAO.modificarProyecto(proyecto);
            assertTrue(resultado, "El proyecto debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el proyecto: " + e.getMessage());
        }
    }

    @Test
    void testBuscarProyectoPorID() {
        int idProyecto = 3;
        try {
            ProyectoDTO proyecto = proyectoDAO.buscarProyectoPorID(idProyecto);
            assertNotNull(proyecto, "El proyecto no debería ser nulo.");
            assertEquals(idProyecto, proyecto.getIDProyecto(), "El ID del proyecto debería coincidir.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el proyecto: " + e.getMessage());
        }
    }
}
