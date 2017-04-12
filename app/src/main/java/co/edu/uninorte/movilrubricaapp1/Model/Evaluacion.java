package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Evaluacion extends SugarRecord {

    Rubrica rubric;
    Float nota;
    ArrayList<CalCategoria> calCategoriaArray;

    //creacion de calcategoria FALTA
    public Evaluacion() {
    }

    public Evaluacion(Rubrica rubric) {
        this.rubric = rubric;

    }

}
