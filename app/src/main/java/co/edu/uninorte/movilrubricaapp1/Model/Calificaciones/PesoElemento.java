package co.edu.uninorte.movilrubricaapp1.Model.Calificaciones;

import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/16/2017.
 */

public class PesoElemento extends SugarRecord {


  public PesoCategoria pesoCategoria;
    String Peso;

    public PesoElemento(float Peso) {


    }

    public PesoElemento() {

    }

    public String getPeso() {
        return String.valueOf(Peso);
    }

    public void setPeso(String peso) {
        Peso = peso;
    }


}
