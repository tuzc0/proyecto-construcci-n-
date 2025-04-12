

import accesoadatos.ReporteDAO;
import logica.proyectosDTO.ReporteDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDAOTest {

    private ReporteDAO reporteDAO;

    @BeforeEach
    void setUp() {
        reporteDAO = new ReporteDAO();
    }

    @Test
    void testInsertarReporte() {
        ReporteDTO reporte = new ReporteDTO(0, 10, "Metodología A", "Observaciones A", Timestamp.valueOf("2023-10-01 10:00:00"), "A12345");
        try {
            boolean resultado = reporteDAO.insertarReporte(reporte);
            assertTrue(resultado, "El reporte debería haberse insertado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al insertar el reporte: " + e.getMessage());
        }
    }

    @Test
    void testModificarReporte() {
        ReporteDTO reporte = new ReporteDTO(1, 15, "Metodología Modificada", "Observaciones Modificadas", Timestamp.valueOf("2023-10-02 12:00:00"), "A12345");
        try {
            boolean resultado = reporteDAO.modificarReporte(reporte);
            assertTrue(resultado, "El reporte debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el reporte: " + e.getMessage());
        }
    }

    @Test
    void testBuscarReportePorID() {
        int idReporte = 1;
        try {
            ReporteDTO reporte = reporteDAO.buscarReportePorID(idReporte);
            assertNotNull(reporte, "El reporte no debería ser nulo.");
            assertEquals(idReporte, reporte.getIDReporte(), "El ID del reporte debería coincidir.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el reporte: " + e.getMessage());
        }
    }
}