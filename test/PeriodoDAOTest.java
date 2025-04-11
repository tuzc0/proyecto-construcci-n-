

import accesoadatos.PeriodoDAO;
import logica.experienciaseducativasDTO.PeriodoDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PeriodoDAOTest {

    private PeriodoDAO periodoDAO;

    @BeforeEach
    void setUp() {
        periodoDAO = new PeriodoDAO();
    }

    @Test
    void testCrearNuevoPeriodo() {
        PeriodoDTO periodo = new PeriodoDTO(0, "Periodo de prueba", 1);
        try {
            boolean resultado = periodoDAO.crearNuevoPeriodo(periodo);
            assertTrue(resultado, "El periodo debería haberse creado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al crear el periodo: " + e.getMessage());
        }
    }

    @Test
    void testEliminarPeriodoPorID() {
        try {
            boolean resultado = periodoDAO.eliminarPeriodoPorID(1);
            assertTrue(resultado, "El periodo debería haberse eliminado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar el periodo: " + e.getMessage());
        }
    }

    @Test
    void testModificarPeriodo() {
        PeriodoDTO periodo = new PeriodoDTO(1, "Periodo modificado", 1);
        try {
            boolean resultado = periodoDAO.modificarPeriodo(periodo);
            assertTrue(resultado, "El periodo debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el periodo: " + e.getMessage());
        }
    }

    @Test
    void testMostrarPeriodoActual() {
        try {
            PeriodoDTO periodo = periodoDAO.mostrarPeriodoActual();
            assertNotNull(periodo, "El periodo actual no debería ser nulo.");
            assertEquals(1, periodo.getEstadoActivo(), "El estado activo del periodo no coincide.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al mostrar el periodo actual: " + e.getMessage());
        }
    }
}