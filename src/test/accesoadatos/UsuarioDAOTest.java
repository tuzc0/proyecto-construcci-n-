package accesoadatos;

import logica.usuariosDTO.UsuarioDTO;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioDAOTest {

    private UsuarioDAO usuarioDAO;

    @BeforeAll
    void setUp() {

        usuarioDAO = new UsuarioDAO();
    }

    @Test
    void testInsertarUsuario() {
        UsuarioDTO usuario = new UsuarioDTO(1, "John", "Doe", 1);

        try {
            boolean resultado = usuarioDAO.insertarUsuario(usuario);
            assertTrue(resultado, "El usuario debería ser insertado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarUsuarioPorID() {
        int idUsuario = 1;

        try {
            boolean resultado = usuarioDAO.eliminarUsuarioPorID(idUsuario);
            assertTrue(resultado, "El usuario debería ser eliminado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarUsuario() {
        UsuarioDTO usuario = new UsuarioDTO(1, "Jane", "Smith", 1);

        try {

            boolean resultado = usuarioDAO.modificarUsuario(usuario);
            assertTrue(resultado, "El usuario debería ser modificado correctamente.");

        } catch (SQLException e) {

            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarUsuarioPorID() {
        int idUsuario = 1;

        try {
            UsuarioDTO usuario = usuarioDAO.buscarUsuarioPorID(idUsuario);
            assertNotNull(usuario, "El usuario no debería ser nulo.");
            assertEquals(idUsuario, usuario.getIdUsuario(), "El ID del usuario debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}
