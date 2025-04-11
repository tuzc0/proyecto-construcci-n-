package accesoadatos.usuariosDAO;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDAOTest {

    @org.junit.jupiter.api.Test
    void testInsertarUsuario() {

        UsuarioDAO usuarioDAO = new UsuarioDAO();


        UsuarioDTO nuevoUsuario = new UsuarioDTO();
        nuevoUsuario.setIdUsuario(1);
        nuevoUsuario.setNombre("John");
        nuevoUsuario.setApellido("Doe");
        nuevoUsuario.setEstado(1);

        try {
            boolean resultado = usuarioDAO.insertarUsuario(nuevoUsuario);
            assertTrue(resultado, "El usuario debería ser insertado correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}