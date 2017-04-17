package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/12/2017.
 */

public class InfoNivel extends SugarRecord {
    String descripcion;
    int nivel;
    Elemento elemento;

    public InfoNivel(String descripcion, int nivel) {
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public InfoNivel() {

    }


}
