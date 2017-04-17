package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class CalCategoria extends SugarRecord {
    Float notaCategoria;
    Float peso;
    Categoria categoria;
    ArrayList<CalElemento> calElementoArray;

    Evaluacion evaluacion;

    public List<CalElemento> getcalElementos(){
        return CalElemento.find(CalElemento.class, "calCategoria = ?", String.valueOf(this.getId()));
    }

    public CalCategoria() {
    }

    public CalCategoria(Float nota, Categoria categoria, ArrayList<CalElemento> calElementoArray) {
        this.notaCategoria = nota;
        this.categoria = categoria;
        this.calElementoArray = calElementoArray;
    }


}
