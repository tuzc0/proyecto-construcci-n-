package logica.ovsDTO;

public class OvDTO {

    private int IdOV;
    private String nombre;
    private String direccion;
    private String correo;
    private String numeroDeContacto;

    public OvDTO() {

    }

    public OvDTO(int IdOV, String nombre, String direccion, String correo, String numeroDeContacto) {

        this.IdOV = IdOV;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.numeroDeContacto = numeroDeContacto;
    }

    public int getIdOV() {

        return IdOV;
    }

    public void setIdOV(int IdOV) {

        this.IdOV = IdOV;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public String getCorreo() {

        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public String getNumeroDeContacto() {

        return numeroDeContacto;
    }

    public void setNumeroDeContacto(String numeroDeContacto) {

        this.numeroDeContacto = numeroDeContacto;
    }

    @Override
    public String toString() {
        return "Ov " + "IdOV = " + IdOV + ", nombre = '" + nombre + '\'' + ", correo = '" + correo + '\'' + ", numeroDeContacto = '" + numeroDeContacto;
    }
}
