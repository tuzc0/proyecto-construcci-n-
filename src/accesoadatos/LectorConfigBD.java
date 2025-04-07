package accesoadatos;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class LectorConfigBD {

    Properties propiedades = new Properties();
    String url;
    String usuario;
    String contraseña;

    public LectorConfigBD() {

        try (InputStream lector = new FileInputStream("config.properties")){

            propiedades.load(lector);
            url = propiedades.getProperty("url");
            usuario = propiedades.getProperty("usuario");
            contraseña = propiedades.getProperty("password");

        } catch (IOException e) {

            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
