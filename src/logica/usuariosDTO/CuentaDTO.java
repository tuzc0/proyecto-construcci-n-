package logica.usuariosDTO;

public class CuentaDTO {

    private String correoElectronico;
    private String contrasena;

    public CuentaDTO() {

    }

    public CuentaDTO(String correoElectronico) {

        this.correoElectronico = "-1";
    }

    public CuentaDTO(String correoElectronico, String contrasena) {

        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {

        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {

        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {

        return contrasena;
    }

    public void setContrasena(String contrasena) {

        this.contrasena = contrasena;
    }
}
