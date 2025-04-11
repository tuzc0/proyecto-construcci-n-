import accesoadatos.CriterioAutoevaluacionDAO;
import logica.evaluacionesDTO.CriterioAutoevaluacionDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CriterioAutoevaluacionDAOTest {

    private CriterioAutoevaluacionDAO criterioAutoevaluacionDAO;

    @BeforeAll
    void setUp() {
        criterioAutoevaluacionDAO = new CriterioAutoevaluacionDAO();
    }

    @Test
    void testCrearNuevoCriterioAutoevaluacion() {
        CriterioAutoevaluacionDTO criterio = new CriterioAutoevaluacionDTO(1, "Descripción de prueba", 101);

        try {
            boolean resultado = criterioAutoevaluacionDAO.crearNuevoCriterioAutoevaluacion(criterio);
            assertTrue(resultado, "El criterio de autoevaluación debería ser creado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarCriterioAutoevaluacionPorNumeroDeCriterio() {
        int numeroDeCriterio = 101;

        try {
            boolean resultado = criterioAutoevaluacionDAO.eliminarCriterioAutoevaluacionPorNumeroDeCriterio(numeroDeCriterio);
            assertTrue(resultado, "El criterio de autoevaluación debería ser eliminado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarCriterioAutoevaluacion() {
        CriterioAutoevaluacionDTO criterio = new CriterioAutoevaluacionDTO(1, "Descripción modificada", 101);

        try {
            boolean resultado = criterioAutoevaluacionDAO.modificarCriterioAutoevaluacion(criterio);
            assertTrue(resultado, "El criterio de autoevaluación debería ser modificado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarCriterioAutoevaluacionPorID() {
        int numeroDeCriterio = 101;

        try {
            CriterioAutoevaluacionDTO criterio = criterioAutoevaluacionDAO.buscarCriterioAutoevaluacionPorID(numeroDeCriterio);
            assertNotNull(criterio, "El criterio de autoevaluación no debería ser nulo.");
            assertEquals(numeroDeCriterio, criterio.getNumeroCriterio(), "El número de criterio debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}
