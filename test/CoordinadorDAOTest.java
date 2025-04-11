

import accesoadatos.CoordinadorDAO;
import logica.usuariosDTO.CoordinadorDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CoordinadorDAOTest {

    private CoordinadorDAO coordinadorDAO;

    @BeforeEach
    void setUp() {
        coordinadorDAO = new CoordinadorDAO();
    }

    @Test
    void testInsertarCoordinador() {
        CoordinadorDTO coordinador = new CoordinadorDTO(12345, 15, "Juan", "Perez", 1);
        try {
            boolean resultado = coordinadorDAO.insertarCoordinador(coordinador);
            assertTrue(resultado, "El coordinador debería haberse insertado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al insertar el coordinador: " + e.getMessage());
        }
    }

    @Test
    void testModificarCoordinador() {
        CoordinadorDTO coordinador = new CoordinadorDTO(12345, 1, "Juan", "Perez", 1);
        try {
            boolean resultado = coordinadorDAO.modificarCoordinador(coordinador);
            assertTrue(resultado, "El coordinador debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el coordinador: " + e.getMessage());
        }
    }

    @Test
    void testEliminarCoordinadorPorNumeroDePersonal() {
        int numeroDePersonal = 12345;
        try {
            boolean resultado = coordinadorDAO.eliminarCoordinadorPorNumeroDePersonal(numeroDePersonal);
            assertTrue(resultado, "El coordinador debería haberse marcado como inactivo correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar el coordinador: " + e.getMessage());
        }
    }

    @Test
    void testBuscarCoordinadorPorNumeroDePersonal() {
        int numeroDePersonal = 4567;
        try {
            CoordinadorDTO coordinador = coordinadorDAO.buscarCoordinadorPorNumeroDePersonal(numeroDePersonal);
            assertNotNull(coordinador, "El coordinador no debería ser nulo.");
            assertEquals(numeroDePersonal, coordinador.getNumeroDePersonal(), "El número de personal debería coincidir.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el coordinador: " + e.getMessage());
        }
    }
}