package co.edu.uninorte.movilrubricaapp1.Model.Calificaciones;

import com.orm.SugarRecord;

import java.util.List;

import co.edu.uninorte.movilrubricaapp1.Model.Evaluacion;

/**
 * Created by fdjvf on 4/16/2017.
 */

public class PesoRubrica extends SugarRecord {

    Evaluacion evaluacion;

    public PesoRubrica() {

    }

    public List<PesoCategoria> getPesosCategoria() {

        return PesoCategoria.find(PesoCategoria.class, "pesoRubrica = ?", String.valueOf(this.getId()));

    }


}
