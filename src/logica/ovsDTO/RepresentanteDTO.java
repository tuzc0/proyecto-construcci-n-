package logica.ovsDTO;

public class RepresentanteDTO {

    private int IDRepresentante;
    private String correo;
    private String telefono;
    private String nombre;
    private String apellidos;

    public RepresentanteDTO() {
    }

    public RepresentanteDTO(int IDRepresentante, String correo, String telefono, String nombre, String apellidos) {
        this.IDRepresentante = IDRepresentante;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIDRepresentante() {
        return IDRepresentante;
    }

    public void setIDRepresentante(int IDRepresentante) {
        this.IDRepresentante = IDRepresentante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Representante{" +
                "IDRepresentante=" + IDRepresentante + ", correo='" + correo + '\'' + ", telefono='" + telefono + '\'' +
                ", nombre='" + nombre + '\'' + ", apellidos='" + apellidos;
    }
}
