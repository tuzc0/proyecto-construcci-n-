import accesoadatos.EvaluacionDAO;
import logica.evaluacionesDTO.EvaluacionDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EvaluacionDAOTest {

    private EvaluacionDAO evaluacionDAO;

    @BeforeAll
    void setUp() {
        evaluacionDAO = new EvaluacionDAO();
    }

    @Test
    void testCrearNuevaEvaluacion() {
        EvaluacionDTO evaluacion = new EvaluacionDTO(0, "Buen trabajo", 90, 8978, "zs2301358", 1);

        try {
            boolean resultado = evaluacionDAO.crearNuevaEvaluacion(evaluacion);
            assertTrue(resultado, "La evaluación debería ser creada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarEvaluacionPorID() {
        int estadoActivo = 0;
        int idEvaluacion = 1;

        try {
            boolean resultado = evaluacionDAO.eliminarEvaluacionPorID(estadoActivo, idEvaluacion);
            assertTrue(resultado, "La evaluación debería ser eliminada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarEvaluacion() {
        EvaluacionDTO evaluacion = new EvaluacionDTO(1, "Trabajo excelente", 95, 8978, "zs2301358", 1);

        try {
            boolean resultado = evaluacionDAO.modificarEvaluacion(evaluacion);
            assertTrue(resultado, "La evaluación debería ser modificada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarEvaluacionPorID() {
        int idEvaluacion = 1;

        try {
            EvaluacionDTO evaluacion = evaluacionDAO.buscarEvaluacionPorID(idEvaluacion);
            assertNotNull(evaluacion, "La evaluación no debería ser nula.");
            assertEquals(idEvaluacion, evaluacion.getIDEvaluacion(), "El ID de la evaluación debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}