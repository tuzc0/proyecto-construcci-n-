

import accesoadatos.ActividadDAO;
import logica.actividadesDTO.ActividadDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ActividadDAOTest {

    private ActividadDAO actividadDAO;

    @BeforeEach
    void setUp() {
        actividadDAO = new ActividadDAO();
    }

    @Test
    void testCrearNuevaActividad() {
        ActividadDTO actividad = new ActividadDTO(0, "Actividad de prueba", Timestamp.valueOf("2023-12-31 23:59:59"),
                Timestamp.valueOf("2023-01-01 00:00:00"), "12 meses", "Hitos de prueba");
        try {
            boolean resultado = actividadDAO.crearNuevaActividad(actividad);
            assertTrue(resultado, "La actividad debería haberse creado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al crear la actividad: " + e.getMessage());
        }
    }

    @Test
    void testEliminarActividadPorID() {
        try {
            boolean resultado = actividadDAO.eliminarActividadPorID(1);
            assertTrue(resultado, "La actividad debería haberse eliminado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar la actividad: " + e.getMessage());
        }
    }

    @Test
    void testModificarActividad() {
        ActividadDTO actividad = new ActividadDTO(1, "Actividad modificada", Timestamp.valueOf("2023-12-31 23:59:59"),
                Timestamp.valueOf("2023-01-01 00:00:00"), "6 meses", "Hitos modificados");
        try {
            boolean resultado = actividadDAO.modificarActividad(actividad);
            assertTrue(resultado, "La actividad debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar la actividad: " + e.getMessage());
        }
    }

    @Test
    void testBuscarActividadPorID() {
        try {
            ActividadDTO actividad = actividadDAO.buscarActividadPorID(1);
            assertNotNull(actividad, "La actividad no debería ser nula.");
            assertEquals(1, actividad.getIDActividad(), "El ID de la actividad no coincide.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar la actividad: " + e.getMessage());
        }
    }
}