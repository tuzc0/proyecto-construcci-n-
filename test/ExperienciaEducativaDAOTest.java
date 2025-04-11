

import accesoadatos.ExperienciaEducativaDAO;
import logica.experienciaseducativasDTO.ExperienciaEducativaDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ExperienciaEducativaDAOTest {

    private ExperienciaEducativaDAO experienciaEducativaDAO;

    @BeforeEach
    void setUp() {
        experienciaEducativaDAO = new ExperienciaEducativaDAO();
    }

    @Test
    void testCrearNuevaExperienciaEducativa() {
        ExperienciaEducativaDTO experiencia = new ExperienciaEducativaDTO(0, "Matemáticas");
        try {
            boolean resultado = experienciaEducativaDAO.crearNuevaExperienciaEducativa(experiencia);
            assertTrue(resultado, "La experiencia educativa debería haberse creado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al crear la experiencia educativa: " + e.getMessage());
        }
    }

    @Test
    void testModificarExperienciaEducativa() {
        ExperienciaEducativaDTO experiencia = new ExperienciaEducativaDTO(1, "Física");
        try {
            boolean resultado = experienciaEducativaDAO.modificarExperienciaEducativa(experiencia);
            assertTrue(resultado, "La experiencia educativa debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar la experiencia educativa: " + e.getMessage());
        }
    }

    @Test
    void testMostrarExperienciaEducativa() {
        try {
            ExperienciaEducativaDTO experiencia = experienciaEducativaDAO.mostrarExperienciaEducativa();
            assertNotNull(experiencia, "La experiencia educativa no debería ser nula.");
            assertNotEquals(-1, experiencia.getIdEE(), "El ID de la experiencia educativa no debería ser -1.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al mostrar la experiencia educativa: " + e.getMessage());
        }
    }
}