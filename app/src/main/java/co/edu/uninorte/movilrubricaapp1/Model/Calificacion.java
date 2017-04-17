package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/16/2017.
 */

public class Calificacion extends SugarRecord {

    Float nota;
    Evaluacion evaluacion;
    Estudiante estudiante;

    public Calificacion() {

    }

    public Calificacion(float nota, Evaluacion eval, Estudiante student) {
        this.nota = nota;
        this.evaluacion = eval;
        this.estudiante = student;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }


}
