package logica.usuariosDTO;

public class CoordinadorDTO extends UsuarioDTO {

    private int NumeroDePersonal;
    private int idUsuario;

    public CoordinadorDTO() {

    }


    public CoordinadorDTO(int numeroDePersonal, int idUsuario, String nombre, String apellido, int estadoActivo) {

        super(idUsuario, nombre, apellido, estadoActivo);
        this.NumeroDePersonal = numeroDePersonal;
        this.idUsuario = idUsuario;
    }

    public int getNumeroDePersonal() {

        return NumeroDePersonal;
    }

    public void setNumeroDePersonal(int numeroDePersonal) {

        this.NumeroDePersonal = numeroDePersonal;
    }

    public int getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {

        this.idUsuario = idUsuario;
    }


}