package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Elemento extends SugarRecord {
    String name;
    Float peso;
    String descripcion;
    ArrayList<InfoNivel> niveldescripcion;


    Categoria categoria;
    public List<InfoNivel> getInfoNivel(){
        return InfoNivel.find(InfoNivel.class,"elemento = ?",String.valueOf(this.getId()));
    }
    public Elemento() {
    }

    public Elemento(String name, Float peso, String descripcion) {
        this.name = name;
        this.peso = peso;
        this.descripcion = descripcion;
    }
}
