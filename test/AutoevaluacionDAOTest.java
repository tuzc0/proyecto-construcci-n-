import accesoadatos.AutoevaluacionDAO;
import logica.evaluacionesDTO.AutoevaluacionDTO;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AutoevaluacionDAOTest {

    private AutoevaluacionDAO autoevaluacionDAO;

    @BeforeAll
    void setUp() {
        autoevaluacionDAO = new AutoevaluacionDAO();
    }

    @Test
    void testCrearNuevaAutoevaluacion() {
        AutoevaluacionDTO autoevaluacion = new AutoevaluacionDTO(1, new Timestamp(System.currentTimeMillis()), "Aula 101", 85, "zs2301358");

        try {
            boolean resultado = autoevaluacionDAO.crearNuevaAutoevaluacion(autoevaluacion);
            assertTrue(resultado, "La autoevaluación debería ser creada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarAutoevaluacionPorID() {
        int idAutoevaluacion = 1;

        try {
            boolean resultado = autoevaluacionDAO.eliminarAutoevaluacionPorID(idAutoevaluacion);
            assertTrue(resultado, "La autoevaluación debería ser eliminada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarAutoevaluacion() {
        AutoevaluacionDTO autoevaluacion = new AutoevaluacionDTO(1, new Timestamp(System.currentTimeMillis()), "Aula 102", 90, "zs2301358");

        try {
            boolean resultado = autoevaluacionDAO.modificarAutoevaluacion(autoevaluacion);
            assertTrue(resultado, "La autoevaluación debería ser modificada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarAutoevaluacionPorID() {
        int idAutoevaluacion = 1;

        try {
            AutoevaluacionDTO autoevaluacion = autoevaluacionDAO.buscarAutoevaluacionPorID(idAutoevaluacion);
            assertNotNull(autoevaluacion, "La autoevaluación no debería ser nula.");
            assertEquals(idAutoevaluacion, autoevaluacion.getIDAutoevaluacion(), "El ID de la autoevaluación debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}
