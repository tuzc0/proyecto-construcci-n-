package test.accesoadatos;

import accesoadatos.CuentaDAO;
import logica.usuariosDTO.CuentaDTO;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaDAOTest {

    private CuentaDAO cuentaDAO;

    @BeforeAll
    void setUp() {
        cuentaDAO = new CuentaDAO();
    }

    @Test
    void testCrearNuevaCuenta() {
        CuentaDTO cuenta = new CuentaDTO("test@example.com", "password123");

        try {
            boolean resultado = cuentaDAO.crearNuevaCuenta(cuenta);
            assertTrue(resultado, "La cuenta debería ser creada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testEliminarCuentaPorID() {
        int idUsuario = 1;

        try {
            boolean resultado = cuentaDAO.eliminarCuentaPorID(idUsuario);
            assertTrue(resultado, "La cuenta debería ser eliminada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testModificarCuenta() {
        CuentaDTO cuenta = new CuentaDTO("updated@example.com", "newpassword123");
        cuenta.setIdUsuario(1);

        try {
            boolean resultado = cuentaDAO.modificarCuenta(cuenta);
            assertTrue(resultado, "La cuenta debería ser modificada correctamente.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    void testBuscarCuentaPorID() {
        int idUsuario = 1;

        try {
            CuentaDTO cuenta = cuentaDAO.buscarCuentaPorID(idUsuario);
            assertNotNull(cuenta, "La cuenta no debería ser nula.");
            assertEquals(idUsuario, cuenta.getIdUsuario(), "El ID del usuario debería coincidir.");
        } catch (SQLException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}