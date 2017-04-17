package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarApp;
import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class CalElemento extends SugarRecord {
    Elemento elemento;
    Float notaElemento;
    CalCategoria calCategoria;

    public CalElemento() {
    }

    public CalElemento(Elemento elemento, Float notaElemento) {
        this.elemento = elemento;
        this.notaElemento = notaElemento;
    }
}
