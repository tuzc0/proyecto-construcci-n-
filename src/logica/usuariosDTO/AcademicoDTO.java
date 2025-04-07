package logica.usuariosDTO;

public class AcademicoDTO extends UsuarioDTO {

    private int numeroDePersonal;

    public AcademicoDTO() {

    }

    public AcademicoDTO(int numeroDePersonal, int idUsuario, String nombre, String apellido) {

        super(idUsuario, nombre, apellido);
        this.numeroDePersonal = numeroDePersonal;
    }

    public int getNumeroDePersonal() {

        return numeroDePersonal;
    }

    public void setNumeroDePersonal(int numeroDePersonal) {

        this.numeroDePersonal = numeroDePersonal;
    }
}
