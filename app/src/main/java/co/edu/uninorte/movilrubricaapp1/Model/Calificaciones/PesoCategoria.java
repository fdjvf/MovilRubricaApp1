package co.edu.uninorte.movilrubricaapp1.Model.Calificaciones;

import com.orm.SugarRecord;

import java.util.List;

import co.edu.uninorte.movilrubricaapp1.Model.Categoria;

/**
 * Created by fdjvf on 4/16/2017.
 */

public class PesoCategoria extends SugarRecord {

    Categoria categoria;

    String Peso;

    public PesoCategoria() {

    }

    public PesoCategoria(String peso) {
        this.Peso = peso;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public List<PesoElemento> getPesoElemento() {
        return PesoElemento.find(PesoElemento.class, "pesoCategoria = ?", String.valueOf(this.getId()));
    }


}
