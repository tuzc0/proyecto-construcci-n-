import accesoadatos.RepresentanteDAO;

import logica.ovsDTO.RepresentanteDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RepresentanteDAOTest {

    private RepresentanteDAO representanteDAO;

    @BeforeEach
    void setUp() {
        representanteDAO = new RepresentanteDAO();
    }

    @Test
    void testInsertarRepresentante() {
        RepresentanteDTO representante = new RepresentanteDTO(0, "correo@example.com", "1234567890", "Juan", "Carlos", 10, 1);
        try {
            boolean resultado = representanteDAO.insertarRepresentante(representante);
            assertTrue(resultado, "El representante debería haberse insertado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al insertar el representante: " + e.getMessage());
        }
    }

    @Test
    void testEliminarRepresentantePorID() {
        try {
            boolean resultado = representanteDAO.eliminarRepresentantePorID(1);
            assertTrue(resultado, "El representante debería haberse eliminado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar el representante: " + e.getMessage());
        }
    }

    @Test
    void testModificarRepresentante() {
        RepresentanteDTO representante = new RepresentanteDTO(1, "correo_modificado@example.com", "0987654321", "Juan", "Carlos", 10, 1);
        try {
            boolean resultado = representanteDAO.modificarRepresentante(representante);
            assertTrue(resultado, "El representante debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el representante: " + e.getMessage());
        }
    }

    @Test
    void testBuscarRepresentantePorID() {
        try {
            RepresentanteDTO representante = representanteDAO.buscarRepresentantePorID(1);
            assertNotNull(representante, "El representante no debería ser nulo.");
            assertEquals(1, representante.getIDRepresentante(), "El ID del representante no coincide.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el representante: " + e.getMessage());
        }
    }
}