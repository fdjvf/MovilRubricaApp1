package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Categoria extends SugarRecord {
    public static ObservableArrayList<Object> list = new ObservableArrayList<>();
    public boolean Selected = false;
    String name;
    String descripcion;
    ArrayList<Elemento> elementoArray;

    public Categoria() {

    }

    public Categoria(String name, String descripcion, ArrayList<Elemento> elementoArray) {
        this.name = name;
        this.descripcion = descripcion;
        this.elementoArray = elementoArray;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void Save() {
        list.add(this);
        this.save();
    }
}
