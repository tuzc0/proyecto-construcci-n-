package logica.evaluacionesDTO;

import java.sql.Timestamp;

public class AutoevaluacionDTO {

    private int IDAutoevaluacion;
    private Timestamp fecha;
    private String lugar;
    private int calificacionFinal;

    public AutoevaluacionDTO() {

    }

    public AutoevaluacionDTO(int IDAutoevaluacion, Timestamp fecha, String lugar, int calificacionFinal) {

        this.IDAutoevaluacion = IDAutoevaluacion;
        this.fecha = fecha;
        this.lugar = lugar;
        this.calificacionFinal = calificacionFinal;
    }

    public int getIDAutoevaluacion() {

        return IDAutoevaluacion;
    }

    public void setIDAutoevaluacion(int IDAutoevaluacion) {

        this.IDAutoevaluacion = IDAutoevaluacion;
    }

    public Timestamp getFecha() {

        return fecha;
    }

    public void setFecha(Timestamp fecha) {

        this.fecha = fecha;
    }

    public String getLugar() {

        return lugar;
    }

    public void setLugar(String lugar) {

        this.lugar = lugar;
    }

    public int getCalificacionFinal() {

        return calificacionFinal;
    }

    public void setCalificacionFinal(int calificacionFinal) {

        this.calificacionFinal = calificacionFinal;
    }
}
