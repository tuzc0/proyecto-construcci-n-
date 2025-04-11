
import accesoadatos.OvDAO;
import logica.ovsDTO.OvDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class OvDAOTest {

    private OvDAO ovDAO;

    @BeforeEach
    void setUp() {
        ovDAO = new OvDAO();
    }

    @Test
    void testCrearNuevaOv() {
        OvDTO ov = new OvDTO(0, "Organización 1", "Dirección 1", "correo1@example.com", "1234567890", 1);
        try {
            boolean resultado = ovDAO.crearNuevaOv(ov);
            assertTrue(resultado, "La OV debería haberse creado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al crear la OV: " + e.getMessage());
        }
    }

    @Test
    void testEliminarOvPorID() {
        try {
            boolean resultado = ovDAO.eliminarOvPorID(1);
            assertTrue(resultado, "La OV debería haberse eliminado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar la OV: " + e.getMessage());
        }
    }

    @Test
    void testModificarOv() {
        OvDTO ov = new OvDTO(1, "Organización Modificada", "Dirección Modificada", "correo_modificado@example.com", "0987654321", 1);
        try {
            boolean resultado = ovDAO.modificarOv(ov);
            assertTrue(resultado, "La OV debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar la OV: " + e.getMessage());
        }
    }

    @Test
    void testBuscarOvPorID() {
        try {
            OvDTO ov = ovDAO.buscarOvPorID(1);
            assertNotNull(ov, "La OV no debería ser nula.");
            assertEquals(1, ov.getIdOV(), "El ID de la OV no coincide.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar la OV: " + e.getMessage());
        }
    }
}