package co.edu.uninorte.movilrubricaapp1.Model;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class CalCategoria {
    Float notaCategoria;
    Float peso;
    Categoria categoria;
    ArrayList<CalElemento> calElementoArray;

    public CalCategoria() {
    }

    public CalCategoria(Float nota, Categoria categoria, ArrayList<CalElemento> calElementoArray) {
        this.notaCategoria = nota;
        this.categoria = categoria;
        this.calElementoArray = calElementoArray;
    }


}
