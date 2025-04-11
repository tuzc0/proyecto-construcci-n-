import accesoadatos.AcademicoDAO;
import logica.usuariosDTO.AcademicoDTO;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AcademicoDAOTest {

    private AcademicoDAO academicoDAO;

    @BeforeAll
    void setUp() {
        academicoDAO = new AcademicoDAO();
    }

    @Test
    void testInsertarAcademico() {
        AcademicoDTO academico = new AcademicoDTO(4566, 10, "John", "Doe", 1);

        try {
            boolean resultado = academicoDAO.insertarAcademico(academico);
            assertTrue(resultado, "El académico debería ser insertado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarAcademicoPorNumeroDePersonal() {
        int estadoActivo = 0;
        String numeroDePersonal = "4566";

        try {
            boolean resultado = academicoDAO.eliminarAcademicoPorNumeroDePersonal(estadoActivo, numeroDePersonal);
            assertTrue(resultado, "El académico debería ser eliminado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarAcademico() {
        AcademicoDTO academico = new AcademicoDTO(1234, 1, "Jane", "Smith", 1);

        try {
            boolean resultado = academicoDAO.modificarAcademico(academico);
            assertTrue(resultado, "El académico debería ser modificado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarAcademicoPorNumeroDePersonal() {
        int numeroDePersonal = 1234;

        try {
            AcademicoDTO academico = academicoDAO.buscarAcademicoPorNumeroDePersonal(numeroDePersonal);
            assertNotNull(academico, "El académico no debería ser nulo.");
            assertEquals(numeroDePersonal, academico.getNumeroDePersonal(), "El número de personal debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}
