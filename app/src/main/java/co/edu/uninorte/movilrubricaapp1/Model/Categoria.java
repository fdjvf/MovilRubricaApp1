package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Categoria extends SugarRecord {
    String name;
    String descripcion;
    ArrayList<Elemento> elementoArray;
    Float peso;

    public Categoria() {

    }

    public Categoria(String name, String descripcion, ArrayList<Elemento> elementoArray, Float peso) {
        this.name = name;
        this.descripcion = descripcion;
        this.elementoArray = elementoArray;
        this.peso = peso;
    }
}
