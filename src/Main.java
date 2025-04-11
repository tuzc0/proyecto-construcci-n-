

import logica.usuariosDTO.EstudianteDTO;
import accesoadatos.EstudianteDAO;

public class Main {

    public static void main(String[] args) {
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        try {
            // Test insertarEstudiante
            EstudianteDTO nuevoEstudiante = new EstudianteDTO(1, "John", "Doe", "12345", 1);
            boolean insertado = estudianteDAO.insertarEstudiante(nuevoEstudiante);
            System.out.println("Estudiante insertado: " + insertado);

            // Test modificarEstudiante
            EstudianteDTO estudianteModificado = new EstudianteDTO(1, "Jane", "Smith", "12345", 1);
            boolean modificado = estudianteDAO.modificarEstudiante(estudianteModificado);
            System.out.println("Estudiante modificado: " + modificado);

            // Test buscarEstudiantePorMatricula
            EstudianteDTO estudianteEncontrado = estudianteDAO.buscarEstudiantePorMatricula("12345");
            System.out.println("Estudiante encontrado: " + estudianteEncontrado);

            // Test eliminarEstudiantePorMatricula
            boolean eliminado = estudianteDAO.eliminarEstudiantePorMatricula(0, "12345");
            System.out.println("Estudiante eliminado (desactivado): " + eliminado);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}