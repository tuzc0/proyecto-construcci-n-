import accesoadatos.CriterioEvaluacionDAO;
import logica.evaluacionesDTO.CriterioEvaluacionDTO;
import org.junit.jupiter.api.*;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CriterioEvaluacionDAOTest {

    private CriterioEvaluacionDAO criterioEvaluacionDAO;

    @BeforeAll
    void setUp() {
        criterioEvaluacionDAO = new CriterioEvaluacionDAO();
    }

    @Test
    void testCrearNuevoCriterioEvaluacion() {
        CriterioEvaluacionDTO criterio = new CriterioEvaluacionDTO(0, "Descripción de prueba Angel", 101);

        try {
            boolean resultado = criterioEvaluacionDAO.crearNuevoCriterioEvaluacion(criterio);
            assertTrue(resultado, "El criterio de evaluación debería ser creado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarCriterioEvaluacionPorID() {
        int idCriterio = 101;

        try {
            boolean resultado = criterioEvaluacionDAO.eliminarCriterioEvaluacionPorID(idCriterio);
            assertTrue(resultado, "El criterio de evaluación debería ser eliminado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarCriterioEvaluacion() {
        CriterioEvaluacionDTO criterio = new CriterioEvaluacionDTO(1, "Descripción modificada", 101);

        try {
            boolean resultado = criterioEvaluacionDAO.modificarCriterioEvaluacion(criterio);
            assertTrue(resultado, "El criterio de evaluación debería ser modificado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarCriterioEvaluacionPorID() {
        int idCriterio = 101;

        try {
            CriterioEvaluacionDTO criterio = criterioEvaluacionDAO.buscarCriterioEvaluacionPorID(idCriterio);
            assertNotNull(criterio, "El criterio de evaluación no debería ser nulo.");
            assertEquals(idCriterio, criterio.getNumeroCriterio(), "El número de criterio debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}
