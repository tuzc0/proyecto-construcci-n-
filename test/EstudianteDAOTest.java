import accesoadatos.EstudianteDAO;
import logica.usuariosDTO.EstudianteDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteDAOTest {

    private EstudianteDAO estudianteDAO;

    @BeforeEach
    void setUp() {
        estudianteDAO = new EstudianteDAO();
    }

    @Test
    void testInsertarEstudiante() {
        EstudianteDTO estudiante = new EstudianteDTO(1, "Juan", "Perez", "A12345", 1);
        try {
            boolean resultado = estudianteDAO.insertarEstudiante(estudiante);
            assertTrue(resultado, "El estudiante debería haberse insertado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al insertar el estudiante: " + e.getMessage());
        }
    }

    @Test
    void testEliminarEstudiantePorMatricula() {
        try {
            boolean resultado = estudianteDAO.eliminarEstudiantePorMatricula(0, "A12345");
            assertTrue(resultado, "El estudiante debería haberse eliminado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al eliminar el estudiante: " + e.getMessage());
        }
    }

    @Test
    void testModificarEstudiante() {
        EstudianteDTO estudiante = new EstudianteDTO(1, "Juan", "Perez", "A12345", 1);
        try {
            boolean resultado = estudianteDAO.modificarEstudiante(estudiante);
            assertTrue(resultado, "El estudiante debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el estudiante: " + e.getMessage());
        }
    }

    @Test
    void testBuscarEstudiantePorMatricula() {

        try {
            EstudianteDTO estudiante = estudianteDAO.buscarEstudiantePorMatricula("A12345");
            assertNotNull(estudiante, "El estudiante no debería ser nulo.");
            assertEquals("A12345", estudiante.getMatricula(), "La matrícula del estudiante no coincide.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el estudiante: " + e.getMessage());
        }
    }
}