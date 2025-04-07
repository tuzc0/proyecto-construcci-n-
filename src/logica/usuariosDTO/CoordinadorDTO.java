package logica.usuariosDTO;

public class CoordinadorDTO extends UsuarioDTO {

    private int NumeroDePersonal;

    public CoordinadorDTO() {

    }

    public CoordinadorDTO(int numeroDePersonal, int idUsuario, String nombre, String apellido) {

        super(idUsuario, nombre, apellido);
        this.NumeroDePersonal = numeroDePersonal;
    }

    public int getNumeroDePersonal() {

        return NumeroDePersonal;
    }

    public void setNumeroDePersonal(int numeroDePersonal) {

        this.NumeroDePersonal = numeroDePersonal;
    }
}