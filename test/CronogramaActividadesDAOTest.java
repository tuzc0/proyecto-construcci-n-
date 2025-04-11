
import accesoadatos.CronogramaActividadesDAO;
import logica.actividadesDTO.CronogramaActividadesDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class CronogramaActividadesDAOTest {

    private CronogramaActividadesDAO cronogramaDAO;

    @BeforeEach
    void setUp() {
        cronogramaDAO = new CronogramaActividadesDAO();
    }

    @Test
    void testCrearNuevoCronogramaDeActividades() {
        CronogramaActividadesDTO cronograma = new CronogramaActividadesDTO(0, Timestamp.valueOf("2023-01-01 00:00:00"),
                Timestamp.valueOf("2023-12-31 23:59:59"), "zs2301234");
        try {
            boolean resultado = cronogramaDAO.crearNuevoCronogramaDeActividades(cronograma);
            assertTrue(resultado, "El cronograma debería haberse creado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al crear el cronograma: " + e.getMessage());
        }
    }

    @Test
    void testModificarCronogramaDeActividades() {
        CronogramaActividadesDTO cronograma = new CronogramaActividadesDTO(1, Timestamp.valueOf("2023-02-01 00:00:00"),
                Timestamp.valueOf("2023-11-30 23:59:59"), "zs2301234 ");
        try {
            boolean resultado = cronogramaDAO.modificarCronogramaDeActividades(cronograma);
            assertTrue(resultado, "El cronograma debería haberse modificado correctamente.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al modificar el cronograma: " + e.getMessage());
        }
    }

    @Test
    void testBuscarCronogramaDeActividadesPorID() {
        try {
            CronogramaActividadesDTO cronograma = cronogramaDAO.buscarCronogramaDeActividadesPorID(1);
            assertNotNull(cronograma, "El cronograma no debería ser nulo.");
            assertEquals(1, cronograma.getIDCronograma(), "El ID del cronograma no coincide.");
        } catch (SQLException e) {
            fail("Se produjo una excepción al buscar el cronograma: " + e.getMessage());
        }
    }
}