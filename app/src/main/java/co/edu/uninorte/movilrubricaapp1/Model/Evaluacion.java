package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Evaluacion extends SugarRecord {

    Rubrica rubric;
    Float nota;
    ArrayList<CalCategoria> calCategoriaArray;
    Asignatura asignatura;
    Estudiante estudiante;

    List<CalCategoria> getCalCategorias(){
        return CalCategoria.find(CalCategoria.class, "evaluacion = ?", String.valueOf(this.getId()));
    }
    //creacion de calcategoria FALTA
    public Evaluacion() {
    }

    public Evaluacion(Rubrica rubric) {
        this.rubric = rubric;

    }

}
