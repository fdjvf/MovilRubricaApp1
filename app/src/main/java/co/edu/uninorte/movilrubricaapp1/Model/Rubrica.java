package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Rubrica extends SugarRecord {
    public static ObservableArrayList<Object> list = new ObservableArrayList<>();
    //    final static private boolean t = list.addAll(Rubrica.listAll(Rubrica.class));
    String name;
    String descripcion;
    ArrayList<Categoria> categoriaArray;
    int niveles;

    public List<Categoria> getCategorias(){
        return Categoria.find(Categoria.class, "rubrica = ?", String.valueOf(this.getId()));
    }

    public Rubrica() {
    }

    public Rubrica(String name, ArrayList<Categoria> categoriaArray, int niveles, String descripcion) {
        this.name = name;
        this.categoriaArray = categoriaArray;
        this.niveles = niveles;
        this.descripcion = descripcion;
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

    public ArrayList<Categoria> getCategoriaArray() {
        return categoriaArray;
    }

    public void setCategoriaArray(ArrayList<Categoria> categoriaArray) {
        this.categoriaArray = categoriaArray;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public void Save() {
        list.add(this);
        this.save();
    }

}
