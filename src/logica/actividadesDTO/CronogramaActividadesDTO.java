package logica.actividadesDTO;

import java.sql.Timestamp;

public class CronogramaActividadesDTO {

    private int IDCronograma;
    private Timestamp fechaInicio;
    private Timestamp fechaFinal;

    public CronogramaActividadesDTO() {

    }

    public CronogramaActividadesDTO(int IDCronograma, Timestamp fechaInicio, Timestamp fechaFinal) {

        this.IDCronograma = IDCronograma;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getIDCronograma() {

        return IDCronograma;
    }

    public void setIDCronograma(int IDCronograma) {

        this.IDCronograma = IDCronograma;
    }

    public Timestamp getFechaInicio() {

        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {

        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFinal() {

        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {

        this.fechaFinal = fechaFinal;
    }
}
