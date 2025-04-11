

import accesoadatos.GrupoDAO;
import logica.experienciaseducativasDTO.GrupoDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GrupoDAOTest {

    private GrupoDAO grupoDAO;

    @BeforeEach
    void setUp() {
        grupoDAO = new GrupoDAO();
    }

    @Test
    void testCrearNuevoGrupo() {
        GrupoDTO grupo = new GrupoDTO(106, "Grupo A", 1235, 1, 1, 1);
        try {
            boolean resultado = grupoDAO.crearNuevoGrupo(grupo);
            assertTrue(resultado, "El grupo debería haberse creado correctamente.");
        } catch (Exception e) {
            fail("Se produjo una excepción al crear el grupo: " + e.getMessage());
        }
    }



    @Test
    void testEliminarGrupoPorNRC() {
        int NRC = 101;
        try {
            boolean resultado = grupoDAO.eliminarGrupoPorNRC(NRC);
            assertTrue(resultado, "El grupo debería haberse marcado como inactivo correctamente.");
        } catch (Exception e) {
            fail("Se produjo una excepción al eliminar el grupo: " + e.getMessage());
        }
    }

    @Test
    void testModificarGrupo() {
        GrupoDTO grupo = new GrupoDTO(101, "Grupo Modificado", 4567, 1, 1, 1);
        try {
            boolean resultado = grupoDAO.modificarGrupo(grupo);
            assertTrue(resultado, "El grupo debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el grupo: " + e.getMessage());
        }
    }

    @Test
    void testBuscarGrupoPorNRC() {
        int NRC = 101;
        GrupoDTO grupo = grupoDAO.buscarGrupoPorNRC(NRC);
        assertNotNull(grupo, "El grupo no debería ser nulo.");
        assertEquals(NRC, grupo.getNRC(), "El NRC del grupo debería coincidir.");
    }

    @Test
    void testMostrarGruposActivos() {
        GrupoDTO grupo = grupoDAO.mostrarGruposActivos();
        assertNotNull(grupo, "El grupo activo no debería ser nulo.");
        assertEquals(1, grupo.getEstadoActivo(), "El estado activo del grupo debería ser 1.");
    }
}