package logica.usuariosDTO;

public class UsuarioDTO {

    private int idUsuario;
    private String nombre;
    private String apellido;

    public UsuarioDTO() {

    }

    public UsuarioDTO(int idUsuario, String nombre, String apellido) {

        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(int IDUsuario) {

        this.idUsuario = IDUsuario;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }
}
