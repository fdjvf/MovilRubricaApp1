package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by fdjvf on 4/16/2017.
 */

public class PesoRubrica extends SugarRecord {

    Rubrica rubrica;

    public List<PesoCategoria> getPesosCategoria() {

        return PesoCategoria.find(PesoCategoria.class, "pesoRubrica = ?", String.valueOf(this.getId()));

    }


}
