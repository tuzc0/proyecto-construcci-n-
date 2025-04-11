package logica.usuariosDTO;

public class UsuarioDTO {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private boolean estado;

    public UsuarioDTO() {

    }

    public UsuarioDTO(int idUsuario, String nombre, String apellido, boolean estado) {

        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
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

    public boolean getEstado() {

        return estado;
    }

    public void setEstado(boolean estado) {

        this.estado = estado;
    }
}
