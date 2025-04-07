package logica.proyectosDTO;

public class ProyectoDTO {

    private int IDProyecto;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;


    public ProyectoDTO() {

    }

    public ProyectoDTO(int IDProyecto, String nombre, String descripcion, String fechaInicio, String fechaFin) {

        this.IDProyecto = IDProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIDProyecto() {

        return IDProyecto;
    }
    public void setIDProyecto(int IDProyecto) {

        this.IDProyecto = IDProyecto;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getFechaInicio() {

        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {

        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {

        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {

        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {

        return "Proyecto " + "IDProyecto = " + IDProyecto + ", nombre = '" + nombre + '\'' + ", descripcion = '" + descripcion + '\'' + ", fechaInicio = '" + fechaInicio + '\'' + ", fechaFin = '" + fechaFin;
    }
}
