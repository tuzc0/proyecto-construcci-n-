package logica.experienciaseducativasDTO;

public class PeriodoDTO {

    private int IDPeriodo;
    private String descripcion;

    public PeriodoDTO() {

    }

    public PeriodoDTO(int IDPeriodo, String descripcion) {

        this.IDPeriodo = IDPeriodo;
        this.descripcion = descripcion;
    }

    public int getIDPeriodo() {

        return IDPeriodo;
    }

    public void setIDPeriodo(int IDPeriodo) {

        this.IDPeriodo = IDPeriodo;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    @Override
    public String toString() {

        return "Periodo " + "IDPeriodo = " + IDPeriodo + ", descripcion = '" + descripcion + '\'' ;
    }
}
