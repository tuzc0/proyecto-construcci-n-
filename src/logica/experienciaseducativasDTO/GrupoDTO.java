package logica.experienciaseducativasDTO;

public class GrupoDTO {

    private int NRC;
    private String nombre;

    public GrupoDTO() {

    }

    public GrupoDTO(int NRC, String nombre) {

        this.NRC = NRC;
        this.nombre = nombre;
    }

    public int getNRC() {

        return NRC;
    }

    public void setNRC(int NRC) {

        this.NRC = NRC;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Grupo " + "NRC = " + NRC + ", nombre = '" + nombre + '\'' ;
    }
}
