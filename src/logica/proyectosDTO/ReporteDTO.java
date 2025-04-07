package logica.proyectosDTO;

public class ReporteDTO {

    private int IDReporte;
    private int numeroHoras;
    private String metodologia;
    private String observaciones;


    public ReporteDTO() {

    }

    public ReporteDTO(int IDReporte, int numeroHoras, String metodologia, String observaciones) {

        this.IDReporte = IDReporte;
        this.numeroHoras = numeroHoras;
        this.metodologia = metodologia;
        this.observaciones = observaciones;
    }

    public int getIDReporte() {

        return IDReporte;
    }

    public void setIDReporte(int IDReporte) {

        this.IDReporte = IDReporte;
    }

    public int getNumeroHoras() {

        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {

        this.numeroHoras = numeroHoras;
    }

    public String getMetodologia() {

        return metodologia;
    }

    public void setMetodologia(String metodologia) {

        this.metodologia = metodologia;
    }

    public String getObservaciones() {

        return observaciones;
    }

    public void setObservaciones(String observaciones) {

        this.observaciones = observaciones;
    }

    @Override
    public String toString() {

        return "Reporte " + "IDReporte = " + IDReporte + ", numeroHoras = " + numeroHoras + ", metodologia = '" + metodologia + '\'' + ", observaciones = '" + observaciones + '\'' ;
    }


}
