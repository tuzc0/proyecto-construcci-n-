

import accesoadatos.AcademicoEvaluadorDAO;
import logica.usuariosDTO.AcademicoEvaluadorDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AcademicoEvaluadorDAOTest {

    private AcademicoEvaluadorDAO academicoEvaluadorDAO;

    @BeforeEach
    void setUp() {
        academicoEvaluadorDAO = new AcademicoEvaluadorDAO();
    }

    @Test
    void testInsertarAcademicoEvaluador() {
        AcademicoEvaluadorDTO academico = new AcademicoEvaluadorDTO(9090, 1, "Juan", "Perez", 1);
        try {
            boolean resultado = academicoEvaluadorDAO.insertarAcademicoEvaluador(academico);
            assertTrue(resultado, "El académico evaluador debería haberse insertado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al insertar el académico evaluador: " + e.getMessage());
        }
    }

    @Test
    void testModificarAcademicoEvaluador() {
        AcademicoEvaluadorDTO academico = new AcademicoEvaluadorDTO(8979, 6, "Juan", "Perez", 1);
        try {
            boolean resultado = academicoEvaluadorDAO.modificarAcademicoEvaluador(academico);
            assertTrue(resultado, "El académico evaluador debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el académico evaluador: " + e.getMessage());
        }
    }

    @Test
    void testEliminarAcademicoEvaluadorPorNumeroDePersonal() {
        int numeroDePersonal = 12345;
        try {
            boolean resultado = academicoEvaluadorDAO.eliminarAcademicoEvaluadorPorNumeroDePersonal(numeroDePersonal);
            assertTrue(resultado, "El académico evaluador debería haberse marcado como inactivo correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar el académico evaluador: " + e.getMessage());
        }
    }

    @Test
    void testBuscarAcademicoEvaluadorPorNumeroDePersonal() {
        int numeroDePersonal = 5657;
        try {
            AcademicoEvaluadorDTO academico = academicoEvaluadorDAO.buscarAcademicoEvaluadorPorNumeroDePersonal(numeroDePersonal);
            assertNotNull(academico, "El académico evaluador no debería ser nulo.");
            assertEquals(numeroDePersonal, academico.getNumeroDePersonal(), "El número de personal debería coincidir.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el académico evaluador: " + e.getMessage());
        }
    }
}