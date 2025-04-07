package logica.actividadesDTO;

import java.sql.Timestamp;

public class ActividadDTO {

    private int IDActividad;
    private String hitos;
    private Timestamp fechaFin;
    private Timestamp fechaInicio;
    private String duracion;
    private String nombre;

    public ActividadDTO() {

    }

    public ActividadDTO(int IDActividad, String hitos, Timestamp fechaFin, Timestamp fechaInicio, String duracion, String nombre) {

        this.IDActividad = IDActividad;
        this.hitos = hitos;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.nombre = nombre;
    }

    public int getIDActividad() {

        return IDActividad;
    }

    public void setIDActividad(int IDActividad) {

        this.IDActividad = IDActividad;
    }

    public String getHitos() {

        return hitos;
    }

    public void setHitos(String hitos) {

        this.hitos = hitos;
    }

    public Timestamp getFechaFin() {

        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {

        this.fechaFin = fechaFin;
    }

    public Timestamp getFechaInicio() {

        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {

        this.fechaInicio = fechaInicio;
    }

    public String getDuracion() {

        return duracion;
    }

    public void setDuracion(String duracion) {

        this.duracion = duracion;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
}
