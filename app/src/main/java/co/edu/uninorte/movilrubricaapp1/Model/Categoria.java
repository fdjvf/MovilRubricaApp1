package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Categoria extends SugarRecord {

    public Rubrica rubrica;
    public ObservableArrayList<Object> ObservableListElements;
    public boolean Selected = false;

    String name;
    String descripcion;

    public Categoria() {

    }

    public Categoria(String name, String descripcion, Rubrica rubrica1) {
        this.name = name;
        this.descripcion = descripcion;
        this.rubrica = rubrica1;

    }

    public String getName() {
        return name;
    }//Implementar Binding tWO wAY

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Elemento> getElementos() {
        List<Elemento> elementos = Elemento.find(Elemento.class, "categoria = ?", String.valueOf(this.getId()));
        ObservableListElements.addAll(elementos);
        return elementos;
    }

    public void Save() {

        rubrica.ObservableListRubricaCategorias.add(this);
        this.save();
    }
}
