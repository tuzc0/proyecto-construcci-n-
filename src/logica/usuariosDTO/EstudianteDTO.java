package logica.usuariosDTO;

public class EstudianteDTO extends UsuarioDTO {

    private String matricula;

    public EstudianteDTO() {

    }

    public EstudianteDTO(String matricula) {
        this.matricula = "-1";
    }

    public EstudianteDTO(String nombre, int idUsuario, String apellido, String matricula) {
        super(idUsuario, nombre, apellido);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matriculaEstudiante) {
        this.matricula = matriculaEstudiante;
    }
}
