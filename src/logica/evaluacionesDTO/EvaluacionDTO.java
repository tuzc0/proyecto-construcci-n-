package logica.evaluacionesDTO;

public class EvaluacionDTO {

    private int IDEvaluacion;
    private String comentario;
    private int calificacion;

    public EvaluacionDTO() {

    }

    public EvaluacionDTO(int IDEvaluacion, String comentario, int calificacion) {

        this.IDEvaluacion = IDEvaluacion;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getIDEvaluacion() {

        return IDEvaluacion;
    }

    public void setIDEvaluacion(int IDEvaluacion) {

        this.IDEvaluacion = IDEvaluacion;
    }

    public String getComentario() {

        return comentario;
    }

    public void setComentario(String comentario) {

        this.comentario = comentario;
    }

    public int getCalificacion() {

        return calificacion;
    }

    public void setCalificacion(int calificacion) {

        this.calificacion = calificacion;
    }
}
